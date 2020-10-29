package com.prokhorenko;

import java.util.Objects;

public class Book {
    private int id;
    private String bookName;
    private String author;
    private String publishingHouse;
    private int yearOfPublishing;
    private int pagesCount;
    private boolean eBook;


    public Book() {
    }

    public Book(int id, String bookName, String author, String publishingHouse, int yearOfPublishing,
                int pagesCount, boolean eBook) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.yearOfPublishing = yearOfPublishing;
        this.pagesCount = pagesCount;
        this.eBook = eBook;
    }

    public String getDescription() {
        String bookDescription = "id: " + id + ", book name: " + bookName +
                ", author: " + author + ", publishing house: " + publishingHouse +
                ", year of publishing: " + yearOfPublishing + ", number of pages: " + pagesCount;
        if (eBook)
            bookDescription += ", electronic version.";
        else
            bookDescription += ", paper version";
        return bookDescription;
    }

    public void print() {
        System.out.println(getDescription());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public boolean isEBook() {
        return eBook;
    }

    public void setEBook(boolean eBook) {
        this.eBook = eBook;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                eBook == book.eBook &&
                pagesCount == book.pagesCount &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publishingHouse, book.publishingHouse) &&
                Objects.equals(yearOfPublishing, book.yearOfPublishing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, author, publishingHouse, yearOfPublishing, eBook, pagesCount);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", yearOfPublishing='" + yearOfPublishing + '\'' +
                ", pagesCount=" + pagesCount +
                ", eBook=" + eBook +
                '}';
    }
}
