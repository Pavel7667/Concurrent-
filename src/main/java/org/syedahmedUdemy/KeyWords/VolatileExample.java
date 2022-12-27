package org.syedahmedUdemy.KeyWords;

public class VolatileExample {


    /**
     * Flag with keyWord volatile can see all Threads in Program
     *
     * <p>And our program finishing compiling because Thread 2 see changes of Variable
     * (FLAG) in Thread 1 </p>
     * <p>And If remove this keyWord Thread 2 don`t see the changes (FLAG) in Thread 1
     * and program never ended</p>
     */
    public static volatile boolean flag = false;

    public static void main(String[] args) {

        // Thread 1
        new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                System.out.println("Value of i : " + i);
            }
            flag = true;
            System.out.println("Flag = " + flag);
        }).start();

        // Thread 2
        new Thread(() -> {
            int i = 1;
            while (!flag) {
                ++i;
            }
            System.out.println("THe value of second " + i);
        }).start();

    }
}
