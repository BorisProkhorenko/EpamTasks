package com.prokhorenko;

public class Tour implements Comparable<Tour> {
    private String tourName;
    private String tourProgram;
    private TourType tourType;
    private Transport transport;
    private boolean mealsAreIncluded;
    private double price;

    public Tour(String tourName, String tourProgram, TourType tourType, Transport transport, boolean mealsAreIncluded, double price) {
        this.tourName = tourName;
        this.tourProgram = tourProgram;
        this.tourType = tourType;
        this.transport = transport;
        this.mealsAreIncluded = mealsAreIncluded;
        this.price = price;
    }

    public String getTourName() {
        return tourName;
    }

    public String getTourProgram() {
        return tourProgram;
    }

    public TourType getTourType() {
        return tourType;
    }

    public Transport getTransport() {
        return transport;
    }

    public boolean isMealsAreIncluded() {
        return mealsAreIncluded;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourName='" + tourName + '\'' +
                ", tourProgram='" + tourProgram + '\'' +
                ", tourType=" + tourType +
                ", transport=" + transport +
                ", mealsAreIncluded=" + mealsAreIncluded +
                '}';
    }

    @Override
    public int compareTo(Tour o) {
        return tourName.compareTo(o.tourName);
    }
}
