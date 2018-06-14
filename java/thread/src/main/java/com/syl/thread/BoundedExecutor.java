package com.syl.thread;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

public class BoundedExecutor {

    public static void main(String[] args) {
        BoundedExecutor b = new BoundedExecutor(Executors.newFixedThreadPool(10),10);
        for (int i = 0; i < 100; i++) {
            final int finalI = i;
            try {
                b.submitTask(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(finalI +"");
                        try {
                            Thread.sleep(new Random().nextInt(1000*10));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private final Executor exec;

    private final Semaphore semaphore;

    public BoundedExecutor(Executor exec, int num) {
        this.exec = exec;
        this.semaphore = new Semaphore(num);
    }
    public void stop(){
    }
    public void submitTask(final Runnable r) throws InterruptedException {
        semaphore.acquire();
        try {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        r.run();
                    }finally {
                        semaphore.release();
                    }
                }
            });
        }catch (RejectedExecutionException e){
            semaphore.release();
        }
    }
}
