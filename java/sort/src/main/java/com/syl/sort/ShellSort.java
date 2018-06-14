package com.syl.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {8,7,6,5,4,3,2,1};
        shellSort(array);
    }

    private static void shellSort(int[] array){
        for(int gap = array.length/2;gap > 0;gap/=2){
            for (int i = gap; i < array.length; i++) {
                int j = i-gap;
                int current = array[i];
                for (; j >= 0 && array[j] > current; j-=gap) {
                    array[j+gap] = array[j];
                }
                array[j+gap] = current;
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
