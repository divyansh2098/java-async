package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SynchronizedCounter {
    private Integer counter = 0;

    public void increment() {
        synchronized (this) {
            this.counter = this.counter + 1;
        }
    }

    public Integer getCount() {
        return this.counter;
    }
}
public class RaceConditionExample {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 1000; i++) {
            executorService.submit(() -> synchronizedCounter.increment());
        }
        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("Final Count is: " + synchronizedCounter.getCount());
    }
}
