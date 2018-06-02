package com.syl.thread.test;

public class Test8 {

    public static void main(String[] args) {
        Common c= new Common();
        new M(c,0).start();
        new M(c,1).start();
    }
    static class Common{
        public synchronized void method1(){
            System.out.println(" method1 start");
            try {
                Thread.sleep(2000*5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" method1 end");
        }

        public /**synchronized**/ void method2(){
            System.out.println(" method2 start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" method2 end");
        }
    }
    static class M extends Thread{
        private Common c;
        private int i;

        public M(Common c, int i) {
            this.c = c;
            this.i = i;
        }

        @Override
        public void run() {
            if (i == 0){
                c.method1();
            }else {
                c.method2();
            }
        }
    }
}
