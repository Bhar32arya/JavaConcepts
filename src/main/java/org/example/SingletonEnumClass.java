package org.example;

/*Thread Safety: Enums are inherently thread-safe,
and the singleton instance is created only once during class loading.

Serialization: Enum instances are inherently serializable,
and their deserialization is guaranteed to produce the same instance.

Reflection: Enum types cannot be instantiated using reflection,
preventing instantiation bypassing the singleton pattern*/
enum SingletonEnum {
    INSTANCE;
    // Additional methods and properties can be added here
    public void doSomething() {
        System.out.println("Singleton instance is doing something.");
    }
}

public class SingletonEnumClass {
    public static void main(String[] args) {
        SingletonEnum anEnum = SingletonEnum.INSTANCE;
        SingletonEnum anEnum1 = SingletonEnum.INSTANCE;

        System.out.println(anEnum == anEnum1);
    }
}


