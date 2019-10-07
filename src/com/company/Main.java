package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    private static final int PASSANGER_COUNT=100;
    private static CountDownLatch LATCH;

    public static void main(String[] args) throws InterruptedException{

        LATCH = new CountDownLatch(PASSANGER_COUNT);
        Semaphore sem = new Semaphore(4);
        for (int i = 1; i <101 ; i++) {
            new PassangerThread(sem, i, LATCH).start();

        }
        LATCH.await();
        System.out.println("Поехали");


    }
}
