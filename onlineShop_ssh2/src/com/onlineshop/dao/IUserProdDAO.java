package com.onlineshop.dao;

import java.util.List;

public interface IUserProdDAO {
	/**
	 * ��Ʒ�ؼ��ֲ�ѯ
	 * @param key
	 * @return
	 */
	public List searchProdByKey(String key);
	
	/**
	 * ȱʡ�ؼ��ֲ�ѯ
	 * @param key
	 * @return
	 */
	public List searchProdByDefaultKey(String key);
}
