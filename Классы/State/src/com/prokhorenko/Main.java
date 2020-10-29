package com.prokhorenko;

/*
3. Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
столицу, количество областей, площадь, областные центры.
 */
public class Main {
    public static void main(String[] args) {
        City city1 = new City("City1", 39);
        City city2 = new City("City2", 38);
        City city3 = new City("City3", 37);
        City city4 = new City("City4", 36);
        City city5 = new City("City5", 35);
        City city6 = new City("City6", 34);
        City city7 = new City("City7", 33);
        City city8 = new City("City8", 32);
        City city9 = new City("City9", 31);
        City city10 = new City("City10", 30);
        City[] cities1 = {city1, city2};
        City[] cities2 = {city3, city4};
        City[] cities3 = {city5, city6};
        City[] cities4 = {city7, city8};
        City[] cities5 = {city9, city10};
        District district1 = new District(cities1, 100);
        District district2 = new District(cities2, 80);
        District district3 = new District(cities3, 120);
        District district4 = new District(cities4, 110);
        District district5 = new District(cities5, 90);
        District[] districts1 = {district1, district2, district3};
        District[] districts2 = {district4, district5};
        Region region1 = new Region(districts1, city1);
        Region region2 = new Region(districts2, city10);
        Region[] regions = {region1, region2};
        State state = new State(regions, city1);
        state.printArea();
        state.printCapital();
        state.regionCount();
        state.printRegionCenters();
    }
}
