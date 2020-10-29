package com.prokhorenko;

/*
4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
назначения должны быть упорядочены по времени отправления.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Train train1 = new Train("Минск", 150, "17:15");
        Train train2 = new Train("Гомель", 134, "12:45");
        Train train3 = new Train("Гродно", 159, "09:15");
        Train train4 = new Train("Брест", 178, "17:23");
        Train train5 = new Train("Минск", 155, "15:15");

        RailwayStation rw = new RailwayStation(train1, train2, train3, train4, train5);
        rw.print();
        rw.nameSort();
        // rw.print();
        rw.numSort();
        // rw.print();
        // rw.print(150);
        Scanner scanner = new Scanner(System.in);
        rw.print(scanner.nextInt());
    }
}
