package com.example;

import com.completableFuture.CompletableFutureService;
import com.future.FutureService;

import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // FutureService.startThread();
        CompletableFutureService.run();

        // System.out.println(" Hello, world!! ");
    }
}
