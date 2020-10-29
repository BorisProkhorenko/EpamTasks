package com.prokhorenko;

public class BookList {
    private Book[] books;

    public BookList(Book[] books) {
        this.books = books;
    }

    public void authorPrint(String author) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getAuthor().equals(author))
                System.out.println(books[i]);
        }
    }

    public void publisherPrint(String publisher) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getPublishingHouse().equals(publisher))
                System.out.println(books[i]);
        }
    }

    public void yearPrint(int year) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getYearOfPublishing() >= year)
                System.out.println(books[i]);
        }
    }
}
