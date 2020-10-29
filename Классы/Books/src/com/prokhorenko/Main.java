package com.prokhorenko;

/*
9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
методами. Задать критерии выбора данных и вывести эти данные на консоль.

Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
Найти и вывести:
a) список книг заданного автора;
b) список книг, выпущенных заданным издательством;
c) список книг, выпущенных после заданного года.
 */
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(1, "Побег из Шоушенка", "Стивен Кинг", "КАРО",
                412, 2018, 24, true);
        Book book2 = new Book(2, "Философия Java", "Брюс Эккель", "Питер",
                1151, 2019, 60, true);
        Book book3 = new Book(3, "Java. Методы программирования", "Игорь Блинов",
                "Четыре четверти", 895, 2013, 60, false);
        Book book4 = new Book(4, "Шантарам", "Грегори Дэвид Робертс",
                "The Big Book", 864, 2011, 29, true);
        Book book5 = new Book(5, "Оно", "Стивен Кинг", "The Big Book",
                436, 2011, 24, true);
        Book[] books = {book1, book2, book3, book4, book5};
        BookList bookList = new BookList(books);
        bookList.authorPrint("Стивен Кинг");
        bookList.publisherPrint("Питер");
        bookList.yearPrint(2015);

    }
}
