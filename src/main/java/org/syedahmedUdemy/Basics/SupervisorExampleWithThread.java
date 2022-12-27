package org.syedahmedUdemy.Basics;

public class SupervisorExampleWithThread {

    public static void main(String[] args) {

        ParallelWorker1 parallelWorker1 = new ParallelWorker1();
        ParallelWorker2 parallelWorker2 = new ParallelWorker2();

        parallelWorker1.start();
        parallelWorker2.start();
    }

}

class ParallelWorker1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Worker _1_ " + i);
        }
    }
}
class ParallelWorker2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" _2_ Worker  " + i);
        }
    }
}