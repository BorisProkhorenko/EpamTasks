package com.prokhorenko.wrappings;

import java.io.Serializable;
import java.util.Objects;

public class Wrapping implements Serializable {
    private int typeId;
    private String name;
    private double price;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wrapping wrapping = (Wrapping) o;
        return typeId == wrapping.typeId &&
                Double.compare(wrapping.price, price) == 0 &&
                Objects.equals(name, wrapping.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, name, price);
    }

    @Override
    public String toString() {
        return "Wrapping{" +
                "typeId=" + typeId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
