package com.prokhorenko;

public class Triangle {

    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double Perimeter() {
        return a + b + c;
    }

    public double Square() {
        double p = Perimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
