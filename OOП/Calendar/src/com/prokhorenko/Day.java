package com.prokhorenko;

public class Day {
    private int number;
    private boolean isHoliday;
    private boolean isWeekEnd;
    private DayOfWeek dayOfWeek;
    private String month;


    public Day(int number) {
        this.number = number;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setHoliday(boolean holiday) {
        isHoliday = holiday;
    }

    public boolean isWeekEnd() {
        return isWeekEnd;
    }

    public void setWeekEnd(boolean weekEnd) {
        isWeekEnd = weekEnd;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "Day{" +
                "number=" + number +
                ", isHoliday=" + isHoliday +
                ", isWeekEnd=" + isWeekEnd +
                ", dayOfWeek=" + dayOfWeek +
                '}';
    }
}

