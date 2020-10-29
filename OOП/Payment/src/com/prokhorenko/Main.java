package com.prokhorenko;
 /*
 Задача 2.
Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
нескольких товаров.

  */
public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.addToPurchases("toy", 54,3);
        payment.addToPurchases("chair", 4.99,4);
        System.out.println(payment);
        payment.deleteFromPurchases("toy",2);
        System.out.println(payment);
        payment.deleteFromPurchases("chair", 4);
        System.out.println(payment);
    }
}
