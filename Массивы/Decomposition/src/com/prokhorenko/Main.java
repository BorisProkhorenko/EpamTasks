package com.prokhorenko;

import static java.lang.Math.*;


public class Main {

    /*
1. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
натуральных чисел:
     */
    private static void first(int a, int b) {
        System.out.println("НОД = " + maximumCommonDivider(a, b) + "\nНОК= " + minimalCommonMultiplier(a, b));
    }

    /*
    НОД
     */
    public static int maximumCommonDivider(int a, int b) {
        int length;
        int maxCommonDivider = 1;
        if (a > b) {
            length = a / 2;
        } else
            length = b / 2;
        for (int i = 2; i <= length; i++) {
            if (a % i == 0 && b % i == 0)
                maxCommonDivider = i;
        }
        return maxCommonDivider;
    }

    /*
    НОК
     */
    public static int minimalCommonMultiplier(int a, int b) {
        int multiplier = a * b / maximumCommonDivider(a, b);
        return multiplier;
    }

    /*
2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел
     */
    public static int second(int a, int b, int c, int d) {
        int mcm = maximumCommonDivider(a, b);
        mcm = maximumCommonDivider(mcm, c);
        mcm = maximumCommonDivider(mcm, d);
        return mcm;
    }

    /*
3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади
треугольника.
     */
    public static double third(int a) {

        double x = triangleSquare(a);

        return x * 6;
    }

    /*
Площадь треугольника
     */
    public static double triangleSquare(int a) {

        return a * a * Math.sqrt(3) / 4;
    }

    /*
4. На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
     */
    public static double fourth(int a[][]) {
        double max = 0;
        double temp;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j < a.length - 1; j++) {
                temp = sqrt((pow(a[j][0] - a[i][0], 2) + (pow(a[j][1] - a[i][1], 2))));
                if (max < temp) {
                    max = temp;
                    num1 = i;
                    num2 = j;
                }
            }
        }
        System.out.println("Max = " + max + " точка 1- " + num1 + " точка 2- " + num2);
        return max;

    }

    /*
5. Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
которое меньше максимального элемента массива, но больше всех других элементов).
     */
    public static void fifth(int[] a) {
        int max = max(a);
        int almostMax = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > almostMax && a[i] < max)
                almostMax = a[i];
        }
        System.out.println(almostMax);
    }

    /*
    Максимальный элемент массива
     */
    public static int max(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }

    /*
6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
     */
    public static boolean sixth(int a, int b, int c) {
        if (maximumCommonDivider(a, b) == 1 && maximumCommonDivider(a, c) == 1
                && maximumCommonDivider(c, b) == 1)
            return true;
        return false;
    }

    /*
7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
     */
    public static int seventh() {
        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            if (i % 2 != 0)
                sum += factorial(i);
        }
        return sum;
    }

    /*
 Вычисления факториала n!
     */
    public static int factorial(int n) {
        int fac = 1;
        for (int i = 2; i <= n; i++) {
            fac *= i;
        }
        System.out.println(fac);
        return fac;
    }

    /*
8. Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
массива с номерами от k до m.
     */
    public static void eighth(int[] a, int k, int m) {
        if (m <= k || k <= 0 || m > a.length - 2)
            return;
        for (int i = k; i <= m; i++) {
            System.out.println(a[i - 1] + a[i] + a[i + 1]);
        }
    }

    /*
9. Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
если угол между сторонами длиной X и Y— прямой.
     */
    public static double ninth(int a, int b, int c, int d) {
        double s = sqrt(a * b * c * d);
        return s;
    }

    /*
10. Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
являются цифры числа N.
     */
    public static int[] tenth(int n) {
        String s = Integer.toString(n);
        int[] a = new int[s.length()];
        for (int i = 0; i < a.length; i++) {
            a[i] = n % 10;
            n /= 10;
            System.out.println(a[i]);
        }
        return a;
    }

    /*
11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
     */
    public static int eleventh(int first, int second) {
        String f = Integer.toString(first);
        String sec = Integer.toString(second);
        if (f.length() == sec.length()) {
            System.out.println("=");
            return first;
        } else if (f.length() > sec.length()) {
            System.out.println("First");
            return first;
        }
        System.out.println(("Second"));
        return second;
    }

    /*
    Количество цифр в числе
     */
    public static int numSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    /*
12. Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
являются числа, сумма цифр которых равна К и которые не большее N.
     */
    public static int[] twelves(int k, int n) {
        int[] a = new int[n / 10];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (numSum(i) == k) {
                a[j] = i;
                j++;
            }
        }
        int[] arr = new int[j];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i];
        }

        return arr;
    }

    /*
13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
решения задачи использовать декомпозицию.
Примечание: Использование декоппозиции считаю неуместным, т.к. задача очень проста и я даже не знаю, что тут разбивать!
     */

    public static void thirteenth(int n) {
        if (n < 2)
            return;
        int i = n;
        int k = i + 2;
        while (k <= n * 2) {
            System.out.println(i + " " + k);
            i++;
            k++;
        }

    }

    /*
14. Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
использовать декомпозицию
     */
    public static void fourteenth(int k) {
        for (int i = 1; i <= k; i++) {
            if (numArmstrong(i) == i) {
                System.out.println(i);
            }
        }
    }

    /*
Вщзвращает натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
возведенная в степень n
     */
    public static int numArmstrong(int n) {
        int sum = 0;
        int i = Integer.toString(n).length();
        while (n > 0) {
            sum += pow(n % 10, i);
            n /= 10;
        }
        return sum;
    }

    /*
15. Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
последовательность (например, 1234, 5789).
     */
    public static void fifteenth(int n) {
        n--;
        for (int i = 1; i + n < 10; i++) {
            for (int j = i; j <= i + n; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /*
16. Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
Определить также, сколько четных цифр в найденной сумме.
     */
    public static void sixteenth(int n) {
        int sum = 0;
        for (int i = (int) pow(10, n - 1); i < pow(10, n); i++) {
            if (isAllOdd(i)) {
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println("sum = " + sum + " even count = " + evenCount(sum));
    }

    /*
Если все нечётные-true
     */
    public static boolean isAllOdd(int n) {
        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            if (temp % 2 == 0)
                return false;
        }
        return true;
    }

    /*
Количество чётных цифр в числе
     */
    public static int evenCount(int n) {
        int count = 0;
        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            if (temp % 2 == 0)
                count++;
        }
        return count;
    }

    /*
17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.
     */
    public static void seventeenth(int n) {
        int count = 0;
        while (n > 0) {
            System.out.println(n);
            n -= numSum(n);
            count++;
        }
        System.out.println("Count = " + count);
    }

    public static void main(String[] args) {

        seventeenth(500);

    }
}