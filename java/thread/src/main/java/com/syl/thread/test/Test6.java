package com.syl.thread.test;

/**
 * T1线程 T2线程 T3线程一次执行
 */
public class Test6 {
    public static void main(String[] args) throws InterruptedException {
//        test1();
        test2();
    }

    private static void test2() throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行");
            }
        };
        Thread t1 = new Thread(r,"t1");
        Thread t2 = new Thread(r,"t2");
        Thread t3 = new Thread(r,"t3");
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }

    private static void test1() {
        final Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("t1执行");
            }
        };
        final Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2执行");
            }
        };
        Thread t3 = new Thread(){
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3执行");
            }
        };
        t1.start();
        t2.start();
        t3.start();
    }
}


