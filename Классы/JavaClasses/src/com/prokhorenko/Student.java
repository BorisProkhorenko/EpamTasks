package com.prokhorenko;

/*
3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
номеров групп студентов, имеющих оценки, равные только 9 или 10.
 */

public class Student {
    private String surname;
    private int groupNum;
    private int[] academicPerformance = new int[5];

    public Student(String surname, int groupNum, int[] marks) {
        this.surname = surname;
        this.groupNum = groupNum;
        for (int i = 0; i < academicPerformance.length; i++) {
            if (marks[i] < 11 && marks[i] > 0)
                academicPerformance[i] = marks[i];
            else
                academicPerformance[i] = 1;
        }
    }

    public boolean isAdvanced() {
        for (int i = 0; i < academicPerformance.length; i++) {
            if (academicPerformance[i] < 9)
                return false;
        }
        System.out.println("surName " + surname + " groupNumber " + groupNum);
        return true;
    }
}
