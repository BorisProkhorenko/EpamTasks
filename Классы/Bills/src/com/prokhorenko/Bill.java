package com.prokhorenko;

public class Bill implements Comparable<Bill> {
    private long number;
    private double balance;
    private String keeperName;
    private boolean isLocked;

    public Bill(long number, double balance, String keeperName) {
        this.number = number;
        this.balance = balance;
        this.keeperName = keeperName;
        isLocked = false;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getKeeperName() {
        return keeperName;
    }

    public void setKeeperName(String keeperName) {
        this.keeperName = keeperName;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void lock() {
        isLocked = true;
    }

    public void unlock() {
        isLocked = false;
    }


    @Override
    public String toString() {
        return "Bill{" +
                "number=" + number +
                ", balance=" + balance +
                ", keeperName='" + keeperName + '\'' +
                ", isLocked=" + isLocked +
                '}';
    }

    @Override
    public int compareTo(Bill o) {
        if (number > o.getNumber())
            return 1;
        else if (number < o.getNumber())
            return -1;
        else
            return 0;
    }
}
