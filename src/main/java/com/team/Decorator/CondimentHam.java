package com.team.decorator;

/**
 * 加火腿 +2元 
 * @author hsnn
 *
 */
public class CondimentHam extends Condiment {

	private Humburger humburger;

	public CondimentHam(Humburger humburger) {
		super();
		this.humburger = humburger;
	}

	@Override
	public String getName() {
		return humburger.getName()+" 加火腿 ";
	}

	@Override
	public double getPrice() {
		
		return humburger.getPrice()+2*humburger.count;
	}

}
