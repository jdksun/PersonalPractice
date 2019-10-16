package com.syl.test.thread.car;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 停车场问题
 * 思路就是生产者消费者问题，固定的车位，不停的消费与释放(生产)
 * 有停满时，通知等待与恢复进出功能
 * 缺点：
 * 1.没有增加排队机制，FIFO队列
 * 2.没有增加多个进出口，只有单个口进出
 */
public class ParkThread {

    public static void main(String[] args) {
        Park park = new Park(100);
        ParkCar parkOpe = new ParkCar(park);
        for (int i = 0; i < 97; i++) {
            int finalI = i;
            new Thread(()->{
                parkOpe.park(new Car(finalI +""));
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            parkOpe.park(new Car( "A"));
        }).start();
        new Thread(()->{
            parkOpe.park(new Car( "B"));
        }).start();
        new Thread(()->{
            parkOpe.park(new Car( "C"));
        }).start();
        new Thread(()->{
            parkOpe.park(new Car( "D"));
        }).start();
        new Thread(()->{
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            parkOpe.getCar(new Car( "0"));
        }).start();
    }
}
class ParkCar{
    private Park park;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public ParkCar(Park park) {
        this.park = park;
    }

    /**
     * 停车
     * @param car
     */
    public void park(Car car){
        lock.lock();
        try {
            Thread.sleep(100);
            while (!park.isAvailable()){
                System.out.println("停车场已满" + car.getName() + "车辆等待中...");
                condition.await();
            }
            System.out.println(car.getName() + "存车");
            park.setPort(car);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    /**
     * 取车
     * @param car
     */
    public void getCar(Car car){
        lock.lock();
        try {
            Thread.sleep(100);
            int index = park.isIn(car);
            if (index >= 0){
                if (!park.isAvailable()){
                    condition.signalAll();
                }
                park.getCar(index);
                System.out.println(car.getName() + "取车");
            }else {
                System.out.println(car.getName() + "无相关车辆");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

class Park{

    /**
     * 初始化停车场容量
     */
    private int count;

    /**
     * 容量
     */
    private Car[] cars;

    public Park(int count) {
        this.count = count;
        cars = new Car[count];
    }

    /**
     * 是否有剩余
     * @return
     */
    public boolean isAvailable(){
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null){
                return true;
            }
        }
        return false;
    }

    /**
     * 停车操作
     * @param car
     */
    public void setPort(Car car){
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null){
                cars[i] = car;
                break;
            }
        }
    }

    /**
     * 取车操作
     * @param index
     */
    public void getCar(int index){
        cars[index] = null;
    }

    /**
     * 当前是否有car在停车场
     * @param car
     * @return
     */
    public int isIn(Car car){
        for (int i = 0; i < cars.length; i++) {
            if (car.equals(cars[i])){
                return i;
            }
        }
        return -1;
    }


    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return Arrays.toString(cars);
    }
}
class Car{
    public Car(String name) {
        this.name = name;
    }

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Car car = (Car) obj;
        return Objects.equals(car.getName(),this.getName());
    }
}
