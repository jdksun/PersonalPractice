package com.syl.thread.practic;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

public class MyQueue<T> {

    public static void main(String[] args) {
        final MyQueue<Integer> q = new MyQueue();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                        q.put(i);

                    System.out.println("PUT " + i);

                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                        System.out.println("GET " + q.get());
                    try {
                        Thread.sleep(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();

    }

    private LinkedList<T> list;
    private int sum = 100;

    public MyQueue() {
        list = new LinkedList<T>();
    }

    public void put(T i) {
       synchronized (list){
           while (list.size() >= 100){
               try {
                   list.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           list.add(i);
           list.notifyAll();
       }
    }

    public T get()  {
        synchronized (list){
            while (list.size() <= 0){
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T n =list.getFirst();
            list.removeFirst();
            list.notifyAll();
            return n;
        }
    }
}
