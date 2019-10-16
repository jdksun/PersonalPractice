package com.syl.test.thread.pac;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductAndCustomer3 {
    public static void main(String[] args) throws InterruptedException {

        MyService myService = new MyService();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                myService.product();
            }).start();
            new Thread(()->{
                myService.consumer();
            }).start();
        }
    }
}

class MyService{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private String tmp = "";

    public void product(){
        try {
            lock.lock();
            while (!tmp.equals("")){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "product");
            tmp = "@";
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void consumer(){
        try {
            lock.lock();
            while (tmp.equals("")){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "consumer");
            tmp = "";
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
