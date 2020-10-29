package com.prokhorenko;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Triangle {
    private double xA; //координата точки A по оси x
    private double yA; //координата точки A по оси y
    private double xB; //координата точки B по оси x
    private double yB; //координата точки B по оси y
    private double xC; //координата точки C по оси x
    private double yC; //координата точки C по оси y
    private double ABLength; //длина AB
    private double ACLength; //длина AС
    private double BCLength; //длина BC

    public Triangle(double xA, double yA, double xB, double yB, double xC, double yC) {
        this.xA = xA;
        this.yA = yA;
        this.xB = xB;
        this.yB = yB;
        this.xC = xC;
        this.yC = yC;
        ABLength = sqrt(pow(xB - xA, 2) + pow(yB - yA, 2));
        ACLength = sqrt(pow(xC - xA, 2) + pow(yC - yA, 2));
        BCLength = sqrt(pow(xC - xB, 2) + pow(yC - yB, 2));
    }

    public double Perimeter() {
        return ABLength + ACLength + BCLength;
    }

    public double Square() {
        double p = Perimeter() / 2;
        return sqrt(p * (p - ABLength) * (p - ACLength) * (p - BCLength));
    }

    public void medianIntersectionPoint() {
        System.out.println("Координаты точки пересечения медиан треугольника:" +
                " (" + (xA + xB + xC) / 3 + ", " + (yA + yB + yC) / 3 + ")");
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "xA=" + xA +
                ", yA=" + yA +
                ", xB=" + xB +
                ", yB=" + yB +
                ", xC=" + xC +
                ", yC=" + yC +
                ", ABLength=" + ABLength +
                ", ACLength=" + ACLength +
                ", BCLength=" + BCLength +
                '}';
    }
}
