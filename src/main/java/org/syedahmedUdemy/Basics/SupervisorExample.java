package org.syedahmedUdemy.Basics;

public class SupervisorExample {

    public static void main(String[] args) throws InterruptedException {
        Worker1 worker1 = new Worker1();
        Worker2 worker2 = new Worker2();

        worker1.executeWork();
        worker2.executeWork();

    }
}

class Worker1 {
    public void executeWork() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println("Worker _1_ " + i);
        }
    }
}

class Worker2 {
    public void executeWork() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println("_2_Worker" + i);
        }
    }
}