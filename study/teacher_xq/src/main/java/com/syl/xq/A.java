package com.syl.xq;

import org.mockito.verification.After;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class A {
	private static final Calendar START = Calendar.getInstance(); ;
	private static final Calendar END = Calendar.getInstance();
	private static Format f = new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		a.start();
	}
	
	
	public void start(){
		Calendar date = read();
		print(date);
	}
	public Calendar read(){
		Scanner scanner = new Scanner(System.in);
		int[] a = new int[3];
		for(int i = 0; i < 3; i++){
			a[i] = scanner.nextInt();
		}
		Calendar c = Calendar.getInstance();
		c.set(a[0],a[1]-1,a[2]);
		return c;
	}
	public void print(Calendar c){
		if(judge(c.getTime()))
			System.out.println("日期无效");
		else{
			c.add(Calendar.DAY_OF_MONTH, 1);
			System.out.println(f.format(c.getTime()));
		}
	}
	{
		START.set(1700,1,1);
		END.set(2100,12,31);
	}

	public boolean judge(Date date){
		return date.before(START.getTime()) || date.after(END.getTime());
	}
}	
