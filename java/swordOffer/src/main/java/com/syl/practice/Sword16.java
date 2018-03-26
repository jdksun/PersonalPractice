package com.syl.practice;

/**
 * 题目：数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 */
public class Sword16 {


	/**
	 * 我的方法，感觉有点脑残
	 * +.+
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double Power(double base, int exponent) {
		return Math.pow(base,exponent);
	}

	/**
	 * 快速幂，可利用abs进行求绝对值
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double Power2(double base, int exponent) {
		double res =1;
		double curr = base;
		int n = exponent;
		if (exponent > 0) n = exponent;
		else if (exponent < 0){
			if (base == 0) throw new RuntimeException("0 is error");
			n = - exponent;
		}else return 1;
		while (n != 0){
			if ((n & 1) == 1)
				res *= curr;
			curr *= curr;
			n >>= 1;
		}
		return exponent > 0 ? res : 1/res;
	}

}
