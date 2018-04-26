package com.syl.redis;

import redis.clients.jedis.Jedis;

public class TextMS {
    public static void main(String[] args) {
        Jedis master = new Jedis("119.29.103.39",6379);
        master.auth("12345678");
        Jedis slaver = new Jedis("119.29.103.39",6380);
        slaver.auth("12345678");

        slaver.slaveof("119.29.103.39",6379);
        master.set("class","1122");

        System.out.println(slaver.get("class"));;

    }
}
