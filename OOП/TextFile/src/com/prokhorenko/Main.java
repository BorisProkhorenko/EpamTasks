package com.prokhorenko;

/*
Задача 1.
Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
вывести на консоль содержимое, дополнить, удалить.
 */
public class Main {
    public static void main(String[] args) {
        Directory directory = new Directory("Epam", "C:\\Users\\Прохоренко\\IdeaProjects");
        System.out.println(directory.getPath());
        TextFile textFile = new TextFile("SomeEpamCourseTask", directory);
        textFile.setText("Hello World!");
        TextFile file = textFile.createNewFile("New File", directory);
        // System.out.println(file);
        textFile.rename("OOPTask1");
        // System.out.println(textFile.getName());
        //textFile.print();
        textFile.addText("Hello Everyone!!!");
        //textFile.print();
        textFile.delete();//удаляет только текст, удалением объекта класса занимается сборщик мусора,
        //можно присвоить null файлу, но не внутри самого класса и не внутри другого класса,
        //кроме класса Main, тк в классы передаётся копия ссылки, не ссылка.
        System.out.println(textFile);
        textFile=null;//только так можно очень условно удалить объект и опять же только в этом классе
         System.out.println(textFile);




    }
}

