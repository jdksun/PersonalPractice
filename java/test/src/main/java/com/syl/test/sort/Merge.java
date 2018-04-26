package com.syl.test.sort;

import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {
        int[] a = {5,44,3,55,11,66};
        int[] b = a;
        mergeSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }


    private static int[] mergeSort(int[] a){
        if (a.length < 2) return a;
        int mid = a.length/2;
        int[] left = Arrays.copyOfRange(a,0,mid);
        int[] right = Arrays.copyOfRange(a,mid,a.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    private static int[] merge(int[] a,int[] b) {
        int[] result = new int[a.length+b.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i<a.length&&j<b.length){
            if (a[i]<b[j]){
                result[index++] = a[i++];
            }else{
                result[index++] = b[j++];
            }
        }
        while (i<a.length){
            result[index++] = a[i++];
        }
        while (j<b.length){
            result[index++] = b[j++];
        }
        return result;
    }
}
