package com.prokhorenko.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Customer implements Serializable {
    private String name;
    private double money;
    private ArrayList<Treasure> purchasedTreasures=new ArrayList<>();

    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public ArrayList<Treasure> getPurchasedTreasures() {
        return purchasedTreasures;
    }

    public void setPurchasedTreasures(ArrayList<Treasure> purchasedTreasures) {
        this.purchasedTreasures = purchasedTreasures;
    }

    public void menu(Cave cave) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Show the list of treasures\n2 - Find the most expensive treasure" +
                "\n3 - Buy some treasures\n4 - show your purchases");
        int enteredNumber = scanner.nextInt();

        switch (enteredNumber) {
            case 1:
                cave.printTreasures();
                backToMenu(cave);
                break;
            case 2:
                System.out.println(cave.getTheMostExpensive());
                backToMenu(cave);
                break;
            case 3:
                cave.sellTheTreasures(this);
                backToMenu(cave);
                break;
            case 4:
                System.out.println(getPurchasedTreasures());
                backToMenu(cave);
                break;
            default:
                System.out.println("Wrong number");
                backToMenu(cave);
                break;
        }
    }
    private void backToMenu(Cave cave){

        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Back to menu\nOther - quit");

        String answer = scanner.nextLine();

        if (answer.equals("1"))
            menu(cave);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Double.compare(customer.money, money) == 0 &&
                Objects.equals(name, customer.name) &&
                Objects.equals(purchasedTreasures, customer.purchasedTreasures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, purchasedTreasures);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", purchasedTreasures=" + purchasedTreasures +
                '}';
    }
}
