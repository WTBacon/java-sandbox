package com.future;

public class RealPrinter implements Printer {

    @Override
    public void print(String s) {
        System.out.println("\tRealPrinter prints \"" + s + "\"");
    }
}
