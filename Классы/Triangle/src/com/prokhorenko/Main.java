package com.prokhorenko;
/*
7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
площади, периметра и точки пересечения медиан.
 */
public class Main {
    public static void main(String[] args) {
        Triangle abc = new  Triangle(1,2,2,3,3,2);
        System.out.println(abc);
        System.out.println("Perimeter = " + abc.Perimeter());
        System.out.println("Square = " + abc.Square());
        abc.medianIntersectionPoint();
    }
}
