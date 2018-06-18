package com.syl.design;

import java.util.Observable;
import java.util.Observer;

public class InnerGuanCha {
    public static void main(String[] args) {
        new InnerGuanCha().show();
    }
    public void show(){
        WeatherData w = new WeatherData();
        C c = new C(w);

        w.setData(11111);
    }
    class WeatherData extends Observable{
        private int data;
        public void change(){
            setChanged();//注意
            notifyObservers();
        }
        public void setData(int data){
            this.data = data;
            change();
        }

        public int getData() {
            return data;
        }
    }
    class C implements Observer,Display{
        private int data;
        private Observable observable;

        public C(Observable observable) {
            this.observable = observable;
            observable.addObserver(this);
        }

        public void play() {
            System.out.println("观察者"+this+" 收到数据->"+data);
        }

        public void update(Observable o, Object arg) {

            if (o instanceof WeatherData){
                WeatherData w = (WeatherData) o;
                this.data = w.getData();
                play();
            }
        }
    }
}
