package com.prokhorenko;

public class Book {

    private int id;
    private String name;
    private String author;
    private String publishingHouse;
    private int pages;
    private int yearOfPublishing;
    private double price;
    private boolean hardCover;

    public Book(int id, String name, String author, String publishingHouse, int pages, int yearOfPublishing,
                double price, boolean hardCover) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.pages = pages;
        this.yearOfPublishing = yearOfPublishing;
        this.price = price;
        this.hardCover = hardCover;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", pages=" + pages +
                ", yearOfPublishing=" + yearOfPublishing +
                ", price=" + price +
                ", hardCover=" + hardCover +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
