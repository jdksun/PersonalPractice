package com.syl.thread.test;

public class Test3 {
    private static boolean ready;
    private static int a;
    public static void main(String[] args) {

            new A().start();
            a = 2222;
            ready = true;
    }
    private static class A extends Thread{
        @Override
        public void run() {
            while (!ready){
                Thread.yield();
            }
            System.out.println(a);
        }
    }
}
