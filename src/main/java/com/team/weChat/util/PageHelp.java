package com.team.weChat.util;

import java.util.List;

public class PageHelp {
	/**
	 * 分页方法
	 * 
	 * @param list 源数据
	 * @param currentPage 当前页
	 * @param maxNum 每页显示几条
	 * @param pageNum 总页数
	 * @return
	 */
	public static List<?> getPageList(List<?> list, int currentPage, int maxNum,int pageNum) {
		int fromIndex = 0; // 从哪里开始截取
		int toIndex = 0; // 截取几个
		if (list == null || list.size() == 0)
			return null;
		// 当前页小于或等于总页数时执行
		if (currentPage <= pageNum && currentPage != 0) {
			fromIndex = (currentPage - 1) * maxNum;
			if (currentPage == pageNum) {
				toIndex = list.size();
			} else {
				toIndex = currentPage * maxNum;
			}
		}
		return list.subList(fromIndex, toIndex);
	}
}
