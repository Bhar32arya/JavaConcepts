package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelThreadExecuterService {

    public static void main(String[] args) {
        int arr[] = new int[]{1,3,5,6,85,756,8,687,34};

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);

        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);

        for (int number : arr) {
            executorService.submit(() -> {
                int square = squareNumber(number);
                System.out.println("Square of " + number + " is " + square);
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static int squareNumber(int number) {
        try {
            Thread.sleep(1000); // Simulate a 1-second delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return number * number;
    }
}
