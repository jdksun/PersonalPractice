package com.syl.thread;

import sun.rmi.runtime.Log;

import java.io.PrintWriter;
import java.util.concurrent.*;

public class LogService {
    public static void main(String[] args) throws InterruptedException {

        LogService log = new LogService(new PrintWriter(System.out));
        log.start();
        System.out.println("2222");
        log.log("2323232");
        log.stop();
    }
    private final BlockingQueue<String> queue;
    private final LoggerThread thread;
    private final PrintWriter writer;
    private boolean isShutDown;
    private int count;

    public LogService(PrintWriter writer) {
        this.writer = writer;
        this.queue = new LinkedBlockingQueue<String>();
        thread = new LoggerThread();
    }
    public void start(){
        thread.start();
    }
    public void stop(){
        synchronized (this){
            isShutDown = true;
        }
        thread.interrupt();
    }
    public void log(String msg) throws InterruptedException {
        synchronized (this){
            if (isShutDown){
                throw new IllegalStateException();
            }
            count++;
        }
        queue.put(msg);
    }
    class LoggerThread extends Thread{
        @Override
        public void run() {
           try {
               while (true){
                    try {
                        synchronized (LogService.class){
                            if (isShutDown && count == 0){
                                break;
                            }
                            String msg = queue.take();
                            synchronized (LogService.class){
                                --count;
                            }
                            writer.println(msg);
                        }
                    }catch (InterruptedException e){

                    }
               }
           }finally {
               writer.close();
           }
        }
    }
}
