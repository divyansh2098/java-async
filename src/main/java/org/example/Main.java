package org.example;

public class Main {
  private static final int MAX_PASSWORD = 9999;

  public static void main(String[] args) {
    Thread thread =
        new Thread(
            () -> {
              System.out.println("From inside the thread: " + Thread.currentThread().getName());
              System.out.println("Priority: " + Thread.currentThread().getPriority());
            });
    thread.setName("New Worker Thread");
    thread.setPriority(Thread.MAX_PRIORITY);
    System.out.println("From before the thread: " + Thread.currentThread().getName());
    thread.start();
    System.out.println("From after creating thread: " + Thread.currentThread().getName());
  }
}
