package com.hello;

public class Clerk {
    private int prodcut = -1;

    public synchronized void setProduct(int prodcut) {
        while (this.prodcut != -1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.prodcut = prodcut;
        System.out.printf("Producer sets product: %d\n", this.prodcut);
        notify();
    }

    public synchronized int getProduct() {
        while (this.prodcut == -1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int p = this.prodcut;
        System.out.printf("Consumer gets product: %d\n", this.prodcut);
        this.prodcut = -1;
        notify();
        return p;
    }
}
