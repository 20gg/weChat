package com.team.weChat.enums;

public enum TestCode implements ICommonEnum<Integer> {
	BBB(1, "罢罢罢"),
	AAA(2, "啊啊啊");

	private int key;
	private String value;
	
	private TestCode(int key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public Integer getKey() {
		return this.key;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public static String getValueByKey(Integer key) {
		for (ICommonEnum<Integer> item : values()) {
			if (item.getKey() == key) {
				return item.getValue();
			}
		}
		return null;
	}

	public static Integer getKeyByValue(String value) {
		for (ICommonEnum<Integer> item : values()) {
			if (item.getValue().equals(value)) {
				return (Integer) item.getKey();
			}
		}
		return null;
	}

	public static Integer getKeyByItemName(String itemName) {
		Integer res = null;
		try {
			res = valueOf(itemName).getKey();
		} catch (IllegalArgumentException | NullPointerException e) {
		}
		return res;
	}

}
