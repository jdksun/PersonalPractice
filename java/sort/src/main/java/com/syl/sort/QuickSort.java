package com.syl.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {8,7,6,5,4,3,2,1};
        quickSort(array);
    }

    private static void quickSort(int[] array){
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
    private static void quickSort(int[] array,int low,int high){
        int start = low;
        int end = high;
        int base = array[low];
        int index = low;
        while (low < high){
            while (low<high && base<=array[high])
                high--;
            array[low] = array[high];
            index = high;
            while (low<high&&base>array[low])
                low++;
            array[high] = array[low];
            index = low;
            array[index] = base;
        }
        if (low-start >1){
            quickSort(array,0,low-1);
        }
        if (end - high>1)
            quickSort(array,high+1,end);
    }
}
