package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MemoryConsistencyExample {

  // volatile instructs to not cache this variable so that threads read it from memory, not from
  // some
  // temporary register
  private static volatile Boolean sayHello = false;

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    executorService.submit(
        () -> {
          while (!sayHello) {}
          System.out.println("Hello World");
          while (sayHello) {}
          System.out.println("Goodbye!!");
        });
    Thread.sleep(1000);
    System.out.println("Say Hello");
    sayHello = true;
    System.out.println("Say Goodbye");
    sayHello = false;
  }
}
