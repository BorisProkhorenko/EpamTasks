package com.prokhorenko;

import java.util.Random;

public class Main {


    public static int[] randomArrayGenerator(int arraySize) {
        Random random = new Random();
        int[] a = new int[arraySize];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(10);
        }
        return a;
    }

    /*
1. В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К
     */
    public static void first(int k, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % k == 0)
                System.out.println(arr[i]);
        }

    }

    /*
2. Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
числом. Подсчитать количество замен.

     */
    public static void second(double z, double[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > z) {
                arr[i] = z;
                count++;
            }
            System.out.print(" " + arr[i]);
        }
        System.out.println("\n " + count);

    }

    /*
3. Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
положительных и нулевых элементов.

     */
    public static void third(double[] arr) {
        int posCount = 0;
        int negCount = 0;
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                zeroCount++;
            else if (arr[i] > 0)
                posCount++;
            else
                negCount++;
        }
        System.out.println("Positive = " + posCount + "\n Negative = " + negCount + "\n Zero - " + zeroCount);
    }

    /*
4. Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
     */
    public static void fourth(double[] arr) {
        double max = arr[0];
        int maxIndex = 0;
        double min = arr[0];
        int minIndex = 0;
        double temp;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        System.out.println("min - " + min + " max - " + max);
        temp = max;
        arr[maxIndex] = min;
        arr[minIndex] = temp;
    }

    /*
5. Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
     */
    public static void fifth(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < i)
                System.out.println(arr[i]);
        }
    }


    /*
6. Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
являются простыми числами.
     */
    public static double sixth(double[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isPrime(i)) {
                sum += arr[i];
            }
        }
        return sum;
    }

    /*
    Если простое-true, иначе возвращает false
     */
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /*
7. Даны действительные числа a[1], a[2], ..., a[n]. Найти:
    max(a[1]+a[2n], a[2]+a[2n-1], ..., a[n]+a[n+1])
    Примечание: Если в массиве чётное кол-во элементов, то всё понятно, но если в массиве их нечётное кол-во,
    то есть 2 варианта развития событий. Можно либо сложить срединный элемент(n) со следующим(n+1), но он(n+1)
    уже складывается с (n-1); либо оставить эл-т n без изменений. Я считаю логически более верным второй вариант,
    поэтому его и риализовывал в своём методе.
     */
    public static double seventh(double[] arr) {
        double max;
        if (arr.length % 2 == 0)
            max = arr[0] + arr[arr.length - 1];
        else
            max=arr[arr.length/2];
        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
            if (max < arr[i] + arr[j]) {
                max = arr[i] + arr[j];
            }
        }
        return max;
    }



    /*
 Дана последовательность целых чисел a[1], a[2],...,a[n]
Образовать новую последовательность, выбросив из
исходной те члены, которые равны
min(a[1], a[2],...,a[n])

     */
    public static int[] eighth(int[] a) {
        int min = min(a);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == min)
                count++;
        }
        int arr[] = new int[a.length - count];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (a[i] != min && arr[j] == 0) {
                    arr[j] = a[i];
                    break;
                }

            }
        }
        return arr;
    }
    /*
поиск минимального эл-та в массиве
   */
    public static int min(int[] a) {
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min)
                min = a[i];
        }
        return min;
    }

    /*
поиск минимального из 2-х чисел(перегрузка метода min)
     */
    public static int min(int i, int j) {
        if (i < j)
            return i;
        else
            return j;
    }

    /*
9. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
чисел несколько, то определить наименьшее из них.
     */
    public static int ninth(int[] a) {
        int max = 0;
        int maxCount = 0;
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            if (a[i] == -1)
                continue;
            for (int j = i; j < a.length; j++) {
                if (a[i] == a[j] && a[i] != -1) {
                    count++;
                    if (i != j)
                        a[j] = -1;
                }
            }
            if (count > maxCount) {
                max = a[i];
                maxCount = count;
            } else if (count == maxCount)
                max = min(max, a[i]);

        }

        return max;
    }

    /*
10. Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
     */
    public static void tenth(int[] a) {
        for (int i = 1; i <= a.length; i += 2) {
            a[i] = 0;
        }
    }


    public static void main(String[] args) {
        double[] a = {1, 4, 20, 107, 2,66};
        System.out.println(seventh(a));

    }
}