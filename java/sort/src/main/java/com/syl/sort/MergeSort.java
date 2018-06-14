package com.syl.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {8,7,6,5,4,3,2,1};
        mergeSort(array);
    }

    private static void mergeSort(int[] array){
        int[] temp = new int[array.length];
        mergeSort(array,temp,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array,int[] temp,int left,int right){
        if (left < right){
            int mid = (left + right)/2;
            mergeSort(array,temp,left,mid);
            mergeSort(array,temp,mid+1,right);
            merge(array,temp,left,mid,right);
        }
    }
    private static void merge(int[] array,int[] temp,int left,int mid,int rightEnd){
        int right = mid+1;
        int index = left;
        int number = rightEnd - left + 1;
        while (left<=mid && right <=rightEnd){
            if (array[left]<array[right]){
                temp[index++] = array[left++];
            }else
                temp[index++] = array[right++];
        }
        while (left<=mid){
            temp[index++] = array[left++];
        }
        while (right<=rightEnd){
            temp[index++] = array[right++];
        }
        for (int i = 0; i < number; i++,rightEnd--) {
            array[rightEnd] = temp[rightEnd];
        }
    }


}
