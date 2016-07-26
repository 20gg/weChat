package com.team.Decorator;
/**
 * 加什么调料？ 当然是辣椒喽
 * @author hsnn
 *
 */
public class DressingChilli extends Dressing {

	private Humburger humburge; 
	public DressingChilli(Humburger humburge) {
		super();
		this.humburge = humburge;
	}

	@Override
	public String getName() {
		return humburge.getName()+" 加辣椒 ";
	}

	@Override
	public double getPrice() {
		return humburge.getPrice();//加辣不要钱
	}

}
