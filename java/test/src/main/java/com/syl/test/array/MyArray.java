package com.syl.test.array;

public class MyArray {
    private int[] data;
    private int index = -1;

    MyArray(int size){
        if (size < 1)
            throw new RuntimeException("size must be larger than 1");
        data = new int[size];
    }

    public void insert(int vlaue){
        if (index == data.length)
            throw new RuntimeException("array is full");
        data[++index] = vlaue;
    }

    /**
     * 删除需要先找到对象平均是N/2，同时需要移动空间也是N/2，整体上时间复杂度O(n)
     * @param value
     */
    public void delete(int value){
        if (index == 0)
            throw new RuntimeException("array is northing");
        int i = 0;
        for (;i <= index;i++){
            if (data[i] == value)
                break;
        }
        for (int j = i;j <= index-1;j++){
            data[j] = data[j+1];
        }
        index--;
    }
    /**
     * 返回索引
     * 线性查找 时间复杂度O(n)
     * @param value
     * @return
     */
    public int find(int value){
        for (int i=0; i<=index; i++) {
            if(data[i] == value){
                return i;
            }
        }
        return -1;
    }
    public void print(){
        System.out.println("-------------------");
        for (int i=0; i<=index; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
