package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.UnaryOperator;

public class ExecuteServiceTest {
    public static void main(String[] args) {

        UnaryOperator<Integer> mul = (num) -> num * num;
        int arr[] = new int[]{1,3,5,6,85,756,8,687,34};

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);

        for (int i : arr) {
            executorService.submit(() -> {
                System.out.print(mul.apply(i) + " ");
            });
        }
        executorService.shutdown();
    }
}
