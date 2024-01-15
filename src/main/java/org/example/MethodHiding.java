package org.example;
class Animal {
    public static void display() {
        System.out.println("Static method in animal");
    }
}
/*Static methods do not participate in polymorphism, as their invocation is determined at compile-time.
The method to be called is resolved based on the reference type.*/
class Dog extends Animal {
    public static void display() {
        System.out.println("Static method in dog");
    }
}
public class MethodHiding {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.display(); //Static method in animal

        Dog dog = new Dog();
        dog.display();//Static method in dog
    }
}
