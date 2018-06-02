package com.syl.thread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {


    public static void main(String[] args) {
        int N = 10;
        Soldier[] soldier = new Soldier[N];
        CyclicBarrier c = new CyclicBarrier(N,new Caption(false,N));
        for (int i = 0; i < N; i++) {
            soldier[i] = new Soldier(i+"",c);
            new Thread(soldier[i]).start();
        }
    }

    public static class Soldier implements Runnable{
        private String name;
        private final CyclicBarrier cyclicBarrier;
        private Random r = new Random();
        public Soldier(String name, CyclicBarrier cyclicBarrier) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                //等待所有士兵集合完成
                Thread.sleep(r.nextInt(1000));
                System.out.println("士兵"+       "报道！！！！");
                cyclicBarrier.await();

                doWork();

                //等待所有任务完成
                cyclicBarrier.await();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        private void doWork() {
            try {
                Thread.sleep(r.nextInt(10000));
                System.out.println("士兵"+       ",任务完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static class Caption implements Runnable{
        private boolean flag;
        private int N;

        public Caption(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if (flag){
                System.out.println("司令:[士兵"+N +"个，任务完成]");
            }else {
                System.out.println("司令:[士兵"+N +"个，集合完毕]");
                flag = true;
            }
        }
    }
}
