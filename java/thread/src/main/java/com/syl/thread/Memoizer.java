package com.syl.thread;

import java.util.Random;
import java.util.concurrent.*;

public class Memoizer<A,V> implements Computable<A, V> {

    public static void main(String[] args) {
        final Computable<String,Integer> c = new Computable<String, Integer>() {
            @Override
            public Integer compute(String arg) throws InterruptedException {
                Thread.sleep(1000*5);
                return new Random().nextInt(1000);
            }
        };
        final Memoizer<String,Integer> m = new Memoizer<String,Integer>(c);

        for (int i = 0; i < 3; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        System.out.println(m.compute("aa"));;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            if (i == 1){
                m.future.cancel(true);
            }
        }
    }
    private Computable<A,V> c;
    private Future<V> future;
    private final ConcurrentHashMap<A,Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {
        while (true){
            Future<V> f = cache.get(arg);
            if (f == null){
                Callable callable = new Callable() {
                    @Override
                    public Object call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask futureTask = new FutureTask(callable);
                f = cache.putIfAbsent(arg,futureTask);
                if (f == null){
                    f = futureTask;
                    futureTask.run();
                }
            }
            try {
                return f.get();
            }catch (CancellationException e){
                cache.remove(arg,f);
            }
            catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
interface Computable <A, V> {
    V compute(A arg) throws InterruptedException;
}