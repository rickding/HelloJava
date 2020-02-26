package com.hello;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        executorService.execute(new Producer(clerk));
        executorService.execute(new Consumer(clerk));
    }
}
