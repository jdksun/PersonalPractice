package com.syl.thread.test;

import java.util.Vector;

public class Test2 implements Runnable {
    public void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                if (i == 0)
                    System.out.println(this);
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
    }
    public static void main(String[] args) {
        Test2 t1 = new Test2();
        Thread ta = new Thread(t1, "A");
        Thread tb = new Thread(t1, "B");
        ta.start();
        tb.start();
    }
}
