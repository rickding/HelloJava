package com.hello;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Thread producerThread = new Thread(new Producer(clerk));
        Thread consumerThread = new Thread(new Consumer(clerk));

        producerThread.start();
        consumerThread.start();
    }
}
