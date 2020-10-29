package com.prokhorenko.classes;

import java.io.Serializable;
import java.util.Objects;

public class Treasure implements Serializable {
    private int id;
    private String name;
    private double price;


    public Treasure(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Treasure treasure = (Treasure) o;
        return Double.compare(treasure.price, price) == 0 &&
                id == treasure.id &&
                Objects.equals(name, treasure.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, id);
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
