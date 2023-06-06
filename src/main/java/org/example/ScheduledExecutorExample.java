package org.example;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {
    public static void main(String[] args) {
        System.out.println("Creating a scheduled task");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(() -> {
            System.out.println("Inside the scheduled job");
        }, 5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("Inside the periodic task" + System.nanoTime());
        }, 0, 2, TimeUnit.SECONDS);
        System.out.println("Finished scheduling the task");
    }
}
