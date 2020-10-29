package com.prokhorenko;

import java.util.Arrays;

/*
10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
методами. Задать критерии выбора данных и вывести эти данные на консоль.

Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
Найти и вывести:
a) список рейсов для заданного пункта назначения;
b) список рейсов для заданного дня недели;
c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 */
public class AirlineList {
    private Airline[] airlines;

    public AirlineList(Airline[] airlines) {
        this.airlines = airlines;
    }

    public void destinationSearch(String destination) {
        for (Airline airline : airlines) {
            if (airline.getDestination().equals(destination))
                System.out.println(airline);
        }
    }

    public void daySearch(DayOfWeek dayOfWeek) {
        for (Airline airline : airlines) {
            for (DayOfWeek day : airline.getDays()) {
                if (day.equals(dayOfWeek)) {
                    System.out.println(airline);
                    break;
                }
            }
        }
    }

    public void daySearch(DayOfWeek dayOfWeek, String time) {
        for (Airline airline : airlines) {
            for (DayOfWeek day : airline.getDays()) {
                if (day.equals(dayOfWeek) && airline.getTime().compareTo(time) > 0) {
                    System.out.println(airline);
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "AirlineList{" +
                "airlines=" + Arrays.toString(airlines) +
                '}';
    }
}
