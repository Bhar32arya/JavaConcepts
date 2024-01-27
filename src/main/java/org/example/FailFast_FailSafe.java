package org.example;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFast_FailSafe {
    public static void main(String[] args) {
        //fail-fast
        List<String> list = new ArrayList<>();
        Iterator<String> iterator = list.iterator();
        list.add("Item1");
        try {
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Concurrent modification detected!");
        }
        //fail-safe
        //Allow iteration to complete without throwing an exception
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        Iterator<String> iteratorTwo = arrayList.iterator();
        arrayList.add("Item1");
        while (iteratorTwo.hasNext()) {
            System.out.println(iteratorTwo.next());
        }
    }
}
