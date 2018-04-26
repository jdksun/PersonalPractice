package com.syl.test;

public class Test {
    public static void main(String[] args) {
        C c = new C();

        B b = new B();
        c = (C)b;
        c.print();
    }


}
class B{
    public void print(){
        System.out.println("B");
    }

}
class D extends B{

}
class C extends B{
    @Override
    public void print() {
        System.out.println("C");
    }
    void a(B c){
        System.out.println("111");
    }
    void a(C c){
        System.out.println("222");
    }
}
