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
                for(j=i;j>=gap && array[j-gap]>temp;j-=gap){
                   array[j] = array[j-gap];
                }
                array[j] = temp;
            }

            gap = (int) Math.floor(gap/2);
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] a = {5,44,3,55,11,66};
        shellSort(a);
        sort(a);
    }
    public static void sort(int[] a){
        for (int i = a.length/2; i >0 ; i/=2) {
            for (int j = i; j < a.length; j++) {
                for (int k = j; k >= i; k-=i) {
                    if (a[k] < a[k-i]){
                        int temp = a[k];
                        a[k] = a[k-i];
                        a[k-i] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
