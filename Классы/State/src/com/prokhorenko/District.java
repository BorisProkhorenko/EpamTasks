package com.prokhorenko;

import java.util.Arrays;

public class District {
    private City[] cities;
    private double area;

    public District(City[] cities, double area) {
        this.cities = cities;
        this.area = area;
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "District{" +
                "cities=" + Arrays.toString(cities) +
                ", area=" + area +
                '}';
    }
}
