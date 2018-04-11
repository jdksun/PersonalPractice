package com.syl.test.sort;

public class SelectionSort {

    public static int[] selectionSort(int[] array){
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i+1; j < len; j++) {
                if (array[min] > array[j]){
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
