package com.prokhorenko;

import java.util.Objects;

public class Ship implements Runnable {

    final int MAX_CONTAINERS_COUNT;
    private String name;
    private Port port;
    private int containersCount;

    public Ship(String name, Port port, int MAX_CONTAINERS_COUNT, boolean isEmpty) {
        this.name = name;
        this.port = port;
        this.MAX_CONTAINERS_COUNT = MAX_CONTAINERS_COUNT;
        if (isEmpty) {
            containersCount = 0;
        } else {
            containersCount = MAX_CONTAINERS_COUNT;
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);                 // Ship floats in sea
        } catch (InterruptedException ex) {
        }
        port.addShipToQueue(this);


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public int getContainersCount() {
        return containersCount;
    }

    public void setContainersCount(int containersCount) {
        this.containersCount = containersCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return MAX_CONTAINERS_COUNT == ship.MAX_CONTAINERS_COUNT &&
                containersCount == ship.containersCount &&
                Objects.equals(name, ship.name) &&
                Objects.equals(port, ship.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MAX_CONTAINERS_COUNT, name, port, containersCount);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "MAX_CONTAINERS_COUNT=" + MAX_CONTAINERS_COUNT +
                ", name='" + name + '\'' +
                ", port=" + port +
                ", containersCount=" + containersCount +
                '}';
    }
}
