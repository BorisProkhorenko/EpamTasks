package com.prokhorenko;

public class Wheel {

    private int id;

    public Wheel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "id=" + id +
                '}';
    }
}
