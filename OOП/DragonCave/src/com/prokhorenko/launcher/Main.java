package com.prokhorenko.launcher;

import com.prokhorenko.classes.Cave;
import com.prokhorenko.classes.Customer;
import com.prokhorenko.classes.Treasure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
Задача 4.
Создать консольное приложение, удовлетворяющее следующим требованиям:
• Приложение должно быть объектно-, а не процедурно-ориентированным.
• Каждый класс должен иметь отражающее смысл название и информативный состав.
• Наследование должно применяться только тогда, когда это имеет смысл.
• При кодировании должны быть использованы соглашения об оформлении кода java code convention.
• Классы должны быть грамотно разложены по пакетам.
• Консольное меню должно быть минимальным.
• Для хранения данных можно использовать файлы.
Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и
выбора сокровищ на заданную сумму.
 */

public class Main {
    public static void main(String[] args) {

        String filePath = new File("").getAbsolutePath() +
                "\\src\\com\\prokhorenko\\resources\\TreasuresInfo";
        Cave cave = buildCave("Golden Dragon's Cave", readData(filePath));
        Customer customer = new Customer("Boris", 1000);

        customer.menu(cave);

    }

    private static Cave buildCave(String nameOfCave, String[] data) {

        ArrayList<Treasure> treasureArrayList = new ArrayList<>();

        for (String line : data) {
            String[] parameters = line.split("\\|");
            treasureArrayList.add(new Treasure(parameters[0], Double.parseDouble(parameters[1])));
        }
        return new Cave(nameOfCave, treasureArrayList);
    }

    private static String[] readData(String filePath) {

        String line;
        ArrayList<String> data = new ArrayList<>();

        try (FileReader inputStream = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(inputStream)) {
            while ((line = reader.readLine()) != null && !line.equals("")) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toArray(new String[0]);
    }

}
