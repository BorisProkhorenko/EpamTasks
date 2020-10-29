package com.prokhorenko;

/*
3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */
public class Main {

    public static void main(String[] args) {
        int[] highMarks = {10, 9, 9, 10, 10};
        int[] marks = {10, 9, 4, 6, 7};

        Student prokhorenko = new Student("Прохоренко Б.А.", 10606113, highMarks);
        Student petrovets = new Student("Петровец А.Д.", 10606113, highMarks);
        Student vinokurova = new Student("Винокурова А.А.", 10606113, highMarks);
        Student novitsky = new Student("Новицкий А.В.", 10606113, marks);
        Student pogoda = new Student("Погода А.Д.", 10604115, marks);
        Student zhitkevich = new Student("Житкевич А.Д.", 10604115, marks);
        Student lutchenko = new Student("Лутченко В.А.", 10604115, marks);
        Student boldusov = new Student("Больдюсов В.А.", 10604115, highMarks);
        Student shapurko = new Student("Шапурко О.Г.", 10604115, highMarks);
        Student kalaur = new Student("Каллаур П.А.", 10604115, highMarks);
        Student[] students = {prokhorenko, petrovets, vinokurova, novitsky, pogoda, zhitkevich, lutchenko,
                boldusov, shapurko, kalaur};

        for (Student student : students) {
            if (student.isAdvanced())
                System.out.println("surName - " + student.getSurname() + "; groupNumber - " + student.getGroupNum());
        }
    }
}
