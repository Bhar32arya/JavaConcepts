package org.example;

enum SingletonEnum {
    INSTANCE;
    // Additional methods and properties can be added here
    public void doSomething() {
        System.out.println("Singleton instance is doing something.");
    }
}

public class SingletonMainClass {
    public static void main(String[] args) {
        SingletonEnum anEnum = SingletonEnum.INSTANCE;
        SingletonEnum anEnum1 = SingletonEnum.INSTANCE;

        System.out.println(anEnum == anEnum1);
    }
}


