package com.future;

public class FutureService extends Thread{

    private static FuturePrinter printer;

    public static void startThread() {
        printer = new FuturePrinter();
        // start(main) と run(Thread-0) の2つの thread が走る.
        new FutureService().start();
        System.out.println(Thread.currentThread().getName() + " is printing...");
        printer.print("Hello, world (1).");
        printer.print("Hello, world (2).");
        printer.print("Hello, world (3).");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is sleeping.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        System.out.println(Thread.currentThread().getName() + " sets a RealPrinter.");
        printer.setPrinter(new RealPrinter());
    }
}