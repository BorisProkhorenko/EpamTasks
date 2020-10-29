package com.prokhorenko;

import java.util.Random;

public class Main {

    public static int[] createRandArr(int n) {
        Random random = new Random();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++)
            //   a[i] = i;
            a[i] = random.nextInt(10) + 1;
        return a;
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " [" + i + "]");
        }
    }
    /*
    1. Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
    один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
    дополнительный массив.
     */
    public static int[] first(int k, int[] firstArr, int[] secondArr) {
        int[] temp = new int[firstArr.length + secondArr.length];
        System.arraycopy(secondArr, 0, temp, k - 1, secondArr.length);
        System.arraycopy(firstArr, 0, temp, 0, k - 1);
        System.arraycopy(firstArr, k - 1, temp, k - 1 + secondArr.length,
                firstArr.length - (k - 1));
        return temp;
    }
    /*
2. Даны две последовательности a[1]<=a[2]<=...<=a[n] и b[1]<=b[2]<=...<=b[m]. Образовать из них новую последовательность
чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.
     */
    public static int[] second(int[] firstArr, int[] secondArr) {
        int[] temp = first(1, firstArr, secondArr);
        fourth(temp);
        return temp;
    }
    /*
3. Сортировка выбором. Дана последовательность чисел a[1]<=a[2]<=...<=a[n].Требуется переставить элементы так,
чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
повторяется. Написать алгоритм сортировки выбором.
     */
    public static void third(int[] a) {

        int iMax = 0;
        int temp;
        for (int j = 0; j < a.length - 1; j++) {
            int max = a[j];
            for (int i = j; i < a.length; i++) {

                if (a[i] > max) {
                    max = a[i];
                    iMax = i;
                }
            }
            temp = a[iMax];
            a[iMax] = a[j];
            a[j] = temp;
        }
    }
    /*
4. Сортировка обменами. Дана последовательность чисел
a[1]<=a[2]<=...<=a[n].Требуется переставить числа в порядке возрастания.
Для этого сравниваются два соседних числа a[i] и a[i+1]. Если a[i] > a[i+1],
то делается перестановка. Так продолжается до тех пор, пока все элементы не станут
расположены в порядке возрастания. Составить алгоритм сортировки,
подсчитывая при этом количества перестановок.

     */
    public static int fourth(int[] a) {
        int count = 0;
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length - 1; i++) {
                int temp = 0;
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    count++;
                }

            }
        }
        return count;
    }
    /*
    Метод реализует бинарный поиск в массиве a, left - левая граница поиска,
    right - left - левая граница поиска, х - значение искомого элемента
     */
    public static int binarySearch(int[] a, int left, int right, int x) {
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (a[mid] == x || left == mid && a[mid] != x) {
                if (mid == 0)
                    return mid;
                return mid + 1;
            } else if (a[mid] > x) {
                right = mid;
            } else {
                left = mid;
            }

        }

        return mid;
    }
    /*
    Сдвиг массива влево
     */
    public static void arrMove(int[] a, int first, int last) {
        for (int i = last; i > first; i--) {
            a[i] = a[i - 1];
        }
    }
    /*
5. Сортировка вставками. Дана последовательность чисел a[1], a[2], ..., a[n]. Требуется переставить числа в порядке
возрастания. Делается это следующим образом. Пусть a[1], a[2], ..., a[n] - упорядоченная последовательность,
т. е. a[1]<=a[2]<=...<=a[n]. Берется следующее число a[i+1] и вставляется в последовательность так, чтобы новая
последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i +1 до n
не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
     */
    public static void fifthBinary(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            if (a[i] < a[i - 1]) {
                int j = binarySearch(a, 0, i, a[i]);
                arrMove(a, j, i);
                a[j] = temp;
            }
        }

    }
    /*
Тоже самое, что fifthBinary, только без бинарного поиска(просто интересно было для себя)
     */
    public static void fifth(int[] a) {
        for (int i = 2; i < a.length; i++) {
            int temp = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (j == 0) {
                    if (temp > a[j]) {
                        a[j + 1] = temp;
                        break;
                    }
                    a[j] = temp;
                    break;
                }
                if (a[j] <= temp) {
                    a[j + 1] = temp;
                    break;
                } else {
                    a[j + 1] = a[j];
                    if (temp <= a[j - 1])
                        a[j] = a[j - 1];
                }
            }
        }

    }
    /*
6. Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
Делается это следующим образом: сравниваются два соседних элемента a[i] и a[i+1]. Если a[i] <= a[i+1],
то продвигаются на один элемент вперед. Если a[i] > a[i+1], то производится перестановка и
сдвигаются на один элемент назад. Составить алгоритм этой сортировки.
     */
    public static void sixth(int[] a) {
        int temp;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                if (i >= 1)
                    i -= 2;
            }
        }
    }
    /*
7. Пусть даны две неубывающие последовательности действительных чисел
a[1]<=a[2]<=...<=a[n] и b[1]<=b[2]<=...<=b[m].
Требуется указать те места, на которые нужно вставлять элементы последовательности
b[1]<=b[2]<=...<=b[m] в первую последовательность так,
чтобы новая последовательность оставалась возрастающей.

     */
    public static void seventh(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            int j = binarySearch(a, 0, a.length, b[i]);
            if (j == 0 && a[0] > b[i])
                System.out.println(b[i] + " Вставить на позицию " + j);
            else if (j == 0 && a[0] <= b[i])
                System.out.println(b[i] + " Вставить на позицию между " + j + " и " + (j + 1));
            else if (a[a.length - 1] < b[i])
                System.out.println(b[i] + " Вставить в конец");
            else
                System.out.println(b[i] + " Вставить на позицию между " + (j - 1) + " и " + j);
        }

    }

    /*
8.Даны дроби p[1]/q[1], p[2]/q[2], ..., p[n]/q[n]
,p,q - натуральные). Составить программу, которая приводит эти дроби к общему
знаменателю и упорядочивает их в порядке возрастания.
     */
    public static void eighth(int[] p, int[] q) {
        if (p.length != q.length)
            return;
        int dividend = massMCM(q);
        for (int i = 0; i < p.length; i++) {
            System.out.print("p/q= " + p[i] + " / " + q[i] + "   ");
        }
        System.out.println();
        for (int i = 0; i < p.length; i++) {
            p[i] = p[i] * dividend / q[i];
            q[i] = dividend;
            System.out.print("p/q= " + p[i] + " / " + q[i] + "   ");
        }
        sixth(p);
        System.out.println();
        for (int i = 0; i < p.length; i++) {
            System.out.print("p/q= " + p[i] + " / " + q[i] + "   ");
        }
    }
    /*
    Нахождение НОД
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
    public static int minimalCommonMultiplier(int x, int y) {
        int multiplier = x * y / maximumCommonDivider(x, y);
        return multiplier;
    }
    /*
    Общий НОК
     */
    public static int massMCM(int[] q) {
        int multiplier = 1;
        for (int i = 1; i < q.length; i++) {
            multiplier = minimalCommonMultiplier(multiplier,
                    minimalCommonMultiplier(q[i], q[i - 1]));
        }

        return multiplier;
    }

    public static void main(String[] args) {

        int[] a = {1, 5, 7};
        int[] b = {1, 2, 5};
        eighth(a, b);


    }
}