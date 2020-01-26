package com.hello;

public class Clerk {
    private int product = -1;

    public synchronized void setProduct(int product) {
        while (this.product != -1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Producer sets product: %d\n", product);
        this.product = product;
        notify();
    }

    public synchronized void getProduct() {
        while (this.product == -1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Consumer gets product: %d\n", this.product);
        this.product = -1;
        notify();
    }
}
