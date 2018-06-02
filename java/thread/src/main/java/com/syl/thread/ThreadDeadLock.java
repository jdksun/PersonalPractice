package com.syl.thread;

public class ThreadDeadLock {
    public static void main(String[] args) {
        Object obj1 = new Object(){
            @Override
            public String toString() {
                return "o1";
            }
        };
        Object obj2 = new Object(){
            @Override
            public String toString() {
                return "o2";
            }
        };
        Object obj3 = new Object(){
            @Override
            public String toString() {
                return "o3";
            }
        };

        Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
        Thread t2 = new Thread(new SyncThread(obj2, obj3), "t2");
        Thread t3 = new Thread(new SyncThread(obj3, obj1), "t3");


        try {
            t1.start();
            Thread.sleep(5000);
            t2.start();
            Thread.sleep(5000);
            t3.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class SyncThread implements Runnable{

    private Object o1;
    private Object o2;

    public SyncThread(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " acquiring locn on " + o1);
        synchronized (o1){
            System.out.println(name + " acquired locn on " + o1);
            work();
            System.out.println(name + " acquiring locn on " + o2);
            synchronized (o2){
                System.out.println(name + " acquired locn on " + o1);
                work();
            }
            System.out.println(name + " released locn on " + o2);
        }
        System.out.println(name + " released locn on " + o1);
        System.out.println(name+ " finished execution");
    }

    public void work(){
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
