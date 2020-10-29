package com.prokhorenko.classes;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/*
Задача 4.
Создать консольное приложение, удовлетворяющее следующим требованиям:
• Приложение должно быть объектно-, а не процедурно-ориентированным.
• Каждый класс должен иметь отражающее смысл название и информативный состав.
• Наследование должно применяться только тогда, когда это имеет смысл.
• При кодировании должны быть использованы соглашения об оформлении кода java code convention.
• Классы должны быть грамотно разложены по пакетам.
• Консольное меню должно быть минимальным.
• Для хранения данных можно использовать файлы.
Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и
выбора сокровищ на заданную сумму.
 */

public class Cave implements Serializable {
    private String nameOfCave;
    private ArrayList<Treasure> dragonTreasures;
    private Treasure theMastExpensive;

    public Cave(String nameOfCave, ArrayList<Treasure> dragonTreasures) {
        this.nameOfCave = nameOfCave;
        for (int i = 0; i < dragonTreasures.size(); i++) {
            dragonTreasures.get(i).setId(i + 1);
        }
        this.dragonTreasures = dragonTreasures;
        theMastExpensive = pickTheMostExpensive();
    }

    public void printTreasures() {
        for (Treasure treasure : dragonTreasures) {
            System.out.println(treasure.getId() + ") " + treasure.getName() + " - " + treasure.getPrice() + "$");
        }
    }

    public void printTreasures(ArrayList<Treasure> treasures) {
        for (Treasure treasure : treasures) {
            System.out.println(treasure.getId() + ") " + treasure.getName() + " - " + treasure.getPrice() + "$");
        }
    }

    public Treasure pickTheMostExpensive() {

        Treasure theMostExpensiveTreasure = dragonTreasures.get(0);

        for (int i = 1; i < dragonTreasures.size(); i++) {
            if (Double.compare(theMostExpensiveTreasure.getPrice(), dragonTreasures.get(i).getPrice()) < 0) {
                theMostExpensiveTreasure = dragonTreasures.get(i);
            }
        }
        return theMostExpensiveTreasure;
    }

    public Treasure findTreasureById(int id) {
        for (Treasure treasure : dragonTreasures) {
            if (treasure.getId() == id)
                return treasure;
        }
        return null;
    }

    public void sellTheTreasures(Customer customer) {

        ArrayList<Treasure> purchasedTreasures = new ArrayList<>();
        ArrayList<Treasure> dragonTreasuresCopy = (ArrayList<Treasure>) dragonTreasures.clone();
        Scanner scanner = new Scanner(System.in);
        int id;
        double money = customer.getMoney();

        while (true) {
            printTreasures(dragonTreasuresCopy);
            System.out.println("Pick wanted treasure from the list and enter it's id(number before it's name)");
            id = scanner.nextInt();
            Treasure pickedTreasure = findTreasureById(id);

            if (pickedTreasure == null) {
                System.out.println("Error: Wrong id");
                continue;
            } else if (money - pickedTreasure.getPrice() > 0) {
                purchasedTreasures.add(pickedTreasure);
                dragonTreasuresCopy.remove(pickedTreasure);
                money -= pickedTreasure.getPrice();
                System.out.println("You bought " + "\"" + pickedTreasure.getName() + "\" for " +
                        pickedTreasure.getPrice() + "$");
            } else {
                System.out.println("Not enough money");
            }
            System.out.println("1 - Continue\nOther - quit");
            if (scanner.nextInt() != 1) {
                break;
            }
        }
        customer.setMoney(money);
        customer.setPurchasedTreasures(purchasedTreasures);
    }

    public String getNameOfCave() {
        return nameOfCave;
    }

    public void setNameOfCave(String nameOfCave) {
        this.nameOfCave = nameOfCave;
    }

    public ArrayList<Treasure> getDragonTreasures() {
        return dragonTreasures;
    }

    public void setDragonTreasures(ArrayList<Treasure> dragonTreasures) {
        this.dragonTreasures = dragonTreasures;
    }

    public Treasure getTheMostExpensive() {
        return theMastExpensive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cave cave = (Cave) o;
        return Objects.equals(nameOfCave, cave.nameOfCave) &&
                Objects.equals(dragonTreasures, cave.dragonTreasures) &&
                Objects.equals(theMastExpensive, cave.theMastExpensive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfCave, dragonTreasures, theMastExpensive);
    }

    @Override
    public String toString() {
        return "Cave{" +
                "nameOfCave='" + nameOfCave + '\'' +
                ", dragonTreasures=" + dragonTreasures +
                '}';
    }
}
