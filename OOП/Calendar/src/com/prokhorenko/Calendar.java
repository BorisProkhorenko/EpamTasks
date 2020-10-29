package com.prokhorenko;

import java.util.ArrayList;
import java.util.Arrays;

/*
Задача 3.
Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
выходных и праздничных днях.
 */
public class Calendar {
    private Month[] months = new Month[12];
    private int year;
    private DayOfWeek lastDayOfPreviousYear;
    private boolean isLeap;
    private HolidayAndWeekendManager holidayAndWeekendManager;

    public Calendar(int year, DayOfWeek lastDayOfPreviousYear) {
        this.year = year;
        this.lastDayOfPreviousYear = lastDayOfPreviousYear;
        isLeap = isLeapYear(year);
        fillTheCalendarWithMonths();
        holidayAndWeekendManager = new HolidayAndWeekendManager();
    }

    public boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    public void fillTheCalendarWithMonths() {
        DayOfWeek previous = lastDayOfPreviousYear;
        for (int i = 0; i < months.length; i++) {
            switch (i) {
                case 0:
                    months[i] = fillTheMonth("January", 31);
                    previous = months[i].daysOfWeek(previous);
                    break;
                case 1:
                    if (isLeap)
                        months[i] = fillTheMonth("February", 29);
                    else
                        months[i] = fillTheMonth("February", 28);
                    previous = months[i].daysOfWeek(previous);
                    break;
                case 2:
                    months[i] = fillTheMonth("March", 31);
                    previous = months[i].daysOfWeek(previous);
                    break;
                case 3:
                    months[i] = fillTheMonth("April", 30);
                    previous = months[i].daysOfWeek(previous);
                    break;
                case 4:
                    months[i] = fillTheMonth("May", 31);
                    previous = months[i].daysOfWeek(previous);
                    break;
                case 5:
                    months[i] = fillTheMonth("June", 30);
                    previous = months[i].daysOfWeek(previous);
                    break;
                case 6:
                    months[i] = fillTheMonth("July", 31);
                    previous = months[i].daysOfWeek(previous);
                    break;
                case 7:
                    months[i] = fillTheMonth("August", 31);
                    previous = months[i].daysOfWeek(previous);
                    break;
                case 8:
                    months[i] = fillTheMonth("September", 30);
                    previous = months[i].daysOfWeek(previous);
                    break;
                case 9:
                    months[i] = fillTheMonth("October", 31);
                    previous = months[i].daysOfWeek(previous);
                    break;
                case 10:
                    months[i] = fillTheMonth("November", 30);
                    previous = months[i].daysOfWeek(previous);
                    break;
                case 11:
                    months[i] = fillTheMonth("December", 31);
                    months[i].daysOfWeek(previous);
                    break;
            }
        }
    }

    public Month fillTheMonth(String nameOfTheMonth, int numberOfDays) {
        Day[] days = new Day[numberOfDays];
        for (int i = 0; i < days.length; i++) {
            days[i] = new Day(i + 1);
        }
        return new Month(nameOfTheMonth, days);

    }

    public Day find(String nameOfMonth, int number) {
        for (Month month : months) {
            if (month.getName().equals(nameOfMonth) && month.getDays().length >= number) {
                return month.getDays()[number - 1];
            }
        }
        return null;
    }

    public void printTheCalendar() {
        for (Month month : months) {
            month.printMonth();
            System.out.println("\n");
        }
    }

    public Month[] getMonths() {
        return months;
    }

    public int getYear() {
        return year;
    }

    public DayOfWeek getLastDayOfPreviousYear() {
        return lastDayOfPreviousYear;
    }

    public HolidayAndWeekendManager getHolidayAndWeekendManager() {
        return holidayAndWeekendManager;
    }

    public boolean isLeap() {
        return isLeap;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "months=" + Arrays.toString(months) +
                ", year=" + year +
                ", lastDayOfPreviousYear=" + lastDayOfPreviousYear +
                ", isLeap=" + isLeap +
                '}';
    }

    public class HolidayAndWeekendManager {
        private ArrayList<Day> holidayList = new ArrayList<>();
        private ArrayList<Day> weekendList = new ArrayList<>();

        public HolidayAndWeekendManager() {
            for (Month month : months) {
                for (Day day : month.getDays()) {
                    if (day.isWeekEnd())
                        weekendList.add(day);
                }
            }
        }

        public void addHoliday(String nameOfMonth, int number) {
            Day holiday = find(nameOfMonth, number);
            if (holiday != null) {
                holidayList.add(holiday);
                holiday.setHoliday(true);
            }
        }

        public void printHolidaysAndWeekends() {
            System.out.println("Holidays:");
            for (Day holiday : holidayList) {
                System.out.println(holiday.getMonth() + " " + holiday.getNumber() + " - " + holiday.getDayOfWeek());
            }
            System.out.println("Weekends:");
            for (Day weekend : weekendList) {
                System.out.println(weekend.getMonth() + " " + weekend.getNumber() + " - " + weekend.getDayOfWeek());
            }
        }

        public void setHolidayList(ArrayList<Day> holidayList) {
            this.holidayList = holidayList;
        }

        public ArrayList<Day> getHolidayList() {
            return holidayList;
        }

        public ArrayList<Day> getWeekendList() {
            return weekendList;
        }
    }
}
