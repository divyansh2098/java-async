package org.example;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);
    public void increment() {
        this.count.incrementAndGet();
    }

    public Integer getCount() {
        return this.count.get();
    }
}
public class AtomicVariablesExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        AtomicCounter atomicCounter = new AtomicCounter();
        for(int i = 0; i < 1000; i++) {
            executorService.submit(atomicCounter::increment);
        }
        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("Final Count: " + atomicCounter.getCount());
    }
}
