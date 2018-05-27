package com.syl.thread;

import java.util.Random;

public class ParkThread {

    public static void main(String[] args) {
         Park park = new  Park(100);
        for (int i = 0; i < 2; i++) {
            new Thread(new  ParkCar(park,new  Car(new Random().nextInt(100000)))).start();
            new Thread(new  ParkCar(park,new  Car(new Random().nextInt(100000)))).start();
            new Thread(new  ParkCar(park,new  Car(new Random().nextInt(100000)))).start();
            new Thread(new  ParkCar(park,new  Car(new Random().nextInt(100000)))).start();
            new Thread(new  ParkCar(park,new  Car(new Random().nextInt(100000)))).start();
        }
        for (int i = 0; i < 10; i++) {
            park.desPark();
        }
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(park.getNum());
    }
}


class ParkCar implements Runnable{

    private  Park park;

    private  Car car;

    public ParkCar( Park park,  Car car) {
        this.park = park;
        this.car = car;
    }

    public ParkCar( Park park) {
        this.park = park;
    }

    public void run() {

            int i = 0;
            synchronized (park){
                if (park.addPark()){
                    System.out.println("停车成功,车牌号"+car.getCard());
                }else {
                    System.out.println("停车失败,暂无车位");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }
}


class Car{
    private int card;

    public Car(int card) {
        this.card = card;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }
}
class Park{
    private final int LIMIT = 100;

    private int num;

    public Park(int num) {
        this.num = num;
    }

    public boolean addPark(){
        if (num >= LIMIT){
            return false;
        }
        num++;
       return true;
    }

    public boolean desPark(){
        if (num<=0)
            return false;
        num--;
        return true;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}