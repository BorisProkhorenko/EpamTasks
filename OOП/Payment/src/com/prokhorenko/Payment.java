package com.prokhorenko;

import java.util.ArrayList;
import java.util.Objects;

public class Payment {
    private double price;
    private ArrayList<Purchase> purchases = new ArrayList<>();

    public double calculatePrice() {
        price=0;
        for (Purchase purchase : purchases) {
            if (purchase.getTotalPrice() <= 0)
                purchases.remove(purchase);
            price += purchase.getTotalPrice();
        }
        return price;

    }


    public void addToPurchases(String name, double priceOfPiece, int count) {
        Purchase newPurchase = new Purchase(name, priceOfPiece, count);
        for (Purchase purchase : purchases) {
            if (purchase.equals(newPurchase)) {
                purchase.setCount(purchase.getCount() + count);
                calculatePrice();
                return;
            }
        }
        purchases.add(new Purchase(name, priceOfPiece, count));
        calculatePrice();
    }

    public void deleteFromPurchases(String name, int count) {
        for (Purchase purchase : purchases) {
            if (purchase.getName().equals(name)) {
                purchase.setCount(purchase.getCount() - count);
                if (purchase.getCount() <= 0)
                    purchases.remove(purchase);
                calculatePrice();
                return;
            }

        }

    }
    public double getPrice() {
        return price;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "price=" + price +
                ", purchases=" + purchases +
                '}';
    }

    private class Purchase {
        private String name;
        private double priceOfPiece;
        private int count;
        private double totalPrice;

        public Purchase(String name, double priceOfPiece, int count) {
            this.name = name;
            this.priceOfPiece = priceOfPiece;
            this.count = count;
            totalPrice = priceOfPiece * count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPriceOfPiece() {
            return priceOfPiece;
        }

        public void setPriceOfPiece(double priceOfPiece) {
            this.priceOfPiece = priceOfPiece;
            totalPrice = priceOfPiece * count;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
            totalPrice = priceOfPiece * count;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Purchase purchase = (Purchase) o;
            return Double.compare(purchase.priceOfPiece, priceOfPiece) == 0 &&
                    Objects.equals(name, purchase.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, priceOfPiece, count, totalPrice);
        }

        @Override
        public String toString() {
            return "Purchase{" +
                    "name='" + name + '\'' +
                    ", priceOfPiece=" + priceOfPiece +
                    ", count=" + count +
                    ", totalPrice=" + totalPrice +
                    '}';
        }
    }

}
