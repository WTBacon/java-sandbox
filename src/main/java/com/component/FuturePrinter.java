package com.component;

public class FuturePrinter implements Printer {

    private Printer printer;

    // printer が setPrinter によって与えられるまで wait する.
    @Override
    public synchronized void print(String s) {
        while (printer == null) {
            try {
                System.out.println("\tIn FuturePrinter: wait");
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("\tIn FuturePrinter: printing start.");
        printer.print(s);
    }

    public synchronized void setPrinter(Printer printer) {
        this.printer = printer;
        notifyAll();
    }
}
