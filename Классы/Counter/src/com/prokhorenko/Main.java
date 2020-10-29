package com.prokhorenko;

/*
5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
 */
public class Main {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter(0, -50, 50);
        counter1.printCount();
        //counter1.increment();
        // counter1.printCount();
        //  counter1.decrement();
        // counter1.printCount();
      /*  for (int i = 0; i < 115; i++)
            counter1.increment();
        counter1.printCount();
        */

    }
}
