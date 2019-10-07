package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassangerThread extends Thread {

    Semaphore semaphore;
    int id;
    CountDownLatch LATCH;


    PassangerThread(Semaphore semaphore, int id, CountDownLatch LATCH) {
        this.semaphore = semaphore;
        this.id = id;
        this.LATCH = LATCH;
    }

    public synchronized void run() {
        try {
            semaphore.acquire();
            System.out.println("Пассажир" + id + "Покупает билет");
            System.out.println("Пассажир" + id + "Садиться автобус");
            semaphore.release();
            LATCH.countDown();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
