package org.syedahmedUdemy.Basics;

import java.util.stream.IntStream;

/**
 * Default realization of Thread, with creating different classes
 */
public class SumOfNumberUsingRunnableExample {

    public static int[] numbers = IntStream.rangeClosed(0, 5000).toArray();
    public static int sum = 0;
    public static int total = IntStream.rangeClosed(0, 5000).sum(); // verification


    public static void main(String[] args) throws InterruptedException {
        Worker1Parallel one = new Worker1Parallel(numbers);
        Worker2Parallel two = new Worker2Parallel(numbers);


        Thread t1 = new Thread(one);
        Thread t2 = new Thread(two);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(sum);
        System.out.println(total);
    }

    public static void add(int toAdd) {
        sum = sum + toAdd;
    }
}

class Worker1Parallel implements Runnable {

    private final int[] array;
    int sum = 0;

    public Worker1Parallel(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length / 2; i++) {
            sum = sum + array[i];
        }
        SumOfNumberUsingRunnableExample.add(sum); // calling once
    }

}

class Worker2Parallel implements Runnable {
    private final int[] array;
    int sum = 0;

    public Worker2Parallel(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = array.length / 2; i < array.length; i++) {
            sum = sum + array[i];
        }
        SumOfNumberUsingRunnableExample.add(sum);  // calling once
    }
}

