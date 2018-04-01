package com.syl.test.collection.array;

import org.junit.Test;

public class MyArrayTest {
    @Test
    public void print() throws Exception {
        MyArray myArray = new MyArray(5);
        for (int i = 0;i<5;i++){
            myArray.insert(i);
        }
        myArray.print();
        myArray.delete(2);
        myArray.print();
    }

}