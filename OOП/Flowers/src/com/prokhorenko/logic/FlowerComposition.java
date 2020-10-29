package com.prokhorenko.logic;

import com.prokhorenko.flowers.*;
import com.prokhorenko.wrappings.Common;
import com.prokhorenko.wrappings.Wrapping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/*
Задача 5.
Создать консольное приложение, удовлетворяющее следующим требованиям:
• Корректно спроектируйте и реализуйте предметную область задачи.
• Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов
проектирования.
• Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
• для проверки корректности переданных данных можно применить регулярные выражения.
• Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
• Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().
Вариант A. Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции
(объект, представляющий собой цветочную композицию). Составляющими цветочной композиции являются цветы
и упаковка.
 */

public class FlowerComposition implements Serializable {
    private int id;
    private ArrayList<Flower> flowers = new ArrayList<>();
    private Wrapping wrapping = new Common();//default wrapping
    private double totalCost;

    public void findTotalCost() {
        for (Flower flower : flowers) {
            totalCost += flower.getPrice();
        }
        totalCost += wrapping.getPrice();
    }

    public int flowersCount(Flower flower) {
        int count = 0;
        for (Flower tempFlower : flowers) {
            if (tempFlower.equals(flower)) {
                count++;
                if (!tempFlower.equals(flower)) {
                    return count;
                }
            }

        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowerComposition that = (FlowerComposition) o;
        return id == that.id &&
                Double.compare(that.totalCost, totalCost) == 0 &&
                Objects.equals(flowers, that.flowers) &&
                Objects.equals(wrapping, that.wrapping);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flowers, wrapping, totalCost);
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void printComposition() {
        System.out.println("Id  - " + id + "\nflowers:" +
                "\nChamomiles - " + flowersCount(new Chamomile()) +
                "\nCornflowers - " + flowersCount(new Cornflower()) +
                "\nPeonies - " + flowersCount(new Peony()) +
                "\nRoses - " + flowersCount(new Rose()) +
                "\nTulips - " + flowersCount(new Tulip()) +
                "\nWrapping - " + wrapping.getName()+
                "\nTotal Price: " + totalCost);

    }

    public double getTotalCost() {
        return totalCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(ArrayList<Flower> flowers) {
        this.flowers = flowers;
        findTotalCost();
    }

    public Wrapping getWrapping() {
        return wrapping;
    }

    public void setWrapping(Wrapping wrapping) {
        this.wrapping = wrapping;
        findTotalCost();
    }

    @Override
    public String toString() {
        return "FlowerComposition{" +
                "id=" + id +
                ", flowers=" + flowers +
                ", wrapping=" + wrapping +
                ", totalCost=" + totalCost +
                '}';
    }
}
