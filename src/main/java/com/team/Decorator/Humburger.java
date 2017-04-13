package com.team.decorator;

/**
 * 汉堡基类（被装饰者)
 * 
 * @author hsnn
 *
 */
public abstract class Humburger {
	protected String name;
	
	protected double count;

	public abstract double getPrice();

	public String getName() {
		return name;
	}
}
