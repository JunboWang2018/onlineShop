package com.onlineshop.service;

import java.util.List;

public interface IUserProdService {
	/**
	 * 商品关键字查询
	 * @param key
	 * @return
	 */
	public List searchProdByKey(String key);
}
