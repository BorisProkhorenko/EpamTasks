package com.prokhorenko;

/*
Задание 2. Блокнот. Разработать консольное приложение, работающее с Заметками
в Блокноте. Каждая Заметка это: Заметка (тема, дата создания, e-mail, сообщение).

Общие пояснения к практическому заданию.
• В начале работы приложения данные должны считываться из файла, в конце
работы – сохраняться в файл.
• У пользователя должна быть возможность найти запись по любому параметру
или по группе параметров (группу параметров можно определить
самостоятельно), получить требуемые записи в отсортированном виде, найти
записи, текстовое поле которой содержит определенное слово, а также
добавить новую запись.
• Особое условие: поиск, сравнение и валидацию вводимой информации
осуществлять с использованием регулярных выражений.
• Особое условие: проверку введенной информации на валидность должен
осуществлять код, непосредственно добавляющий информацию.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NotebookBuilder nb = new NotebookBuilder();
        Notebook notebook = nb.buildNotebook();
        menu(notebook);

    }

    public static void menu(Notebook notebook) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Show notes\n2 - Custom search\n3 - Create a note\n4 - Finish");
            int answer;
            try {
                answer = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Incorrect input");
                continue;
            }
            switch (answer) {
                case 1:
                    notePrintFromList(notebook.getNotes());
                    break;
                case 2:
                    searchMenu(notebook);
                    break;
                case 3:
                    notebook.createNote();
                    break;
                case 4:
                    notebook.reWriteNotes();
                    System.exit(0);
                default:
                    System.out.println("Incorrect input");
                    break;
            }

        }
    }

    public static void searchMenu(Notebook notebook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word or line you want to search");
        String searchLine = scanner.nextLine();
        boolean subjectSearch;
        boolean dateSearch;
        boolean mailSearch;
        boolean messageSearch;
        subjectSearch = searchMenuHelper("Subject");
        dateSearch = searchMenuHelper("Date");
        mailSearch = searchMenuHelper("E-mail");
        messageSearch = searchMenuHelper("Message");
        ArrayList<Note> list = notebook.customSearch(searchLine, subjectSearch, dateSearch, mailSearch, messageSearch);
        Collections.sort(list);
        notePrintFromList(list);
    }

    public static boolean searchMenuHelper(String fieldName) {
        Scanner scanner = new Scanner(System.in);
        int answer;
        System.out.println("Search in " + fieldName + " field?\n1-Yes\n2-No");
        try {
            answer = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Incorrect input");
            return searchMenuHelper(fieldName);
        }

        if (answer == 1) {
            return true;
        } else if (answer == 2) {
            return false;
        } else {
            System.out.println("Incorrect input");
            return searchMenuHelper(fieldName);
        }
    }

    public static void notePrintFromList(ArrayList<Note> list) {
        for (Note note : list) {
            note.print();
            System.out.println("__________________________________________________________________________________");
        }
    }
}
