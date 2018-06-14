package com.syl.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class KeepAlive {
    public static void main(String[] args) {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);
        exec.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                URL url = null;
                URLConnection con = null;
                BufferedReader rb = null;
                try {
                    url = new URL("https://www.baidu.com");
                    con = url.openConnection();
                    rb = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    System.out.println("---run----");
                }  catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        rb.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 0, 60 * 10, TimeUnit.SECONDS);

    }


}
