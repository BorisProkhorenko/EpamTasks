package com.prokhorenko;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Port {

    final int MAX_CONTAINERS_COUNT;
    private int containersCount;
    final LinkedList<Ship> shipsQueue;
    final List<Pier> piers;
    private int shipsCount;

    public Port(int piersCount, int MAX_CONTAINERS_COUNT, int containersCount) {
        piers = new ArrayList<>();
        this.MAX_CONTAINERS_COUNT = MAX_CONTAINERS_COUNT;
        this.containersCount = containersCount;
        for (int i = 0; i < piersCount; i++) {
            piers.add(new Pier(this));
        }
        shipsQueue = new LinkedList<>();
        this.shipsCount = 0;
    }

    public void startPort() {
        for (int i = 0; i < piers.size(); i++) {
            piers.get(i).start();
        }
    }

    public void addShipToQueue(Ship ship) {
        synchronized (shipsQueue) {
            while (shipsCount + 1 > piers.size()) {
                try {
                    shipsQueue.wait();
                } catch (InterruptedException ex) {
                }
            }
            shipsQueue.add(ship);
            shipsCount++;
            shipsQueue.notifyAll();
        }

    }

    public void performLoadingOperationsAndRemoveFromQueue() throws InterruptedException {
        Ship ship;
        synchronized (shipsQueue) {
            while (shipsCount == 0) {
                try {
                    shipsQueue.wait();
                } catch (InterruptedException ex) {
                    System.out.println("Interrupted");
                }
            }
            ship = shipsQueue.poll();
            if (ship.getContainersCount() == 0) {
                System.out.println("Start upload empty " + ship.getName() + " " + Thread.currentThread().getName());
                if (!capacityCheck(ship)) {
                    System.out.println("Error: not enough containers in the port");
                } else {
                    ship.setContainersCount(ship.MAX_CONTAINERS_COUNT);
                    Thread.sleep(5000);
                    System.out.println("Ship is uploaded! " + Thread.currentThread().getName());
                }
            } else if (ship.getContainersCount() == ship.MAX_CONTAINERS_COUNT) {
                System.out.println("Start unload " + ship.getName() + " " + Thread.currentThread().getName());
                if (!capacityCheck(ship)) {
                    System.out.println("Error: not enough free space in port");
                } else {
                    ship.setContainersCount(0);
                    Thread.sleep(5000);
                    System.out.println("Ship is unloaded! " + Thread.currentThread().getName());
                }
            }
            shipsCount--;
            shipsQueue.notifyAll();
        }
    }

    private boolean capacityCheck(Ship ship) {
        if (ship.getContainersCount() == 0 && containersCount - ship.MAX_CONTAINERS_COUNT < 0) {
            return false;
        }
        if (ship.getContainersCount() == ship.MAX_CONTAINERS_COUNT
                && containersCount + ship.MAX_CONTAINERS_COUNT > MAX_CONTAINERS_COUNT) {
            return false;
        }
        return true;
    }

    public int getContainersCount() {
        return containersCount;
    }

    public void setContainersCount(int containersCount) {
        this.containersCount = containersCount;
    }

    public int getShipsCount() {
        return shipsCount;
    }

    public void setShipsCount(int shipsCount) {
        this.shipsCount = shipsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Port port = (Port) o;
        return MAX_CONTAINERS_COUNT == port.MAX_CONTAINERS_COUNT &&
                containersCount == port.containersCount &&
                shipsCount == port.shipsCount &&
                Objects.equals(shipsQueue, port.shipsQueue) &&
                Objects.equals(piers, port.piers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MAX_CONTAINERS_COUNT, containersCount, shipsQueue, piers, shipsCount);
    }

    @Override
    public String toString() {
        return "Port{" +
                "MAX_COUNT_CONTAINERS=" + MAX_CONTAINERS_COUNT +
                ", containersCount=" + containersCount +
                ", shipsQueue=" + shipsQueue +
                ", piers=" + piers +
                ", shipsCount=" + shipsCount +
                '}';
    }
}
