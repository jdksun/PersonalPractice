package com.syl.xq;

import org.mockito.verification.After;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class A {
	private static final Date START = new Date(1700,1,1) ;
	private static final Date END = new Date(2100,12,31);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		a.start();
	}
	
	
	public void start(){
		Date date = read();
		print(date);
	}
	public Date read(){
		Scanner scanner = new Scanner(System.in);
		int[] a = new int[3];
		for(int i = 0; i < 3; i++){
			a[i] = scanner.nextInt();
		}
		Date date = new Date(a[0], a[1], a[2]);
		return date;
	}
	public void print(Date date){
		if(judge(date))
			System.out.println("日期无效");
		else{
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DAY_OF_MONTH, 1);
			Date d = c.getTime();
			System.out.println(d.getYear() + " "+ d.getMonth()+" " + d.getDay());
		}
	}
	public boolean judge(Date date){
		return date.before(START) || date.after(END);
	}
}	
