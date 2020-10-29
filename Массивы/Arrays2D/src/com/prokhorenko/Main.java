package com.prokhorenko;

import static java.lang.Math.*;

import java.util.Random;
import java.util.Scanner;

public class Main {


    public static int[][] randomArrayGenerator(int arraySize) {
        Random random = new Random();
        int[][] a = new int[arraySize][arraySize];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = random.nextInt(15);
            }
        }
        return a;
    }

    /*
1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
     */
    public static void first(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            boolean next = false;
            for (int j = 0; j < a.length; j++) {
                if (j % 2 != 0 && a[0][j] > a[a.length - 1][j]) {
                    System.out.print("   " + a[i][j] + "[" + i + "][" + j + "]");
                    next = true;
                }
            }
            if (next)
                System.out.println();
        }
    }

    /*
    2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали
     */
    public static void second(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i == j)
                    System.out.print("   " + a[i][j] + "[" + i + "][" + j + "]");
            }
        }
    }

    /*
3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы
     */
    public static void third(int[][] a, int k, int p) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[k][i] + " ");
        }
        System.out.println("\n______________________________________________");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i][p]);
        }
    }

    /*
4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
     */
    public static int[][] fourth(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i % 2 == 0) {
                    matrix[i][j] = j + 1;
                } else {
                    matrix[i][j] = matrix.length - j;
                }
            }
        }

        return matrix;
    }
    /*
5. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
     */

    public static int[][] fifth(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i > matrix.length - 1 - j) {
                    matrix[i][j] = 0;
                } else
                    matrix[i][j] = i + 1;
            }
        }
        return matrix;
    }

    /*
6. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
     */
    public static int[][] sixth(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i <= matrix.length - 1 - j && i <= j
                        || i >= matrix.length - 1 - j && i >= j) {
                    matrix[i][j] = 1;
                } else
                    matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    /*
7. Сформировать квадратную матрицу порядка N по правилу:
и подсчитать количество положительных элементов в ней
     */
    public static double[][] seventh(int n) {
        double[][] matrix = new double[n][n];
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                matrix[i][j] = sin((pow(i, 2) - pow(j, 2)) / matrix.length - 1);
                if (matrix[i][j] > 0)
                    count++;
            }
        }
        System.out.println("Count= " + count);
        return matrix;
    }

    /*
8. В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
пользователь с клавиатуры.
     */
    public static void eighth(int[][] a) {
        int temp = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи номер первого столбца");
        int firstColumnNumber = scanner.nextInt();
        System.out.println("Введи номер второго столбца");
        int secondColumnNumber = scanner.nextInt();
        if (firstColumnNumber > a.length - 1 || secondColumnNumber > a.length - 1) {
            System.out.println("Неправильный номер столбца");
            return;
        }
        for (int i = 0; i < a.length; i++) {

            temp = a[i][firstColumnNumber];
            a[i][firstColumnNumber] = a[i][secondColumnNumber];
            a[i][secondColumnNumber] = temp;

        }

    }

    /*
9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
столбец содержит максимальную сумму.
     */
    public static void ninth(int[][] a) {
        int max = 0;
        for (int i = 0; i < a[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j][i] < 0) {
                    System.out.println("Отрицательное число в столбце " + i);
                    return;
                }
                sum += a[j][i];
            }
            if (sum > max)
                max = sum;
            System.out.println("\n Sum= " + sum + " column= " + i);
        }
        System.out.println(" Max=" + max);


    }

    /*
10. Найти положительные элементы главной диагонали квадратной матрицы.
     */
    public static void tenth(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i == j && a[i][j] > 0)
                    System.out.print(" " + a[i][j]);
            }
        }
    }

    /*
11. Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
которых число 5 встречается три и более раз.
     */
    public static void eleventh() {
        int[][] a = new int[10][20];
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = random.nextInt(15);
                System.out.print("   " + a[i][j] + "[" + i + "][" + j + "]");
                if (a[i][j] == 5)
                    count++;
            }
            System.out.println();
            if (count > 2)
                System.out.println("Count>5 in string number " + i);
        }
    }

    /*
12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов
     */
    public static void twelves(int a[][]) {
        for (int z = 0; z < a[0].length; z++) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length - 1; j++) {
                    int temp;
                    if (a[i][j] > a[i][j + 1]) {
                        temp = a[i][j];
                        a[i][j] = a[i][j + 1];
                        a[i][j + 1] = temp;
                    }

                }
            }
        }
    }

    /*
13. Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
     */
    public static void thirteenth(int a[][]) {
        for (int z = 0; z < a.length; z++) {
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = 0; j < a[0].length - 1; j++) {
                    int temp;
                    if (a[i][j] > a[i + 1][j]) {
                        temp = a[i][j];
                        a[i][j] = a[i + 1][j];
                        a[i + 1][j] = temp;
                    }
                }
            }
        }
    }

    /*
14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
единиц равно номеру столбца.
     */
    public static int[][] fourteenth(int n, int m) {
        int[][] a = new int[n][m];
        Random random = new Random();

        for (int i = 0; i < a[0].length; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (count < j && j - i <= 0) {
                    a[j][i] = 1;
                } else if (count < i) {
                    a[j][i] = random.nextInt(2);
                } else
                    a[j][i] = 0;
                if (a[j][i] == 1)
                    count++;
            }

        }
        return a;

    }

    /*
15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
     */
    public static void fifteenth(int[][] a) {
        int max = a[0][0];
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a[0].length - 1; j++) {
                if (a[i][j] > max)
                    max = a[i][j];
            }
        }
        System.out.println("Max= " + max);
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a[0].length - 1; j += 2) {
                a[i][j] = max;
            }
        }
    }

    /*
16. Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3,
..., n^2 так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
собой. Построить такой квадрат. Пример магического квадрата порядка 3:
            6   1   8
            7   5   3
            2   9   4
     */
    public static int[][] sixteenth(int n) {
        if (n % 2 == 0)
            return evenMatrixSquare(n);
        else
            return oddMagicSquare(n);
    }

    /*
    Метод для получения нечётного магического квадрата, Индийским методом
     */
    public static int[][] oddMagicSquare(int n) {
        int[][] a = new int[n][n];
        int x = n / 2;
        int y = 0;
        int nextX;
        int nextY;
        int count = 1;

        while (true) {

            a[y][x] = count;
            if (count == n * n)
                break;
            count++;
            if (y == 0) {
                nextY = a.length - 1;
            } else
                nextY = y - 1;

            if (x == a.length - 1) {
                nextX = 0;
            } else
                nextX = x + 1;

            if (a[nextY][nextX] != 0) {
                y++;
            } else {
                y = nextY;
                x = nextX;
            }

        }
        return a;
    }

    /*
    Метод для получения чётного магического квадрата
     */
    public static int[][] evenMatrixSquare(int n) {
        int[][] a = matrixFilling(n);
        // Перестановка элементов главной диагонали
        int count = 0;
        int length = a.length - 1;
        for (int i = 0; i < a.length / 2; i++) {
            int temp;
            temp = a[i][i];

            a[i][i] = a[length - count][length - count];
            a[length - count][length - count] = temp;
            count++;

        }
        // Перестановка элементов побочной диагонали
        count = 0;
        for (int i = 0; i < a.length / 2; i++) {
            int temp;
            temp = a[length - count][i];
            a[length - count][i] = a[i][length - count];
            a[i][length - count] = temp;
            count++;
        }
        return a;
    }

    /*
Метод возвращает матрицу возрастающих чисел для последующего построения магического квадрата
   */
    public static int[][] matrixFilling(int n) {
        int[][] a = new int[n][n];
        int count = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = count;
                count++;
            }
        }
        return a;
    }


    public static void main(String[] args) {
/*
        int[][] a = randomArrayGenerator(10);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print("   " + a[i][j] + "[" + i + "][" + j + "]");
            }
            System.out.println();
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
*/

        int[][] a = evenMatrixSquare(4);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print("   " + a[i][j] + "[" + i + "][" + j + "]");
            }
            System.out.println();
        }


    }
}
