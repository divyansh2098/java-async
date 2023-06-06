package org.example.completablefuture.transformers;

import org.example.completablefuture.util.Util;

import java.util.concurrent.*;

public class ThenApplyExample {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    CompletableFuture<String> completableFuture =
        CompletableFuture.supplyAsync(
            () -> {
              try {
                TimeUnit.SECONDS.sleep(3);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              Util.print("Supply running in thread: " + Thread.currentThread().getName());
              return "Divyansh";
            }, executorService);
    CompletableFuture<Integer> transformedFuture =
        completableFuture.thenApplyAsync(
            (String result) -> {
              try {
                TimeUnit.SECONDS.sleep(2);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              Util.print(
                  "Transform executing in thread: "
                      + Thread.currentThread()
                          .getName()); // should be same thread as that in supplyAsync
              return result.length();
            }, executorService);
    Util.print("Can execute code here on thread: " + Thread.currentThread().getName());
    Integer result = transformedFuture.get(); // This blocks the execution until complete
    Util.print("Check if this is blocking");
    Util.print("Result: " + result);
  }
}
