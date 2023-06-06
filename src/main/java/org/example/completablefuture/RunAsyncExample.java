package org.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RunAsyncExample {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    System.out.println("About to run async funcitonality");
    CompletableFuture<Void> future =
        CompletableFuture.runAsync(
            () -> {
              try {
                Thread.sleep(2000);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              System.out.println("Running the asynchronous process");
            });
    System.out.println("registered the async functionality, Now waiting...");
    future.get(); // blocks execution and does not return any value
    System.out.println("Now completed");
  }
}
