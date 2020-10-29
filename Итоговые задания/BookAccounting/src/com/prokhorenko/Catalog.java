package com.prokhorenko;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public final class Catalog {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Catalog() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void printBooks() {
        for (Book book : books) {
            book.print();
        }
    }

    public void reWriteBooks() {
        String line = "";
        for (Book book : books) {
            line += book.getBookName() + "|" +
                    book.getAuthor() + "|" +
                    book.getPublishingHouse() + "|" +
                    book.getYearOfPublishing() + "|" +
                    book.getPagesCount() + "|" +
                    book.isEBook() + "\n";
        }
        try {
            FileWriter fw = new FileWriter(new File("").getAbsolutePath() +
                    "\\src\\com\\prokhorenko\\resources\\catalog", false);
            fw.append(line);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean createUser(String username, String password) {
        if (findUserByName(username) != null) {
            System.out.println("Username already exists");
            return false;
        }
        if (users.isEmpty())
            users.add(new Admin(username, password, this));
        else
            users.add(new User(username, password, this));
        reWriteUsers();
        return true;
    }

    public User findUserByName(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
        reWriteUsers();
    }

    public void removeUser(User user) {
        users.remove(user);
        reWriteUsers();
    }

    public void removeUser(int index) {
        users.remove(index);
        reWriteUsers();
    }

    public void showUsers() {
        for (User user : users) {
            System.out.print(user.getUsername());
            if (user instanceof Admin) {
                System.out.print(" - Admin");
            }
            System.out.println();
        }
    }

    public void adminCheck() {
        if (users.isEmpty())
            return;
        for (User user : users) {
            if (user instanceof Admin)
                return;
        }
        makeAdmin(0);
    }

    public void makeAdmin(int index) {
        User user = users.get(index);
        Admin admin = new Admin(user.getUsername(), user.getPassword(), this);
        users.remove(index);
        users.add(index, admin);
        reWriteUsers();
    }

    public void makeAdmin(User user) {
        if (users.contains(user)) {
            makeAdmin(users.indexOf(user));
        }
    }

    public void unmakeAdmin(Admin admin) {
        if (users.contains(admin)) {
            User user = new User(admin.getUsername(), admin.getPassword(), this);
            int index = users.indexOf(admin);
            users.remove(admin);
            users.add(index, user);
            adminCheck();
            reWriteUsers();
        }
    }


    public void reWriteUsers() {
        String line = "";
        for (User user : users) {
            line += user.getUsername() + "|" +
                    user.getPassword() + "|";
            if (user instanceof Admin)
                line += "true\n";
            else
                line += "false\n";
        }
        try {
            FileWriter fw = new FileWriter(new File("").getAbsolutePath() +
                    "\\src\\com\\prokhorenko\\resources\\validation", false);
            fw.append(line);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToUsers(String message, boolean adminOnly) {
        if (adminOnly) {
            for (User user : users) {
                if (user instanceof Admin)
                    user.getMail().add(0, message);
            }
        } else {
            for (User user : users) {
                user.getMail().add(0, message);
            }

        }
    }

    public void showPages() {
        String[] pages = makeCatalogPages();
        int pageIndex = 0;
        System.out.println("page " + (pageIndex + 1) + "/" + pages.length + "\n" + pages[pageIndex]);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1-next\n2-previous\n3-back");
            int answer = scanner.nextInt();
            if (answer < 1 || answer > 3)
                continue;
            switch (answer) {
                case 1:
                    if (pageIndex + 1 < pages.length) {
                        pageIndex++;
                        System.out.print("page " + (pageIndex + 1) + "/" + pages.length + "\n" + pages[pageIndex]);
                    } else
                        System.out.println("This is the last page");
                    break;
                case 2:
                    if (pageIndex - 1 >= 0) {
                        pageIndex--;
                        System.out.print("page " + (pageIndex + 1) + "/" + pages.length + "\n" + pages[pageIndex]);
                    } else
                        System.out.println("This is the first page");
                    break;
                default:
                    return;
            }

        }
    }

    public String[] makeCatalogPages() {
        int pagesCount;
        if (books.size() % 5 == 0)
            pagesCount = books.size() / 5;
        else
            pagesCount = books.size() / 5 + 1;
        String[] pages = new String[pagesCount];
        int index = 0;
        for (int i = 0; i < pages.length; i++) {
            pages[i] = "";
            for (int j = 0; j < 5; j++) {
                try {
                    pages[i] += books.get(index).getDescription() + "\n";
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
                index++;
            }
        }


        return pages;
    }

    public Book parseBook() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        book.setId(books.size() + 1);
        System.out.println("Enter the book name");
        book.setBookName(scanner.nextLine());
        System.out.println("Enter the author");
        book.setAuthor(scanner.nextLine());
        System.out.println("Enter the publishing house");
        book.setPublishingHouse(scanner.nextLine());
        System.out.println("Enter the year of publishing");
        if (scanner.hasNextInt()) {
            book.setYearOfPublishing(Integer.parseInt(scanner.nextLine()));
        } else {
            System.out.println("Incorrect value," +
                    " default value(0) will be set");
            book.setYearOfPublishing(0);
        }
        System.out.println("Enter the number of pages");
        if (scanner.hasNextInt()) {
            book.setPagesCount(Integer.parseInt(scanner.nextLine()));
        } else {
            System.out.println("Incorrect value," +
                    " default value(0) will be set");
            book.setPagesCount(0);
        }
        System.out.println("1-electronic\n2-paper version");
        if (scanner.hasNextInt()) {
            int temp = scanner.nextInt();
            if (temp == 2) {
                book.setEBook(false);
            } else if (temp != 1) {
                System.out.println("Incorrect value," +
                        " default value(electronic) will be set");
                book.setEBook(true);
            } else
                book.setEBook(true);
        }
        return book;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(books, catalog.books) &&
                Objects.equals(users, catalog.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, users);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "books=" + books +
                ", users=" + users +
                '}';
    }
}
