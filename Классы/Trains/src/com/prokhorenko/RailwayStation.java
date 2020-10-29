package com.prokhorenko;
import java.util.Arrays;

public class RailwayStation {
    private Train[] trains = new Train[5];

    public RailwayStation(Train train1, Train train2, Train train3, Train train4, Train train5) {
        trains[0] = train1;
        trains[1] = train2;
        trains[2] = train3;
        trains[3] = train4;
        trains[4] = train5;
    }

    public void print() {
        for (int i = 0; i < trains.length; i++) {
            System.out.println(trains[i].toString());
        }
    }

    public void numSort() {
        Arrays.sort(trains);
    }

    public void print(int num) {
        for (int i = 0; i < trains.length; i++) {
            if (num == trains[i].getTrainNum())
                System.out.println(trains[i].toString());
        }
    }
    public void nameSort(){
        DestinationComparator destinationComparator = new DestinationComparator();
        Arrays.sort(trains,destinationComparator);
    }
}