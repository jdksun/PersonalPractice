package com.syl.thread.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 你需要实现一个高效的缓存，它允许多个用户读，
 * 但只允许一个用户写，以此来保持它的完整性，你会怎样去实现它？
 */
public class Test7 {
    public static void main(String[] args) {
        final ReadAndWrite<String,Integer> a = new ReadAndWrite<String, Integer>(new HashMap<String, Integer>());
        ExecutorService e = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            e.execute(new TestRunnable(a));
        }
        e.shutdown();
        new TestRunnable(a).run();
    }
}
class TestRunnable implements Runnable{
    private final ReadAndWrite a;
    private final String key = "x";

    public TestRunnable(ReadAndWrite a) {
        this.a = a;
    }

    @Override
    public void run() {
        Random r = new Random();
        int num = r.nextInt(1000);
        if (num < 500){
            a.put(key,num);
            System.out.println("put--- key->"+key+",value->"+num);
        }else {

            System.out.println("get--- key->"+key+",value->"+a.get(key));
        }
    }
}
class ReadAndWrite<K,V>{

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock read = readWriteLock.readLock();
    private final Lock write = readWriteLock.writeLock();
    private final Map<K,V> map;

    public ReadAndWrite(Map<K,V> map){this.map = map;}

    public V put(K k,V v){
        write.lock();
        try {
           return map.put(k,v);
        }finally {
            write.unlock();
        }
    }
    public V get(K k){
        read.lock();
        try {
            return map.get(k);
        }finally {
            read.unlock();
        }
    }
    /*************   这是用tryLock()方法写的   ********************/
//    public V put(K key, V value){
//        while (true){
//            if(writeLock.tryLock()){
//                try {
//                    System.out.println("put "+ key +" = " + value);
//                    return map.put(key, value);
//                }finally {
//                    writeLock.unlock();
//                }
//            }
//        }
//    }
//    public V get(K key){
//        while (true){
//            if (readLock.tryLock()) {
//                try {
//                    V v = map.get(key);
//                    System.out.println("get "+ key +" = " + v);
//                    return v;
//                } finally {
//                    readLock.unlock();
//                }
//            }
//        }
}