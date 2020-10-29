package com.prokhorenko;

import java.util.Date;
import java.util.Scanner;

public class Admin extends User {

    public Admin() {

    }

    public Admin(String username, String password, Catalog catalog) {
        super(username, password, catalog);
    }

    public void changeAdminStatus(User user) {
        if (user instanceof Admin) {
            super.getCatalog().unmakeAdmin((Admin) user);
        } else
            super.getCatalog().makeAdmin(user);
    }

    public void removeUser(User user) {
        super.getCatalog().removeUser(user);
        super.getCatalog().adminCheck();
    }


    public void deleteBookById(int id) {
        for (Book book : super.getCatalog().getBooks()) {
            if (id == book.getId()) {
                super.getCatalog().getBooks().remove(book);
                super.getCatalog().reWriteBooks();
                return;
            }
        }
    }

    public void deleteBookByName(String name) {
        for (Book book : super.getCatalog().getBooks()) {
            if (name.equals(book.getBookName())) {
                super.getCatalog().getBooks().remove(book);
                super.getCatalog().reWriteBooks();
                return;
            }
        }
    }

    public void addBook(String bookName, String author, String publishingHouse, int yearOfPublishing,
                        int pagesCount, boolean eBook) {
        int id = super.getCatalog().getBooks().size() + 1;
        Book book = new Book(id, bookName, author, publishingHouse, yearOfPublishing, pagesCount, eBook);
        super.getCatalog().getBooks().add(book);
        super.getCatalog().reWriteBooks();
        Date date = new Date();
        String message = date.toString() + " User " + super.getUsername() + " added a book: " + book.getDescription();
        System.out.println(message);
        super.getCatalog().sendToUsers(message, false);

    }

    public void addBook(Book book) {
        super.getCatalog().getBooks().add(book);
    }

    public void changeDescription(Book book) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Book name\n2-Author\n3-Publishing house\n4-Year of publishing" +
                "\n5-Number of pages\n6-Electronic\\Paper");
        int answer = 0;
        if (scanner.hasNextInt()) {
            answer = Integer.parseInt(scanner.nextLine());
        }
        switch (answer) {
            case 1:
                System.out.println("Enter the book name");
                book.setBookName(scanner.nextLine());
                break;
            case 2:
                System.out.println("Enter the author");
                book.setAuthor(scanner.nextLine());
                break;
            case 3:
                System.out.println("Enter the publishing house");
                book.setPublishingHouse(scanner.nextLine());
                break;
            case 4:
                System.out.println("Enter the year of publishing");
                if (scanner.hasNextInt()) {
                    book.setYearOfPublishing(Integer.parseInt(scanner.nextLine()));
                }
                break;
            case 5:
                System.out.println("Enter the number of pages");
                if (scanner.hasNextInt()) {
                    book.setPagesCount(Integer.parseInt(scanner.nextLine()));
                }
                break;
            case 6:
                if (book.isEBook()) {
                    book.setEBook(false);
                    System.out.println("Changed to paper version");
                } else {
                    book.setEBook(true);
                    System.out.println("Changed to electronic version");
                }
                break;
        }
    }


}
