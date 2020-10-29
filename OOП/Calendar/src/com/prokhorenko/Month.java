package com.prokhorenko;

import java.util.Arrays;

public class Month {
    private String name;
    private Day[] days;

    public Month(String name, Day[] days) {
        this.name = name;
        this.days = days;
        for (Day day : this.days) {
            day.setMonth(name);
        }
    }

    public DayOfWeek daysOfWeek(DayOfWeek previous) {
        for (Day day : days) {
            switch (previous) {
                case MONDAY:
                    day.setDayOfWeek(DayOfWeek.TUESDAY);
                    previous = DayOfWeek.TUESDAY;
                    break;
                case TUESDAY:
                    day.setDayOfWeek(DayOfWeek.WEDNESDAY);
                    previous = DayOfWeek.WEDNESDAY;
                    break;
                case WEDNESDAY:
                    day.setDayOfWeek(DayOfWeek.THURSDAY);
                    previous = DayOfWeek.THURSDAY;
                    break;
                case THURSDAY:
                    day.setDayOfWeek(DayOfWeek.FRIDAY);
                    previous = DayOfWeek.FRIDAY;
                    break;
                case FRIDAY:
                    day.setDayOfWeek(DayOfWeek.SATURDAY);
                    day.setWeekEnd(true);
                    previous = DayOfWeek.SATURDAY;
                    break;
                case SATURDAY:
                    day.setDayOfWeek(DayOfWeek.SUNDAY);
                    day.setWeekEnd(true);
                    previous = DayOfWeek.SUNDAY;
                    break;
                case SUNDAY:
                    day.setDayOfWeek(DayOfWeek.MONDAY);
                    previous = DayOfWeek.MONDAY;
                    break;
            }
        }
        return previous;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Day[] getDays() {
        return days;
    }

    public void setDays(Day[] days) {
        this.days = days;
    }

    public void printMonth() {
        System.out.println(name);
        for (int i = 0; i < days.length; i++) {
            System.out.print(days[i].getNumber() + " ");
            if ((i+1) % 5 == 0)
                System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Month{" +
                "name='" + name + '\'' +
                ", days=" + Arrays.toString(days) +
                '}';
    }
}
