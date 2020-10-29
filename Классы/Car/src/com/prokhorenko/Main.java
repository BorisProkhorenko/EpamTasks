package com.prokhorenko;
/*
2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
менять колесо, вывести на консоль марку автомобиля.
 */
public class Main {
    public static void main(String[] args) {
        Wheel wheel1=new Wheel(1);
        Wheel wheel2=new Wheel(2);
        Wheel wheel3=new Wheel(3);
        Wheel wheel4=new Wheel(4);
        Wheel wheel5=new Wheel(5);
        Engine engine = new Engine("R20A");
        Car car = new Car("Honda Accord v9", wheel1, wheel2,wheel3,wheel4,engine);
        car.drive();
        car.drive();
        car.drive();
        car.fuelTheCar();
        car.changeWheel(3,wheel5);
        System.out.println(car);
        car.printModel();
    }
}
