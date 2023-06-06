package org.example.completablefuture;

import org.example.completablefuture.util.Util;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SupplyAsyncExample {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Util.print("Starting CompletableFuture");
    CompletableFuture<String> completableFuture =
        CompletableFuture.supplyAsync(
            () -> {
              try {
                Thread.sleep(2000);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
              return "String Result";
            });
    String result =
        completableFuture
            .get(); // execution blocked here, we can return result from the async function
    Util.print("Result " + result);
  }
}
