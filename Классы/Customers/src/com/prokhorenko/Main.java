package com.prokhorenko;

/*
8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
и методами. Задать критерии выбора данных и вывести эти данные на консоль.

Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
Найти и вывести:
a) список покупателей в алфавитном порядке;
b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 */
public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Прохоренко", "Борис", "Алексеевич",
                000000000000001, "12345678901234567890");
        Customer customer2 = new Customer(2, "Иванов", "Иван", "Иванович",
                1111111111111111L, "12345678901234567891");
        Customer customer3 = new Customer(3, "Прохоренко", "Алексей", "Борисович",
                2222222222222222L, "32345678901234567890");
        Customer customer4 = new Customer(4, "Азаренко", "Виктор", "Алексеевич",
                3333333333333333L, "12345678901234567895");

        Customer[] customers = {customer1, customer2, customer3, customer4};
        CustomerList customerList = new CustomerList(customers);
        customerList.alphabetPrint();
      //  customerList.rangePrint(0,1111111111111112L);

    }
}
