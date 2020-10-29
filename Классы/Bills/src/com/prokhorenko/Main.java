package com.prokhorenko;

public class Main {
/*
4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
всем счетам, имеющим положительный и отрицательный балансы отдельно
 */
    public static void main(String[] args) {
        Client boris=new Client("Boris");
        boris.addBill(299853945,0.5);
        boris.addBill(299853946,-0.5);
        boris.addBill(299853942,3);
        boris.addBill(299853940,-5);

        boris.sort();
        System.out.println(boris);

        System.out.println(boris.find(299853946));

        boris.swapLock(299853946);
        System.out.println(boris.find(299853946).isLocked());

        boris.swapLock(299853946);
        System.out.println(boris.find(299853946).isLocked());

        System.out.println(boris.sum());
        System.out.println(boris.positiveSum());
        System.out.println(boris.negativeSum());
    }
}
