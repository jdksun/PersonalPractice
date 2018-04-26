package com.syl.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {
    public static void main(String[] args) throws InterruptedException {

        TestTX t = new TestTX();
        t.transMethod();
    }

    public boolean transMethod() throws InterruptedException {
        Jedis jedis = new Jedis("119.29.103.39",6379);
        jedis.auth("12345678");
        int balance;
        int debt;
        int amtToSubtract = 10;
        jedis.watch("balance");
        //模拟其他程序修改
        jedis.set("balance","5");
        Thread.sleep(1000*2);
        balance = Integer.parseInt(jedis.get("balance"));
        if (balance < amtToSubtract){
            jedis.unwatch();
            System.out.println("modify");
            return false;
        }else {
            System.out.println("***********transaction");
            Transaction tx = jedis.multi();
            tx.decrBy("balance",amtToSubtract);
            tx.incrBy("debt",amtToSubtract);
            tx.exec();
            balance = Integer.parseInt(jedis.get("balance"));
            debt = Integer.parseInt(jedis.get("debt"));
            System.out.println("********* balance" + balance);
            System.out.println("********* debt" + debt);
            return true;
        }

    }
}
