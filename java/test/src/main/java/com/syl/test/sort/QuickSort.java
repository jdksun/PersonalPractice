package com.syl.test.sort;

import java.sql.Driver;
import java.util.Arrays;
import java.util.RandomAccess;


public class QuickSort  {

    public static void main(String[] args) {
        int a[] = { 11, 33, 44, 2, 0, 1, 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17,
                18, 23, 34, 15, 35, 25, 53, 51, 90 };
        quickSort(a);
        System.out.println(Arrays.toString(a));

    }
    public static void quickSort(int[] array){
        quickSort(array,0,array.length-1);
    }
    private static void quickSort(int[] array,int low,int high){
        int start =low;
        int end = high;
        int base = array[low];
        int index = low;
        while (low<high){
            while (low<high&&base<=array[high])
                high--;
            array[low] = array[high];
            index=high;

            while (low<high&&base>=array[low]){
                low++;
            }
            array[high] = array[low];
            index = low;
            array[index] = base;
        }
        if (low-start>1){
            quickSort(array,0,low-1);
        }
        if (end-high>1){
            quickSort(array,high+1,end);
        }
    }



}
