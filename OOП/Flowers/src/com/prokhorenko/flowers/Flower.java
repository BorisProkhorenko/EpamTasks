package com.prokhorenko.flowers;

import java.io.Serializable;
import java.util.Objects;

public class Flower implements Serializable {
    private String name;
    private double price;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Double.compare(flower.price, price) == 0 &&
                Objects.equals(name, flower.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
