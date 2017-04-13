package com.team.decorator;

public class RuntimeOom {

	public static void main(String[] args) {
		String st1 = new StringBuilder(" ").append("java").toString();
		System.out.println(st1.intern()==st1);
		
		String st2 = new StringBuilder("j").append("ava").toString();
		System.out.println(st2.intern()==st2);
	}
}
