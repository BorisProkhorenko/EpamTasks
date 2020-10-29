package com.prokhorenko;

public class Main {

    /*
    1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
     */
    public static void first(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            int length = strings[i].length();
            for (int j = 1; j <= length; j++) {
                if (Character.isUpperCase(strings[i].charAt(j))) {
                    strings[i] = stringPaste(strings[i], "_", j);
                    j++;
                }
            }
            strings[i] = strings[i].toLowerCase();
        }

    }

    /*
Вставка одной строки в другую с позиции i
     */
    public static String stringPaste(String s, String p, int i) {
        String s1 = s.substring(0, i) + p + s.substring(i);
        return s1;
    }

    /*
2. Замените в строке все вхождения 'word' на 'letter'.
     */
    public static String second(String s) {
        s = s.replace("word", "letter");
        return s;
    }

    /*
3. В строке найти количество цифр.
     */
    public static int third(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 47 && s.charAt(i) < 58)
                count++;
        }
        return count;
    }

    /*
Является ли символ числом(если да - true, нет - false)
     */
    public static boolean isNum(char c) {
        if (c > 47 && c < 58)
            return true;
        return false;
    }

    /*
4. В строке найти количество чисел
     */
    public static int fourth(String s) {
        int count = 0;
        boolean b = false;
        for (int i = 0; i < s.length(); i++) {
            if (isNum(s.charAt(i)) && b == false) {
                b = true;
                count++;
            } else if (!isNum(s.charAt(i))) {
                b = false;
            }
        }
        return count;
    }

    /*
5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
Крайние пробелы в строке удалить.
     */
    public static String fifth(String s) {
        String sum = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sum += s.charAt(i);
            } else if (sum.length() > 1) {
                s = s.replace(sum, " ");
                i -= sum.length() - 1;
                sum = "";
            } else {
                sum = "";
            }
        }
        s = begEndSpacesDelete(s);
        return s;
    }

    /*
Возвращает строку без пробелов вначале и конце строки
    */
    public static String begEndSpacesDelete(String s) {
        if (s.charAt(0) == ' ') {
            s = s.substring(1);
        }
        if (s.charAt(s.length() - 1) == ' ') {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    /*
 Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем
     */
    public static int sixth(String s) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
                if (max < count) {
                    max = count;
                    continue;
                }
            } else count = 0;

        }
        return max;
    }

    /*
 В строке вставить после каждого символа 'a' символ 'b'.
     */
    public static void seventh(StringBuilder stringBuilder) {
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == 'a') {
                stringBuilder.insert(i + 1, "b");
            }
        }
    }

    /*
Проверить, является ли заданное слово палиндромом
     */
    public static boolean eighth(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        if (s.equals(stringBuilder.toString()))
            return true;
        return false;
    }

    /*
С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”
     */
    public static String ninth() {
        String info = "информатика";
        return String.copyValueOf(info.toCharArray(), 7, 1) +
                String.copyValueOf(info.toCharArray(), 3, 2) +
                String.copyValueOf(info.toCharArray(), 7, 1);
    }

    /*
Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
     */
    public static int tenth(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a')
                count++;
        }
        return count;
    }

    /*
Из заданной строки получить новую, повторив каждый символ дважды.
     */
    public static String eleventh(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < stringBuilder.length(); i += 2) {
            stringBuilder.insert(i + 1, stringBuilder.charAt(i));
        }
        return stringBuilder.toString();
    }

    /*
 Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
def", то должно быть выведено "abcdef".
     */
    public static String twelves(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < stringBuilder.length(); i++) {
            for (int j = i + 1; j < stringBuilder.length(); j++) {
                if (stringBuilder.charAt(i) == stringBuilder.charAt(j) || stringBuilder.charAt(j) == ' ')
                    stringBuilder.deleteCharAt(j);
            }
        }
        return stringBuilder.toString();
    }

    /*
 Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
длинных слов может быть несколько, не обрабатывать.
     */
    public static void thirteenth(String s) {
        String[] strings = s.split("\\s");
        int max = strings[0].length();
        int maxInd = 0;
        boolean isUnique = true;
        for (int i = 1; i < strings.length; i++) {
            if (max == strings[i].length()) {
                isUnique = false;
            }
            if (max < strings[i].length()) {
                max = strings[i].length();
                maxInd = i;
                isUnique = true;
            }
        }
        if (isUnique)
            System.out.println(strings[maxInd]);
        else
            System.out.println("Не обрабатываю");
    }

    /*
 Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские
буквы.
     */
    public static void fourteenth(String s) {
        int low = 0;
        int up = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 64 && s.charAt(i) < 91)
                up++;
            else if (s.charAt(i) > 96 && s.charAt(i) < 123)
                low++;
        }
        System.out.println("upperCase = " + up + " lowerCase = " + low);
    }

    /*
Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
знаком. Определить количество предложений в строке X.

     */
    public static int fifteenth(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.' || s.charAt(i) == '!' || s.charAt(i) == '?')
                count++;
        }
        return count;
    }


    public static void main(String[] args) {

    }
}
