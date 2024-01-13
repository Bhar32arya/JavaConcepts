package org.example;

public class Singleton {
    /*The volatile keyword ensures that changes made by one thread to the shared instance variable are visible to
     other threads. The private constructor includes a check to prevent
     instantiation via reflection, which can bypass the singleton pattern.*/
    private static volatile Singleton instance;
    private Singleton() throws Exception {
        if(instance != null) {
            throw new Exception("Use getInstance method to get singleton object");
        }
    }

    public Singleton getInstance() throws Exception {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
