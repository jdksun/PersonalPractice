package com.syl.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("119.29.103.39",6379);
        jedis.auth("12345678");
        System.out.println(jedis.ping());

        jedis.set("k1","v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");
        //String
        jedis.set("k4","ke_redis");
        print();
        jedis.mset("str1","v1","str2","v2","str3","v3");
        System.out.println(jedis.mget("str1","str2","str3"));
        print();
        //list
        jedis.lpush("mylist","v1","v2","v3","v4","v5");
        List<String> list = jedis.lrange("mylist",0,-1);
        for (String item:list
             ) {
            System.out.println(item);
        }
        print();

    }

    public static void print(){
        System.out.println("----------------------");
    }
}
