package com.syl.test.thread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test implements Runnable{

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                lock.lock();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }).start();
        }

    }

    @Override
    public void run() {
        synchronized (Test.class){
            for (int i = 0; i < 1000000; i++)
            {
            }
        }
    }


}