package com.prokhorenko;


import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    /*
1. Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.
     */
    public static double firstLinearTask(double a, double b, double c) {
        return ((a - 3) * b / 2) + c;
    }

    /*
2. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
((b+√(b^2+4ac))/2a)-(a^3)c+(b^(-2))
     */
    public static double secondLinearTask(double a, double b, double c) {
        if (a == 0 || b == 0) {
            System.out.println("Деление на ноль");
            return -1;
        } else
            return ((b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / (2 * a)) - Math.pow(a, 3) * c + Math.pow(b, -2);
    }

    /*
3. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
((𝑠𝑖𝑛 𝑥 + 𝑐𝑜𝑠 𝑦)/(𝑐𝑜𝑠 𝑥 − 𝑠𝑖𝑛 𝑦))*𝑡𝑔 𝑥y
     */
    public static double thirdLinerTask(double x, double y) {
        double a = Math.sin(x) + Math.cos(y);
        double b = Math.cos(x) - Math.sin(y);
        if (b == 0) {
            System.out.println("Деление на ноль");
            return -1;
        } else
            return a / b * Math.tan(x * y);
    }

    /*
4. Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
дробную и целую части числа и вывести полученное значение числа.
     */
    public static void fourthLinearTask(double number) {
        if (number / 1000 > 1 || number / 100 < 1 || number * 10000 % 10 != 0) {
            System.out.println("неправильный формат числа");
            return;
        }
        double temp = number * 1000 - (int) number * 1000;
        number = (int) number;
        System.out.println(temp + number / 1000);

    }

    /*
5. Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести
данное значение длительности в часах, минутах и секундах в следующей форме:
ННч ММмин SSc.
     */
    public static void fifthLinearTask(int seconds) {
        if (seconds < 0) {
            System.out.println("секунды должны быть заданны положитльным числом");
            return;
        }
        int hours = seconds / 3600;
        int minutes = seconds / 60 - hours * 60;
        seconds = seconds - hours * 3600 - minutes * 60;
        if (hours < 10)
            System.out.print(0);
        System.out.print(hours + "ч ");
        if (minutes < 10)
            System.out.print(0);
        System.out.print(minutes + "мин ");
        if (seconds < 10)
            System.out.print(0);
        System.out.print(seconds + "c");
    }

    /*
6. Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
принадлежит закрашенной области, и false — в противном случае:
см. рисунок на гитхабе.
     */
    public static void sixLinearTask(int x, int y) {
        if ((y > 0 && y < 5 && x > -3 && x < 3) || (y < 0 && y > -4 && x > -5 && x < 5))
            System.out.println(true);
        else
            System.out.println(false);
    }

    /*
1. Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли
он прямоугольным.
     */
    public static boolean firstBranchingTask(int a, int b) {
        if (a > 0 && b > 0 && a + b < 180) {
            System.out.println("Треугольник существует");
            if (a == 90 || b == 90 || a + b == 90)
                System.out.println("Он прямоугольный");
            return true;

        }
        System.out.println("Не существует");
        return false;
    }

    /*
2. Найти max{min(a, b), min(c, d)}.
     */
    public static int secondBranchingTask(int a, int b, int c, int d) {
        return max(min(a, b), min(c, d));
    }

    public static int min(int a, int b) {
        if (a >= b) {
            return b;
        } else return a;
    }

    public static int max(int a, int b) {
        if (a >= b) {
            return a;
        } else return b;
    }

    /*
3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.
     */
    public static boolean thirdBranchingTask(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (((x2 - x1) * (y3 - y1)) - ((y2 - y1) * (x3 - x1)) == 0)
            return true;
        else
            return false;
    }

    /*
4. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
отверстие.
Методы для нахождения минимального и максимального из двух значений описаны в задаче 2(Ветвления)
     */
    public static boolean fourthBranchingTask(int a, int b, int x, int y, int z) {
        int minAB = min(a, b);
        int minXY = min(x, y);
        int minXZ = min(x, z);
        int maxAB = max(a, b);
        int maxXY = max(x, y);
        int maxXZ = max(x, z);
        if (a > 0 && b > 0 && x > 0 && y > 0 && z > 0 && min(minXY, minXZ) < minAB && min(maxXY, maxXZ) < maxAB)
            return true;
        return false;
    }
    /*
5. Вычислить значение функции:
          x^2-3x+9, если х<=3
F(x)=
          1/((x^3)+6), если x>3
     */

    public static double fifthBranchingTask(double x) {
        if (x <= 3)
            return x * x - x * 3 + 9;
        else return 1 / (Math.pow(x, 3) + 6);
    }

    /*
1. Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует
все числа от 1 до введенного пользователем числа.
     */
    public static void firstCycleTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int x = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= x; i++)
            sum += i;
        System.out.println(sum);
    }

    /*
2. Вычислить значения функции на отрезке [а,b] c шагом h:
    x, x>2
y =
    -x, x<=2
     */
    public static void secondCycleTask(int a, int b, int h) {
        for (int i = a; i <= b; i += h) {
            int temp = i;
            if (temp <= 2)
                temp = -temp;
            System.out.println(temp);
        }
    }

    /*
3. Найти сумму квадратов первых ста чисел.
     */
    public static void thirdCycleTask() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i * i;
        }
        System.out.println(sum);
    }

    /*
4. Составить программу нахождения произведения квадратов первых двухсот чисел
     */
    public static void fourthCycleTask() {
        BigInteger result = new BigInteger("1");
        for (int i = 2; i <= 200; i++) {
            Integer z = i * i;
            BigInteger bigInteger = new BigInteger(z.toString());
            result = result.multiply(bigInteger);

        }
        System.out.println(result);

    }

    /*
5. Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
заданному е. Общий член ряда имеет вид:

a[n]=(1/(2^n))+(1/(3^n))
     */
    public static void fifthCycleTask(double e, int n) {
        double sum = 0;
        for (int i = 1; Math.abs(i) <= Math.abs(n); ) {
            if (n < 0) {
                i--;
            } else i++;
            System.out.println(Math.abs(n));
            double a = 1 / Math.pow(2, i) + 1 / Math.pow(3, i);
            if (Math.abs(a) >= e)
                sum += a;
        }
        System.out.println(sum);
    }

    /*
6. Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
     */
    public static void sixCycleTask() {
        char c;
        for (int i = 33; i < 128; i++) {
            c = (char) i;
            System.out.println(c + " - " + i);
        }
    }

    /*
    7. Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
m и n вводятся с клавиатуры.
     */
    public static void sevenCycleTask() {
        int m;
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи число m");
        m = scanner.nextInt();
        while (m <= 0) {
            System.out.println("Не натуральное число, введи другое");
            m = scanner.nextInt();
        }
        System.out.println("Введи число n");
        n = scanner.nextInt();
        while (n <= 0) {
            System.out.println("Не натуральное число, введи другое");
            n = scanner.nextInt();
        }
        int max = max(m, n);
        int min = min(m, n);
        for (int i = max / 2; i > 1; i--) {
            if (max % i == 0 && min % i == 0)
                System.out.println(i);
        }
    }


    /*
8. Даны два числа. Определить цифры, входящие в запись как первого так и второго числа
     */
    public static void eightCycleTask(int first, int second) {
        String firstString = uni(first);
        String secondString = uni(second);
        first = Integer.parseInt(firstString);
        second = Integer.parseInt(secondString);
        for (int i = 0; i < firstString.length(); i++) {
            int temp = second;
            for (int j = 0; j < secondString.length(); j++) {
                if (first % 10 == temp % 10) {
                    System.out.println(first % 10);
                    break;
                }
                temp /= 10;
            }
            first /= 10;
        }
    }

    /*
    Метод возвращет строку без символа на позиции pos
     */
    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
/*
Метод возвращает число без дубликатов цифр, т.е. все цифры в числе в не повторяются

 */

    public static String uni(int n) {
        String s = "" + n;
        String sum = "";
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    s = removeCharAt(s, j);
                    j--;
                }

            }
        }
        return sum;
    }


    public static void main(String[] args) {
        sevenCycleTask();
    }

}
