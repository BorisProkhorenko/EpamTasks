package com.prokhorenko;

import java.util.Objects;

public class Pier extends Thread {

   private Port port;

    Pier(Port port){
        this.port = port;
    }

    @Override
    public void run() {
        System.out.println("Start Pier " + Thread.currentThread().getName());
        while(true){
            try {
                port.performLoadingOperationsAndRemoveFromQueue();
            } catch (InterruptedException ex) {
            }
        }
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pier pier = (Pier) o;
        return Objects.equals(port, pier.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(port);
    }

    @Override
    public String toString() {
        return "Pier{" +
                "port=" + port +
                '}';
    }
}
