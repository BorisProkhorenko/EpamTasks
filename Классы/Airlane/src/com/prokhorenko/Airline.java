package com.prokhorenko;

import java.util.Arrays;

public class Airline {

    private String destination;
    private String number;
    private String type;
    private String time;
    private DayOfWeek[] days;

    public Airline(String destination, String number, String type, String time, DayOfWeek[] days) {
        this.destination = destination;
        this.number = number;
        this.type = type;
        this.time = time;
        this.days = days;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DayOfWeek[] getDays() {
        return days;
    }

    public void setDays(DayOfWeek[] days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination + '\'' +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", days=" + Arrays.toString(days) +
                '}';
    }
}
