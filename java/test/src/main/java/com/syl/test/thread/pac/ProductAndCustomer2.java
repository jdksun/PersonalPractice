package com.syl.test.thread.pac;

import java.util.Arrays;

/**
 * 多消费者和生产者会导致假死（所有线程都进入了等待状态）
 * 原因：消费者/生产者在唤醒其他线程时，可能唤醒同类线程(也是消费者/生产者)，导致还是让同类线程导再次触发等待条件
 * ，相互之间都进入了等待，没有线程去通知彼此，全部等待
 * 解决方法，将唤醒方法notify() -> notifyAll()，通知所以线程进入就绪状态，每个线程通过while循环判断是否满足进行的条件，满足继续进行，
 * 让所有程序都可以得到尝试的机会
 */
public class ProductAndCustomer2 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Product product = new Product(lock);
        Consumer consumer = new Consumer(lock);
        Thread[] p = new Thread[2];
        Thread[] c = new Thread[2];
        for (int i = 0; i < 2; i++) {
            p[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            product.product();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            p[i].setName("生产者" + (i + 1 ));
            c[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            consumer.consumer();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            c[i].setName("消费者" + (i + 1));
            p[i].start();
            c[i].start();
        }
        Thread.sleep(5000);
        Thread[] currentThreads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(currentThreads);
        Arrays.stream(currentThreads).forEach(x -> System.out.println(x.getName() + " " + x.getState()));
    }
}
