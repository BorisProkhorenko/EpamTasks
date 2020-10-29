package com.prokhorenko;

/*
Задача 3.
Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
выходных и праздничных днях.
 */
public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar(2020, DayOfWeek.TUESDAY);
        calendar.printTheCalendar();
        calendar.getMonths();

        calendar.getHolidayAndWeekendManager().addHoliday("January", 1);
        calendar.getHolidayAndWeekendManager().addHoliday("March", 8);
        calendar.getHolidayAndWeekendManager().addHoliday("May", 9);

        calendar.getHolidayAndWeekendManager().printHolidaysAndWeekends();
    }
}
