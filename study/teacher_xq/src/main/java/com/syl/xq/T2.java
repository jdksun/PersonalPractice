package com.syl.xq;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class T2 {
	private static Calendar START = Calendar.getInstance(); ;
	private static  Calendar END = Calendar.getInstance();
	private static Calendar T = Calendar.getInstance();
	private static Format f = new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true){
			T2 a = new T2();
			a.start();
		}
	}
	
	
	public void start(){
		Calendar date = read();
		print(date);
	}
	public Calendar read(){
		Scanner scanner = new Scanner(System.in);
		int[] a = new int[3];
		for(int i = 0; i < 3; i++)
			a[i] = scanner.nextInt();
		T.set(a[0],a[1]-1,a[2]);
		return T;
	}
	public void print(Calendar c){
		if(judge(c))
			System.out.println("日期无效");
		else{
			c.add(Calendar.DAY_OF_MONTH, 1);
			System.out.println(f.format(c.getTime()));
		}
	}
	static {
		START.set(1700,0,1);
		END.set(2100,11,31);
	}

	public boolean judge(Calendar c){
		return c.before(START) || c.after(END);
	}
}	
