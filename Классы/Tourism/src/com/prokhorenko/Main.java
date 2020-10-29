package com.prokhorenko;

import java.util.ArrayList;
/*
5. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 */
public class Main {

    public static void main(String[] args) {

        Tour tour1=new Tour("Egypt", "Egypt", TourType.EXCURSION,Transport.PLANE,
                true, 540);
        Tour tour2=new Tour("Bulgaria", "Bulgaria", TourType.RELAX,Transport.CAR,
                true, 350);
        Tour tour3=new Tour("Italy", "Italy", TourType.CRUISE,Transport.CAR,
                true, 1000);
        Tour tour4=new Tour("Japan", "Japan", TourType.HEALTH,Transport.PLANE,
                true, 2500);
        Agent agent=new Agent("Boris");

        agent.add(tour1);
        agent.add(tour1);
        agent.add(tour2);
        agent.add(tour3);
        agent.add(tour4);

        agent.sort();
        System.out.println(agent);
        System.out.println();
        System.out.println();
        System.out.println(agent.find("Japan"));
        System.out.println();
        ArrayList<Tour> tr=agent.selectionByTransport(Transport.PLANE);
        for (Tour tour:tr) {
            System.out.println(tour);
        }
        System.out.println();

        ArrayList<Tour> tt=agent.selectionByType(TourType.EXCURSION);
        for (Tour tour:tt) {
            System.out.println(tour);

        }

    }
}
