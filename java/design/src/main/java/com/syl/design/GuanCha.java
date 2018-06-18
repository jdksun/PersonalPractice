package com.syl.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class GuanCha {
    public static void main(String[] args) {
        WeatherData subject = new WeatherData();
        Z z = new Z(subject);

        subject.set(112211);

    }
}

class WeatherData implements Subject{
    private List<Observable> list = new ArrayList<Observable>();

    private int data;
    public void notifyAllObservable() {
        for (Observable item:list) {
            item.update(data);
        }
    }

    public void set(int data) {
       this.data = data;
       notifyAllObservable();
    }

    public void remove(Observable o) {
        int index = list.indexOf(o);
        if (index > 0)
            list.remove(o);
    }

    public void register(Observable o) {
        list.add(o);
    }
}
class Z implements Observable,Display{

    private int data;
    private Subject subject;
    public Z(Subject subject){
        this.subject =subject;
        subject.register(this);
    }

    public void update(int data) {
        this.data = data;
        play();
    }

    public void play() {
        System.out.println("观察者"+this+" 收到数据->"+data);
    }
}
interface Subject{
    void notifyAllObservable();
    void remove(Observable o);
    void register(Observable o);
}
interface Observable{
    void update(int data);
}
interface Display{
    void play();
}