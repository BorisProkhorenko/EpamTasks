package com.prokhorenko.logic;


import com.prokhorenko.flowers.*;
import com.prokhorenko.wrappings.Cheap;
import com.prokhorenko.wrappings.Common;
import com.prokhorenko.wrappings.Deluxe;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

public class FlowerCompositionBuilder implements Serializable {
    private int id = 1;

    public FlowerComposition build(String[] lines) {
        int[] parameters = testParameters(lines);
        if (parameters == null) {
            System.out.println("Wrong parameters ");
            return null;
        }
        FlowerComposition flowerComposition = new FlowerComposition();
        flowerComposition.setId(id);
        id++;

        addFlowers(parameters[0], new Chamomile(), flowerComposition);
        addFlowers(parameters[1], new Cornflower(), flowerComposition);
        addFlowers(parameters[2], new Peony(), flowerComposition);
        addFlowers(parameters[3], new Rose(), flowerComposition);
        addFlowers(parameters[4], new Tulip(), flowerComposition);
        switch (parameters[5]) {
            case 1:
                flowerComposition.setWrapping(new Cheap());
                break;
            case 3:
                flowerComposition.setWrapping(new Deluxe());
                break;
            default:
                flowerComposition.setWrapping(new Common());
                break;
        }
        return flowerComposition;
    }

    private int[] testParameters(String[] parameters) {
        String test = String.join("", parameters);
        if (Pattern.matches("\\d+", test)) {
            int[] newParameters = {Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]),
                    Integer.parseInt(parameters[2]), Integer.parseInt(parameters[3]), Integer.parseInt(parameters[4]),
                    Integer.parseInt(parameters[5])};
            return newParameters;
        }
        return null;
    }

    private void addFlowers(int count, Flower flower, FlowerComposition flowerComposition) {
        for (int i = 0; i < count; i++) {
            flowerComposition.getFlowers().add(flower);
        }
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
        FlowerCompositionBuilder that = (FlowerCompositionBuilder) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "FlowerCompositionBuilder{" +
                "id=" + id +
                '}';
    }
}
