package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {
  public static void main(String[] args) {
    System.out.println("Starting Execution");
    ExecutorService executor = Executors.newFixedThreadPool(3);
    System.out.println("Giving task to executor");
    executor.submit(
        () -> {
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          System.out.println("Inside 1st worker thread");
        });
    executor.submit(
        () -> {
          System.out.println("Inside 2nd worker thread");
        });
    executor.submit(
        () -> {
          System.out.println("Inside 3rd worker thread");
        });
    System.out.println("Done giving task");
  }
}
