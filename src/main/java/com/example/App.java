package com.example;

import com.component.FuturePrinter;
import com.component.RealPrinter;

public class App extends Thread {

    private static FuturePrinter printer;

    public static void main(String[] args) {
        printer = new FuturePrinter();
        // start(main) と run(Thread-0) の2つの thread が走る.
        new App().start();
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
        } catch (InterruptedException e){
        }

        System.out.println(Thread.currentThread().getName() + " sets a RealPrinter.");
        printer.setPrinter(new RealPrinter());
    }
}
