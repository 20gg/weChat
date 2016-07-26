package com.team.Decorator;

public class HumburgerChicken extends Humburger {

 
	//初始化构造器
	public HumburgerChicken() {
		name = "鸡腿汉堡";
	}

	@Override
	public double getPrice() {
		return 10;
	}

}
