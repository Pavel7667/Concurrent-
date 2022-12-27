package org.syedahmedUdemy.Basics;

import java.util.stream.IntStream;

public class SumOfNumberUsingRunnableWithLambda {

    public static int[] numbers = IntStream.rangeClosed(0, 5000).toArray();
    public static volatile int sum = 0;
    public static int total = IntStream.rangeClosed(0, 5000).sum();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < numbers.length / 2; i++) {
                add(numbers[i]); // calling multiple
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = numbers.length / 2; i < numbers.length; i++) {
                add(numbers[i]);  // calling multiple
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(sum);
        System.out.println(total);

    }

    /**
     * Add method calling 5000 times in two Threads, so need Synchronization
     *
     * @param toAdd some int to SUM
     */
    public  static void add(int toAdd) {
        sum = sum + toAdd;
    }
}
