package com.prokhorenko;

/*
2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
        менять колесо, вывести на консоль марку автомобиля.
 */

public class Car {

    private String model;
    private Wheel wheel1;
    private Wheel wheel2;
    private Wheel wheel3;
    private Wheel wheel4;
    private Engine engine;
    private int fuel;// в поцентах

    public Car(String model, Wheel wheel1, Wheel wheel2, Wheel wheel3, Wheel wheel4, Engine engine) {
        this.model = model;
        this.wheel1 = wheel1;
        this.wheel2 = wheel2;
        this.wheel3 = wheel3;
        this.wheel4 = wheel4;
        this.engine = engine;
        fuel=100;
    }

    public void drive(){
        if(fuel>0) {
            System.out.println("Машина едет");
            fuel -= 50;
        } else
            System.out.println("Нет топлива");
    }

    public void fuelTheCar(){
        fuel=100;
        System.out.println("Заправка");
    }
    public void changeWheel(int wheelId, Wheel wheel){
        System.out.println("Меняю колесо");
        switch (wheelId){
            case 1: wheel1 = wheel;
                break;
            case 2: wheel2 = wheel;
                break;
            case 3: wheel3 = wheel;
                break;
            case 4: wheel4 = wheel;
                break;
            default:
                System.out.println("Wrong id");
        }
    }

    public void printModel(){
        System.out.println(model);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Wheel getWheel1() {
        return wheel1;
    }

    public void setWheel1(Wheel wheel1) {
        this.wheel1 = wheel1;
    }

    public Wheel getWheel2() {
        return wheel2;
    }

    public void setWheel2(Wheel wheel2) {
        this.wheel2 = wheel2;
    }

    public Wheel getWheel3() {
        return wheel3;
    }

    public void setWheel3(Wheel wheel3) {
        this.wheel3 = wheel3;
    }

    public Wheel getWheel4() {
        return wheel4;
    }

    public void setWheel4(Wheel wheel4) {
        this.wheel4 = wheel4;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getFuel() {
        return fuel;
    }


    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", wheel1=" + wheel1 +
                ", wheel2=" + wheel2 +
                ", wheel3=" + wheel3 +
                ", wheel4=" + wheel4 +
                ", engine=" + engine +
                ", fuel=" + fuel +
                '}';
    }
}
