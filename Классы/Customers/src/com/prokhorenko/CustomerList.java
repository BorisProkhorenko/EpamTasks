package com.prokhorenko;

import java.util.Arrays;

public class CustomerList {

    private Customer[] customers;

    public CustomerList(Customer[] customers) {
        this.customers = customers;
    }

    public void alphabetSort() {
        Arrays.sort(customers);
    }

    public void alphabetPrint() {
        alphabetSort();
        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i]);
        }
    }

    public void rangePrint(long from, long upTo){
        alphabetSort();
        for (int i = 0; i < customers.length; i++) {
            if(customers[i].getCardNumber()>=from&&customers[i].getCardNumber()<=upTo)
                System.out.println(customers[i]);
        }
    }
}
