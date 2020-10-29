package com.prokhorenko;


public class Train implements Comparable<Train> {

    private String destinationName;
    private int trainNum;
    private String departureTime;

    public Train(String destinationName, int trainNum, String departureTime) {
        this.destinationName = destinationName;
        this.trainNum = trainNum;
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "Train{" +
                "destinationName='" + destinationName + '\'' +
                ", trainNum=" + trainNum +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public int getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(int trainNum) {
        this.trainNum = trainNum;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }


    @Override
    public int compareTo(Train train) {
        int num = train.getTrainNum();

        return trainNum - num;
    }
}
