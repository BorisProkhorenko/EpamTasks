package com.prokhorenko;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    /*
    2. Дана строка, содержащая следующий текст (xml-документ):
<notes>
 <note id = "1">
 <to>Вася</to>
 <from>Света</from>
 <heading>Напоминание</heading>
 <body>Позвони мне завтра!</body>
 </note>
 <note id = "2">
 <to>Петя</to>
 <from>Маша</from>
 <heading>Важное напоминание</heading>
 <body/>
 </note>
</notes>
Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
нельзя.
     */

    public static String finder(String s, Matcher matcher) {
        int start = matcher.start();
        int end = matcher.end();
        return s.substring(start, end);

    }

    public static void parseText(String s) {
        String[] strings = s.split("\n");// Разбиваем текст на строки для последовательного анализа
        for (String line : strings) {
            regXmlParser(line);
        }
    }

    public static void regXmlParser(String s) {
        Pattern openPattern = Pattern.compile("<([^\\/].*?[^\\/])>");
        Matcher openMatcher = openPattern.matcher(s);
        Pattern closePattern = Pattern.compile("<(\\/.*?)>");
        Matcher closeMatcher = closePattern.matcher(s);
        Pattern contentPattern = Pattern.compile(">.*?<");
        Matcher contentMatcher = contentPattern.matcher(s);
        Pattern emptyPattern = Pattern.compile("<.*?[\\/]>");
        Matcher emptyMatcher = emptyPattern.matcher(s);

        if (openMatcher.find()) {
            System.out.println(finder(s, openMatcher) + " - Открывающий тег");
        }
        if (contentMatcher.find()) {
            System.out.println(finder(s, contentMatcher) + " - Содержимое тега");
        }
        if (closeMatcher.find()) {
            System.out.println(finder(s, closeMatcher) + " - Закрывающий тег");
        }
        if (emptyMatcher.find()) {
            System.out.println(finder(s, emptyMatcher) + " - Тег без тела");
        }

    }

    public static void main(String[] args) {
        String text = "<notes>" +
                "\n\t<note id = \"1\">" +
                "\n\t\t<to>Вася</to>" +
                "\n\t\t<from>Света</from>" +
                "\n\t\t<heading>Напоминание</heading>" +
                "\n\t\t<body>Позвони мне завтра!</body>" +
                "\n\t</note>" +
                "\n\t<note id = \"2\">" +
                "\n\t\t<to>Петя</to>" +
                "\n\t\t<from>Маша</from>" +
                "\n\t\t<heading>Важное напоминание</heading>" +
                "\n\t\t<body/>" +
                "\n\t</note>" +
                "\n</notes>";
        parseText(text);

    }
}
