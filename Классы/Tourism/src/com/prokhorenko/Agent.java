package com.prokhorenko;

import java.util.ArrayList;
import java.util.Collections;

public class Agent {
    private String name;
    private ArrayList<Tour> tours = new ArrayList<>();

    public Agent(String name) {
        this.name = name;
    }

    public void add(Tour tour){
        tours.add(tour);
    }

    public void sort() {
        Collections.sort(tours);
    }

    public Tour find(String tName){
        for (Tour tour:tours) {
            if(tour.getTourName().equals(tName)){
                return tour;
            }
        }
        return null;
    }

    public ArrayList selectionByType(TourType tourType){
        ArrayList<Tour> list= new ArrayList<>();
        for (Tour tour:tours) {
            if(tour.getTourType()==tourType)
                list.add(tour);
        }
        return list;
    }

    public ArrayList selectionByTransport(Transport transport){
        ArrayList<Tour> list= new ArrayList<>();
        for (Tour tour:tours) {
            if(tour.getTransport()==transport)
                list.add(tour);
        }
        return list;
    }


    @Override
    public String toString() {
        return "Agent{" +
                "name='" + name + '\'' +
                ", tours=" + tours +
                '}';
    }
}
