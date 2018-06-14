package com.syl.thread.test;

public class Test10 {
    public static void main(String[] args) {

        System.out.println(aa());
    }
    public static String aa(){
        try {
            String aa = "222";
            if (aa != null &&aa.length() !=0){
                return aa;
            }
            else {
                throw new RuntimeException("null string");
            }
        }catch (RuntimeException e){
            return "exception";
        }finally {
            System.out.println(" return \"finally\";");
        }
    }
}
