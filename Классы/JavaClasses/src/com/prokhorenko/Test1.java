package com.prokhorenko;

/*
1. Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
наибольшее значение из этих двух переменных.
 */
public class Test1 {

    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void printX(){
        System.out.println("x = " + x);
    }
    public void printY(){
        System.out.println("y = " + y);
    }

    public int sum() {
        return x + y;
    }

    public int max() {
        if (x > y)
            return x;
        else return y;
    }


}
