package com.team.decorator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Array;

public class Sale {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		//来一块牛肉汉堡
		Humburger beef = new HumburgerBeef(2);
		System.out.println(beef.getName()+" 售价："+beef.getPrice());
		
		//老板，牛肉汗煲加火腿，谢谢！^_^
		Condiment ham = new CondimentHam(new HumburgerBeef(2));
		System.out.println(ham.getName()+" 售价："+ham.getPrice());
		
				//鸡腿堡一个，打包 
				Humburger chicken = new HumburgerChicken();
				System.out.println(chicken.getName()+" 售价："+chicken.getPrice());
				//再加点芝士吧
				Condiment cheese = new CondimentCheese(chicken);
				System.out.println(cheese.getName()+" 售价："+cheese.getPrice());
		
		Dressing chilli = new DressingChilli(ham);
		System.out.println(chilli.getName()+" 售价："+chilli.getPrice());
		
	}
	@Test
	public void test1() {
		List<Integer> list = new ArrayList<Integer>();
		int i  = 0;
		while(true){
			list.add(i++);
		}
		
	}

}
