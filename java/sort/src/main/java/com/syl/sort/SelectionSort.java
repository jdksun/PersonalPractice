package com.syl.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {1,3,2,8,5};
        selectionSort(array);
    }

    private static void selectionSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[index] > array[j]){
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }

        System.out.println(Arrays.toString(array));
    }
}
