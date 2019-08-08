package com.singleton;

public class DelaySingleton {

    private static DelaySingleton instance;

    private DelaySingleton() {}

    public static DelaySingleton getInstance() {

        if (instance == null) {
            instance = new DelaySingleton();
        }
        return instance;
    }
}
