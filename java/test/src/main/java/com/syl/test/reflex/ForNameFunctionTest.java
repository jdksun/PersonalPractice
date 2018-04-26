package com.syl.test.reflex;

public class ForNameFunctionTest
{

    public static void main(String[] args) throws Exception
    {
        System.out.println("Hello World!");
        System.out.println("new Zoo before!");
        Class c = Class.forName("com.syl.test.reflex.Dog");
        System.out.println("initial before!");
        Animal dog = (Animal) c.newInstance();
        System.out.println("new Zoo after!");
    }
}
abstract class Animal
{
    static{
        System.out.println("Animal static code block!");
    }
    {
        System.out.println("--------------");
    }
    //抽象类构造方法
    Animal(){
        System.out.println("Animal Contruct!");
    }
}
class Dog extends Animal
{
    {
        System.out.println("-*******--");
    }
    static{
        System.out.println("Dog static code block!");
    }
    public Dog(){
        System.out.println("Dog Construct!");
    }
}