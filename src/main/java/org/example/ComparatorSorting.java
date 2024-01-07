package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student implements Comparator<Student> {
    private int id;
    private String name;
    private int age;

    public Student() {}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public int compare(Student one, Student two) {
        //return one.name.compareTo(two.name);
        if(one.age > two.age) {
            return 1;
        } else if (one.age < two.age) {
            return -1;
        } else return 0;
    }
}
public class ComparatorSorting {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student one = new Student(1, "Bhar32", 23);
        Student two = new Student(2, "Arya", 25);
        Student three = new Student(3, "Aak", 24);


        list.add(one);
        list.add(two);
        list.add(three);

        List<Student> sorted = list.stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .collect(Collectors.toList());

        sorted.forEach(System.out :: println);
        //Collections.sort(list, new Student());
        System.out.println("***************");
        //list.forEach(System.out ::println);

    }
}
