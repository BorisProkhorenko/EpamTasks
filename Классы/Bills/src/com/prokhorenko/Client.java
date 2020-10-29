package com.prokhorenko;

import java.util.ArrayList;
import java.util.Collections;


public class Client {
    private ArrayList<Bill> bills;
    private int billsCount;
    private String name;

    public Client(String name) {
        this.name = name;
        billsCount = 0;
        bills = new ArrayList<>();
    }

    public ArrayList getBills() {
        return bills;
    }

    public int getBillsCount() {
        return billsCount;
    }

    public String getName() {
        return name;
    }

    public void addBill(long number, double balance) {
        bills.add(new Bill(number, balance, name));
        billsCount++;
    }

    public void sort() {
        Collections.sort(bills);
    }

    public Bill find(long number) {
        sort();
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getNumber() == number)
                return bills.get(i);
        }
        return null;
    }

    public void swapLock(long number) {
        Bill bill = find(number);
        if (bill != null) {
            if (bill.isLocked())
                bill.unlock();
            else
                bill.lock();
        }
    }

    public double sum() {
        double sum = 0;
        for (Bill bill : bills) {
            sum += bill.getBalance();
        }
        return sum;
    }

    public double positiveSum() {
        double sum = 0;
        for (Bill bill : bills) {
            if (bill.getBalance() > 0)
                sum += bill.getBalance();
        }
        return sum;
    }

    public double negativeSum() {
        double sum = 0;
        for (Bill bill : bills) {
            if (bill.getBalance() < 0)
                sum += bill.getBalance();
        }
        return sum;
    }


    @Override
    public String toString() {
        return "Client{" +
                "bills=" + bills +
                ", billsCount=" + billsCount +
                ", name='" + name + '\'' +
                '}';
    }
}
