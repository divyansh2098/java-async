package org.example.completablefuture.transformers;

import org.example.completablefuture.util.Util;

import java.util.concurrent.*;

public class ThenApplyAsyncExample {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
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
                    });
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
                                      .getName()); // should be a different thread from that in supplyAsync
                      return result.length();
                    });
    Util.print("Can execute code here on thread: " + Thread.currentThread().getName());
    Integer result = transformedFuture.get(); // This blocks the execution
    Util.print("Result: " + result);
  }
}
