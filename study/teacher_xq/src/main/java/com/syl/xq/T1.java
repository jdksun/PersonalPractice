package com.syl.xq;

import java.util.Scanner;


public class T1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		T1 h = new T1();
		h.start();
		
		
		
	}
	public void start(){
		int[] a = read();
		Triangle t = judge(a);
		print(t);
	}
	public int[] read(){
		Scanner scanner = new Scanner(System.in);
		int[] a = new int[3];
		for(int i = 0; i < 3; i++){
			a[i] = scanner.nextInt();
		}
		return a;
	}
	public void print(Triangle t){
		System.out.println(t.getMsg());
	}

	public Triangle judge(int[] a){
		if(!dayu(a[0],a[1],a[2])||!dayu(a[1],a[2],a[0])||!dayu(a[0],a[2],a[1])){
			return Triangle.非三角形;
		}else if(a[0] == a[1] &&  a[0] == a[2])
			return Triangle.等边三角形;
		else if(a[0]== a[1] || a[0] == a[2] || a[1] == a[2])
			return Triangle.等腰三角形;
		else if(fang(a[0],a[1],a[2])||fang(a[0], a[2], a[1])||fang(a[2],a[1],a[0]))
			return Triangle.直角三角形;
		else
			return Triangle.一般三角形;
	}
	
	public boolean dayu(int a,int b,int c){
		return a + b > c ;
	}
	
	
	public boolean fang(int a,int b,int c){
		return a*a + b*b == c*c;
	}

	enum Triangle{
		非三角形(0,"非三角形"),
		一般三角形(1,"一般三角形"),
		直角三角形(2,"直角三角形"),
		等腰三角形(3,"等腰三角形"),
		等边三角形(4,"等边三角形")
		;
		private int code;
		private String msg;
		private Triangle(int code,String msg) {
			this.code = code;
			this.msg = msg;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}


	}

}
