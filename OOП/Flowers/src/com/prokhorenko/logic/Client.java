package com.prokhorenko.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Client implements Serializable {
    private String name;
    private ArrayList<FlowerComposition> clientsCompositions;

    public Client(String name) {
        this.name = name;
        clientsCompositions = new ArrayList<>();
    }

    public FlowerComposition createComposition(FlowerCompositionBuilder builder) {
        String[] parameters = new String[6];
        Scanner scanner = new Scanner("7\n10\n0\n 5\n5 \n3");// заглушка
        System.out.println("Enter a number of chamomiles in your composition");
        parameters[0] = "" + scanner.nextInt();
        System.out.println(parameters[0]);
        System.out.println("Enter a number of cornflowers in your composition");
        parameters[1] = "" + scanner.nextInt();
        System.out.println(parameters[1]);
        System.out.println("Enter a number of peonies in your composition");
        parameters[2] = "" + scanner.nextInt();
        System.out.println(parameters[2]);
        System.out.println("Enter a number of roses in your composition");
        parameters[3] = "" + scanner.nextInt();
        System.out.println(parameters[3]);
        System.out.println("Enter a number of tulips in your composition");
        parameters[4] = "" + scanner.nextInt();
        System.out.println(parameters[4]);
        System.out.println("Choose wrapping 1-cheap, 2-common, 3-deluxe");
        parameters[5] = "" + scanner.nextInt();
        System.out.println(parameters[5]);

        return builder.build(parameters);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<FlowerComposition> getClientsCompositions() {
        return clientsCompositions;
    }

    public void setClientsCompositions(ArrayList<FlowerComposition> clientsCompositions) {
        this.clientsCompositions = clientsCompositions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(clientsCompositions, client.clientsCompositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, clientsCompositions);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", purchasedCompositions=" + clientsCompositions +
                '}';
    }
}
