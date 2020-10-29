package com.prokhorenko;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

/*

Задание 1: создать консольное приложение “Учет книг в домашней библиотеке”.
Общие требования к заданию:
• Система учитывает книги как в электронном, так и в бумажном варианте.  +
• Существующие роли: пользователь, администратор.  +
• Пользователь может просматривать книги в каталоге книг, осуществлять поиск
книг в каталоге.   +
• Администратор может модифицировать каталог.   +
• *При добавлении описания книги в каталог оповещение о ней рассылается на
e-mail всем пользователям
• **При просмотре каталога желательно реализовать постраничный просмотр
• ***Пользователь может предложить добавить книгу в библиотеку, переслав её
администратору на e-mail.
• Каталог книг хранится в текстовом файле.  +
• Данные аутентификации пользователей хранятся в текстовом файле. Пароль
не хранится в открытом виде

 */
public class Main {

    public static void main(String[] args) {
        CatalogBuilder catalogBuilder = new CatalogBuilder();
        Catalog catalog = catalogBuilder.buildCatalog();


        menu(catalog);

    }

    public static void menu(Catalog catalog) {
        while (true) {
            User user = null;
            try {
                user = validationStep(catalog);
                System.out.println(user.getCatalog());
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            System.out.println("Hello, " + user.getUsername() + "!\n");
            userOptions(user);
        }
    }

    public static User validationStep(Catalog catalog) throws InvalidKeySpecException, NoSuchAlgorithmException {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - Sign in\n2 - New user");
            int answer;
            if (scanner.hasNextInt())
                answer = Integer.parseInt(scanner.nextLine());
            else
                continue;
            if (answer < 1 || answer > 2)
                continue;
            System.out.println("Enter username");
            String username = scanner.nextLine();
            System.out.println("Enter password");
            String password = scanner.nextLine();
            if (answer == 2) {
                if (catalog.createUser(username, password)) {
                    System.out.println("User " + username + " created");
                    continue;
                }
            }
            return validation(username, password, catalog);
        }
    }

    public static User validation(String username, String password, Catalog catalog)
            throws InvalidKeySpecException, NoSuchAlgorithmException {

        for (User user : catalog.getUsers()) {
            if (user.getUsername().equals(username) && PasswordHash.validatePassword(password, user.getPassword())) {
                return user;

            }
        }
        System.out.println("Incorrect username or password");
        return validationStep(catalog);
    }

    public static void userOptions(User user) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int answer;
            System.out.println("0-Back to Registration\n1-Show book catalog\n2-Find a book\n" +
                    "3-Offer a book\n4-Show e-mail\n5-Show users");
            if (user instanceof Admin) {
                System.out.println("6-Add a book\n7-Remove a book\n8-Change book description\n" +
                        "9-Share(revoke) admin rights\n10-Delete a user");
            }
            try {
                answer = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                continue;
            }
            Book book;
            switch (answer) {
                case 0:
                    return;
                case 1:
                    user.getCatalog().showPages();
                    break;
                case 2:
                    System.out.println("Enter a book name");
                    book = user.findByName(scanner.nextLine());
                    if (book != null)
                        book.print();
                    break;
                case 3:
                    book = user.getCatalog().parseBook();
                    user.offer(book);
                    break;
                case 4:
                    user.showMail();
                    break;
                case 5:
                    user.getCatalog().showUsers();
                    break;
                case 6:
                    if (user instanceof Admin) {
                        book = user.getCatalog().parseBook();
                        ((Admin) user).addBook(book);
                    } else {
                        System.out.println("Incorrect input");
                    }
                    break;

                case 7:
                    if (user instanceof Admin) {
                        System.out.println("Enter the name of the book you want to remove");
                        ((Admin) user).deleteBookByName(scanner.nextLine());
                    } else {
                        System.out.println("Incorrect input");
                    }
                    break;
                case 8:
                    if (user instanceof Admin) {
                        System.out.println("Enter the name of the book you want to edit");
                        book = user.findByName(scanner.nextLine());
                        if (book != null)
                            ((Admin) user).changeDescription(book);
                    } else {
                        System.out.println("Incorrect input");
                    }
                    break;
                case 9:
                    if (user instanceof Admin) {
                        System.out.println("Enter username");
                        String username = scanner.nextLine();
                        boolean isThisUser = user.equals(user.getCatalog().findUserByName(username));
                        ((Admin) user).changeAdminStatus(user.getCatalog().findUserByName(username));
                        if (isThisUser) {
                            return;
                        }
                    } else {
                        System.out.println("Incorrect input");
                    }
                    break;
                case 10:
                    if (user instanceof Admin) {
                        System.out.println("Enter username");
                        try {
                            User u = user.getCatalog().findUserByName(scanner.nextLine());
                            ((Admin) user).removeUser(u);
                            if (u.equals(user)) {
                                user.getCatalog().adminCheck();
                                return;
                            } else {
                                System.out.println("Incorrect input");
                                break;
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Incorrect username");
                            break;
                        }
                    }
                default:
                    System.out.println("Incorrect input");
                    userOptions(user);
                    break;
            }
        }
    }
}
