package org.example;

public class Singleton {

    private static Singleton object;
    private Singleton() {
    }

    public Singleton getInstance() {
        synchronized (Singleton.class) {
            if(object == null) {
                new Singleton();
            }
            return object;
        }
    }
}
