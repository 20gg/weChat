package com.team.decorator;

/**
 * 加芝士 +4元
 * @author hsnn
 *
 */
public class CondimentCheese extends Condiment {

	private Humburger humburger;
	
	public CondimentCheese(Humburger humburger) {
		super();
		this.humburger = humburger;
	}

	@Override
	public String getName() {
		return humburger.getName()+" 加芝士";
	}

	@Override
	public double getPrice() {
		return humburger.getPrice()+4;
	}

}
