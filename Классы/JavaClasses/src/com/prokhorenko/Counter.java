package com.prokhorenko;

public class Counter {

    private int count;
    private int upperLimit;
    private int lowerLimit;

    public Counter(int upperLimit, int lowerLimit) {
        count = (upperLimit + lowerLimit) / 2;
        if (lowerLimit < upperLimit) {
            this.upperLimit = upperLimit;
            this.lowerLimit = lowerLimit;
        } else {
            this.upperLimit = lowerLimit;
            this.lowerLimit = upperLimit;
        }
    }

    public Counter(int count, int upperLimit, int lowerLimit) {
        if (count > lowerLimit)
            this.count = count;
        else
            count = (upperLimit + lowerLimit) / 2;
        if (lowerLimit < upperLimit) {
            this.upperLimit = upperLimit;
            this.lowerLimit = lowerLimit;
        } else {
            this.upperLimit = lowerLimit;
            this.lowerLimit = upperLimit;
        }
    }

    public Counter() {
        count = 0;
        upperLimit = 100;
        lowerLimit = -100;
    }


    public void increment() {
        if (count < upperLimit) {
            count++;
        } else
            System.out.println("Лимит превышен");
    }

    public void decrement() {
        if (count > lowerLimit) {
            count--;
        } else
            System.out.println("Минимальный лимит превышен");
    }

    public void printCount(){
        System.out.println(count);
    }
}
