package com.syl.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {8,7,6,5,4,3,2,1};
        insertSort(array);
    }

    private static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int j = i-1;
            int temp = array[i];
            for (; j >=0 && array[j] > temp ; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
