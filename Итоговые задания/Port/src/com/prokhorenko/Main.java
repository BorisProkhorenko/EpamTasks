package com.prokhorenko;

public class Main {


    public static void main(String[] args) {

        Port port = new Port(2, 200, 100);
        Ship ship1 = new Ship("Black Pearl", port, 20, true);
        Ship ship2 = new Ship("Flying Dutchman", port, 100, false);
        Ship ship3 = new Ship("Queen Anne's Revenge", port, 750, true);

        port.startPort();
        Thread threadShip = new Thread(ship1);
        Thread threadShip2 = new Thread(ship2);
        Thread threadShip3 = new Thread(ship3);
        threadShip.start();
        threadShip2.start();
        threadShip3.start();
    }
}
