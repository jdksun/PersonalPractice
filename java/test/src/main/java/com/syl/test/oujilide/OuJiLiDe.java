package com.syl.test.oujilide;

public class OuJiLiDe {



    public int gcd(int m,int n){
        while(n != 0){
            int temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }

}
