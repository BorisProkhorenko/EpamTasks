package com.prokhorenko;

public class Customer implements Comparable<Customer> {
    private int id;
    private String surname;
    private String name;
    private String thirdName;
    private long cardNumber;
    private long billNumber;

    public Customer(int id, String surname, String name, String thirdName, long cardNumber, long billNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.thirdName = thirdName;
        this.cardNumber = cardNumber;
        this.billNumber = billNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }


    @Override
    public int compareTo(Customer o) {
        return (surname + name + thirdName).compareTo(o.surname + o.name + o.thirdName);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", cardNumber=" + cardNumber +
                ", billNumber=" + billNumber +
                '}';
    }
}
