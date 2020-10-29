package com.prokhorenko;

public class Main {

    public static void main(String[] args) {

        Book book1 = new Book(1, "Little Prince", "Exupery",
                "Dom", 300, 1968, 20);
        Book book2 = new Book(2, "Escape from Showshank", "Stephen King",
                "Light", 340, 1990, 26);
        Book book3 = new Book(3, "Shantaram", "NePomny",
                "Hz", 750, 2000, 25);

        Book[] books = {book1, book2, book3};
        BookList bookList = new BookList(books);
        bookList.yearPrint(1990);

    }
}

