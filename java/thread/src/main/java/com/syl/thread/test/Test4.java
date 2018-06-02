package com.syl.thread.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test4 {
    public static void main(String[] args) {
        Park p=new Park();
        Car a=new Car("111111");
        Car b=new Car("222222");
        Car c=new Car("333333");
        Car d=new Car("444444");
        Car e=new Car("555555");
        new Thread (new ParkCar(a,p)).start();
        new Thread (new ParkCar(c,p)).start();
        new Thread (new ParkCar(d,p)).start();
        new Thread (new ParkCar(e,p)).start();
        new Thread (new ParkCar(b,p)).start();

    }

}
class Park
{
    boolean  []park=new boolean[3];
    public boolean equals()
    {
        return true;
    }

}
class Car
{
    private String number;
    private int position=0;
    public Car(String number)
    {
        this.number=number;
    }
    public void setNumber(String number)
    {
        this.number=number;
    }
    public String getNumber()
    {
        return number;
    }
    public void setPosition(int i)
    {
        position=i;
    }
    public int getPosition()
    {
        return position;
    }
    public int hashCode()
    {
        return number.hashCode();
    }
    public boolean equals(Object obj)
    {
        if(obj==this)
            return true;
        if(obj!=null&&obj.getClass()==Car.class)
        {
            Car c=(Car)obj;
            return c.number==this.number;
        }
        return false;
    }
}

class ParkCar implements Runnable
{
    Car c;
    Park p;
    public ParkCar(Car c,Park p)
    {
        this.c=c;
        this.p=p;
    }
    @Override
    public void run()
    {
        while(true)
        {
            int i=0;
            synchronized(p)
            {
                if(c.getPosition()==0)
                {
                    for(i=0;i<p.park.length;i++)
                    {
                        if(p.park[i])
                        {
                            continue;
                        }
                        else
                        {
                            System.out.println("车 "+c.getNumber()+"成功停在"+(i+1)+"号停车位上");
                            p.park[i]=true;
                            c.setPosition(i);
                            break;
                        }
                    }
                    if(i==3)
                        System.out.println("停车场车位已满，车 "+c.getNumber()+"停车失败");
                }


                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException ie)
                {
                    ie.printStackTrace();
                }
            }

            synchronized(p)
            {
                if(c.getPosition()!=0)
                {
                    p.park[c.getPosition()]=false;
                    c.setPosition(0);
                    System.out.println("车 "+c.getNumber()+"已离开停车场");

                }
                try
                {
                    Thread.sleep(1000*5);
                }
                catch(InterruptedException ie)
                {
                    ie.printStackTrace();
                }
            }

        }
    }
}