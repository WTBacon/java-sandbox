package com.singleton;

public class SynchronizedSingleton {

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton(){}

    public static SynchronizedSingleton getInstance(){
        if (instance == null){
            synchronized (SynchronizedSingleton.class){
                if(instance == null){
                    instance = new SynchronizedSingleton();
                }
            }
        }
        return instance;
    }
}
