package com.prokhorenko;

public class Timer {

    int hours;
    int minutes;
    int seconds;

    public Timer(int hours, int minutes, int seconds) {
        this.hours = hours;
        if (minutes >= 60)
            minutes = 0;
        this.minutes = minutes;
        if (seconds >= 60)
            seconds = 0;
        this.seconds = seconds;
    }

    public void hoursInc(int count) {
        hours += count;
    }

    public void minutesInc(int count) {
        minutes += count;
        while (minutes >= 60) {
            hours++;
            minutes -= 60;
        }
    }

    public void secondsInc(int count) {
        seconds += count;
        while (seconds >= 60) {
            minutesInc(1);
            seconds -= 60;
        }
    }

    @Override
    public String toString() {
        return "Timer{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}
