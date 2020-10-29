package com.prokhorenko;

import java.util.Arrays;

public class State {
    private Region[] regions;
    private City capital;
    private double area = 0;

    public State(Region[] regions, City capital) {
        this.regions = regions;
        this.capital = capital;
        for (int i = 0; i < regions.length; i++) {
            area += regions[i].getArea();
        }
    }

    public void printCapital(){
        System.out.println(capital.getName());
    }
    public void printArea(){
        System.out.println(area);
    }
    public void regionCount(){
        System.out.println(regions.length);
    }
    public void printRegionCenters(){
        for (Region region:regions) {
            System.out.println(region.getDistrictCenter().getName());
        }
    }

    public Region[] getRegions() {
        return regions;
    }

    public void setRegions(Region[] regions) {
        this.regions = regions;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "State{" +
                "regions=" + Arrays.toString(regions) +
                ", capital=" + capital +
                ", area=" + area +
                '}';
    }
}
