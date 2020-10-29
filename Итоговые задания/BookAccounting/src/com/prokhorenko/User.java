package com.prokhorenko;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class User {
    private Catalog catalog;
    private String username;
    private String password;
    private ArrayList<String> eMail = new ArrayList<>();

    public User() {
    }

    public User(String username, String password, Catalog catalog) {
        this.username = username;
        this.catalog = catalog;
        if (password.matches("1000:\\w{48}:\\w{48}"))
            this.password = password;
        else {
            try {
                this.password = PasswordHash.createHash(password);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            }
        }
    }
    public void showBooks() {
        catalog.printBooks();
    }

    public Book findById(int id) {
        for (Book book : catalog.getBooks()) {
            if (id == book.getId())
                return book;
        }
        System.out.println("Book not found");
        return null;
    }

    public Book findByName(String name) {
        for (Book book : catalog.getBooks()) {
            if (name.equals(book.getBookName()))
                return book;
        }
        System.out.println("Book not found");
        return null;
    }

    public void offer(Book book) {
        Date date = new Date();
        String message = date.toString() + " User " + username + " offered the book: " + book.getDescription();
        catalog.sendToUsers(message, true);
    }

    public void showMail() {
        for (String mail : eMail) {
            System.out.println(mail);
        }
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            this.password = PasswordHash.createHash(password);
        } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (InvalidKeySpecException e) {
        e.printStackTrace();
    }
    }

    public ArrayList<String> getMail() {
        return eMail;
    }

    public void setMail(ArrayList<String> eMail) {
        this.eMail = eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(catalog, user.catalog) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalog, username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                '}';
    }

}
