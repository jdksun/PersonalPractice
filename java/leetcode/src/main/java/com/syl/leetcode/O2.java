package com.syl.leetcode;

public class O2 {

    /**
     * 双指针 复制拷贝
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int temp = 0;
        for (int num:nums) {
            if (num != val){
                nums[temp] = num;
                temp ++;
            }
        }
        return temp;
    }

    /**
     * 双指针 交换移除
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {

        int j = nums.length;
        for (int i = 0; i < j;) {
            if (nums[i] == val){
                nums[i] = nums[j - 1];
                j--;
            }else {
                i++;
            }
        }
        return j;
    }

}
