package com.syl.thread.test;

/**
 * 可重入
 */
public class Test1 {
    public static void main(String[] args) {
        new B().doSometing();
    }

}
class A {
   public synchronized void doSometing(){
       System.out.println(this.getClass().getName() + " ---A");
   }
}

class B extends A{
    @Override
    public synchronized void doSometing() {
        System.out.println(this.getClass().getName() + " ---B");
        super.doSometing();
    }
}