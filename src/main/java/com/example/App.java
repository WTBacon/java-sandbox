package com.example;

import com.completableFuture.completableFutureService;
import com.future.FutureService;

import java.util.concurrent.*;

public class App {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // FutureService.startThread();
        completableFutureService.run();

        // System.out.println(" Hello, world!! ");
    }
}
