package com.syl.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class O1 {
    /**
     * 方案一 暴力破解，但是时间超了
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (isSame(s,i,j)){
                    count = Math.max(count,j - i);
                }
            }
        }
        return count;
    }

    private boolean isSame(String str,int i,int j){
        Set<Character> set = new HashSet();
        for (int k = i; k < j; k++) {
            if (set.contains(str.charAt(k))){
                return false;
            }
            set.add(str.charAt(k));
        }
        return true;
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int count = 0;
        int len = s.length();
        int i = 0,j = 0;
        Set<Character> set = new HashSet<Character>();
        while ( i < len && j < len){
            if (set.contains(s.charAt(j))){
                set.remove(s.charAt(i++));
            }else {
                set.add(s.charAt(j++));
                count = Math.max(count,j-i);
            }
        }
        return count;
    }

    /**
     * 优化滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int count = 0;
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i = 0,j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))){
                i = Math.max(i,map.get(s.charAt(j)));
            }
            count = Math.max(count , j - i + 1);
            map.put(s.charAt(j),j + 1);
        }
        return count;
    }

}
