package com.syl.test.thread.pac;

/**
 * 单一的消费者和生产者
 */
public class ProductAndCustomer {

    public static void main(String[] args) {
        Object lock = new Object();
        final Product product = new Product(lock);
        final Consumer consumer = new Consumer(lock);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        product.product();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        consumer.consumer();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
class Tmp{
    public static String a = "";
}

class Product{
    private Object lock;

    public Product(Object lock) {
        this.lock = lock;
    }

    public void product() throws InterruptedException {
        synchronized (lock){
            while (!Tmp.a.equals("")){
                System.out.println(Thread.currentThread().getName() + " 进程阻塞===========");
                lock.wait();
            }
            Tmp.a = String.valueOf(Math.random());
            System.out.println(Thread.currentThread().getName() +" begin to product:" +Tmp.a);
            System.out.println(Thread.currentThread().getName() +" end product");
            lock.notify();
        }
    }
}
class Consumer{
    private Object lock;

    public Consumer(Object lock) {
        this.lock = lock;
    }

    public void consumer() throws InterruptedException {
        synchronized (lock){
            while (Tmp.a.equals("")){
                System.out.println(Thread.currentThread().getName() + " 进程阻塞===========");
                lock.wait();
            }
            System.out.println(Thread.currentThread().getName() +" begin to consumer:" + Tmp.a);
            Tmp.a = "";
            System.out.println(Thread.currentThread().getName() + " end consumer");
            lock.notify();
        }
    }
}