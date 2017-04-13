package com.team.decorator;

/**
 * 牛肉汉堡类（被装饰着的初始状态，当然也有自己简单的装饰）
 * @author hsnn
 *
 */
public class HumburgerBeef extends Humburger {

	public HumburgerBeef(double count) {
		name=count+"个牛肉汉堡";
		super.count = count;
	}

	@Override
	public double getPrice() {
		return count*15;
	}

}
