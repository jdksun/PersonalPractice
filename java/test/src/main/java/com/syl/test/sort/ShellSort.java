package com.syl.test.sort;

import java.util.Arrays;

//https://www.cnblogs.com/onepixel/articles/7674659.html
public class ShellSort {
    public static void shellSort(int[] array) {
        int len = array.length;
        int gap = (int) Math.floor(len/2);
        while (gap != 0){
            for (int i = gap; i < len; i++) {
                int temp = array[i];
                int j;
                for(j=i;j>0 && array[j-gap]>temp;j-=gap){
                   array[j] = array[j-gap];
                }
                array[j] = temp;
            }

            gap = (int) Math.floor(gap/2);
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] a = {5,4,3,55,11,66};
        shellSort(a);
    }
}
