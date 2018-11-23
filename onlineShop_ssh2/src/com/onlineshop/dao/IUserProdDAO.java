package com.onlineshop.dao;

import java.util.List;

public interface IUserProdDAO {
	/**
	 * 商品关键字查询
	 * @param key
	 * @return
	 */
	public List searchProdByKey(String key);
	
	/**
	 * 缺省关键字查询
	 * @param key
	 * @return
	 */
	public List searchProdByDefaultKey(String key);
}
