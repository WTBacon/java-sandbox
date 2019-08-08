package com.completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureService {

    public static void run() throws InterruptedException, ExecutionException {

        ExecutorService es = Executors.newWorkStealingPool();

        // 単純な非同期実行
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> Thread.currentThread().getId() + " : heavy process", es);
        System.out.println(future.get());

        //合成も可能
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> Thread.currentThread().getId() + " : task1", es);
        CompletableFuture<String> f2 = f1.thenApply((x) -> x + " <- join -> " + Thread.currentThread().getId() + " : task2");
        System.out.println(f2.get());

        // Listに詰めたり、一括処理したり
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int n = i;
            futures.add(CompletableFuture.runAsync(() -> System.out.println("task" + n), es));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[]{}));
    }
}
