package com.syl.test.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {



    /**
     * 默认序列中的第0个元素是有序的（因为只有一个元素a[0]嘛，自然是有序的）；
     从下标为1（下标从0开始）的元素开始，取当前下标i位置处的元素a[i]保存到一个临时变量waitInsert里；
     对前半部分有序序列的循环遍历，并与waitInsert比较，直到遇到一个比waitInsert小的元素（这里默认是从小到大排序），此时的下标为j，那么现在只要对a[j+1]进行赋值waitInsert即可；
     将待插入元素的下标 i 向后推移一个位置；
     重复进行第2步到第4步，直到乱序序列中的元素被全部插入到有序序列中；
     经过以上5个步骤之后，整体序列必然有序，排序完成。
     * @param a
     */
    public static void insertionSort(int[] a){
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j;
            for (j = i; j >0&&temp<a[j-1] ; j--) {
                a[j] = a[j-1];
            }
            a[j] = temp;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] a = {5,4,3,55,11,66};
        insertionSort(a);
    }
}
