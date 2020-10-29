package com.prokhorenko;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CatalogBuilder {

    private String booksFilePath;
    private String usersFilePath;

    public CatalogBuilder() {
        booksFilePath = new File("").getAbsolutePath() +
                "\\src\\com\\prokhorenko\\resources\\catalog";
        usersFilePath = new File("").getAbsolutePath() +
                "\\src\\com\\prokhorenko\\resources\\validation";
    }

    public CatalogBuilder(String booksFilePath, String usersFilePath) {
        this.booksFilePath = booksFilePath;
        this.usersFilePath = usersFilePath;
    }

    public Catalog buildCatalog() {
        Catalog catalog = new Catalog();
        catalog.setBooks(parseBooks(readData(booksFilePath)));
        catalog.setUsers(parseUsers(readData(usersFilePath), catalog));
        return catalog;

    }

    private ArrayList<Book> parseBooks(String[] booksData) {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        int id = 1;
        for (String line : booksData) {
            String[] parameters = line.split("\\|");
            bookArrayList.add(new Book(id, parameters[0], parameters[1], parameters[2], Integer.parseInt(parameters[3]),
                    Integer.parseInt(parameters[4]), Boolean.parseBoolean(parameters[5])));
            id++;
        }
        return bookArrayList;
    }

    private ArrayList<User> parseUsers(String[] usersData, Catalog catalog) {
        ArrayList<User> userArrayList = new ArrayList<>();
        for (String line : usersData) {
            String[] parameters = line.split("\\|");
            if (Boolean.parseBoolean(parameters[2]))
                userArrayList.add(new Admin(parameters[0], parameters[1], catalog));
            else
                userArrayList.add(new User(parameters[0], parameters[1], catalog));
        }
        return userArrayList;
    }

    private String[] readData(String filePath) {

        String line;
        ArrayList<String> data = new ArrayList<>();

        try (FileReader inputStream = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(inputStream)) {
            while ((line = reader.readLine()) != null && !line.equals("")) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toArray(new String[0]);
    }

    public String getBooksFilePath() {
        return booksFilePath;
    }

    public void setBooksFilePath(String booksFilePath) {
        this.booksFilePath = booksFilePath;
    }

    public String getUsersFilePath() {
        return usersFilePath;
    }

    public void setUsersFilePath(String usersFilePath) {
        this.usersFilePath = usersFilePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogBuilder that = (CatalogBuilder) o;
        return Objects.equals(booksFilePath, that.booksFilePath) &&
                Objects.equals(usersFilePath, that.usersFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(booksFilePath, usersFilePath);
    }

    @Override
    public String toString() {
        return "CatalogBuilder{" +
                "booksFilePath='" + booksFilePath + '\'' +
                ", usersFilePath='" + usersFilePath + '\'' +
                '}';
    }
}
