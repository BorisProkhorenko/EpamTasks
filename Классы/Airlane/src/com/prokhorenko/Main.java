package com.prokhorenko;

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
public class Main {
    public static void main(String[] args) {
        DayOfWeek[] dayOfWeeks1 = {DayOfWeek.MONDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY};
        DayOfWeek[] dayOfWeeks2 = {DayOfWeek.MONDAY, DayOfWeek.THURSDAY, DayOfWeek.SUNDAY};
        DayOfWeek[] dayOfWeeks3 = {DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY};
        Airline airline1 = new Airline("Minsk", "BA 98",
                "Boeing-747", "17.30", dayOfWeeks1);
        Airline airline2 = new Airline("Moscow", "FA 04",
                "Boeing-767", "18.30", dayOfWeeks2);
        Airline airline3 = new Airline("Minsk", "BA 98",
                "Boeing-747", "15.00", dayOfWeeks1);
        Airline airline4 = new Airline("London", "BA 98",
                "Boeing-767", "15.00", dayOfWeeks3);

        Airline[] airlines = {airline1, airline2, airline3, airline4};
        AirlineList airlineList = new AirlineList(airlines);
       // airlineList.destinationSearch("Minsk");
        // airlineList.daySearch(DayOfWeek.MONDAY);
          airlineList.daySearch(DayOfWeek.MONDAY,"16.00");
    }
}
