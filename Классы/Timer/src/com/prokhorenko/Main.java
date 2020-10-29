package com.prokhorenko;

/*
6. Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
заданное количество часов, минут и секунд.
 */
public class Main {
    public static void main(String[] args) {

        Timer timer = new Timer(650,40,546);
        System.out.println(timer);
        timer.minutesInc(561);
        System.out.println(timer);
        timer.secondsInc(602);
        System.out.println(timer);
        timer.hoursInc(15);
        System.out.println(timer);
    }
}
