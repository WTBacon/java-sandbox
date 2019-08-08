package com.singleton;

public class SingletonService {

    private NormalSingleton normalSingleton = NormalSingleton.getInstance();
    private DelaySingleton delaySingleton = DelaySingleton.getInstance();
    private SynchronizedSingleton synchronizedSingleton = SynchronizedSingleton.getInstance();
    private SynchronizedSingleton ww = SynchronizedSingleton.getInstance();

}
