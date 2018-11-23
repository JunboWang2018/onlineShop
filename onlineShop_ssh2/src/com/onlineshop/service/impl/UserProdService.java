package com.onlineshop.service.impl;

import java.util.List;
import com.onlineshop.dao.IUserProdDAO;
import com.onlineshop.service.IUserProdService;



public class UserProdService implements IUserProdService{
	private IUserProdDAO userProdDAO;
	public IUserProdDAO getUserProdDAO() {
		return userProdDAO;
	}
	public void setUserProdDAO(IUserProdDAO userProdDAO) {
		this.userProdDAO = userProdDAO;
	}
	/**
	 * 商品关键字查询
	 */
	@Override
	public List searchProdByKey(String key) {
		List productList = null;
		if(key.equals("default_moblie") || key.equals("default_computer") || key.equals("default_appliance")
				|| key.equals("default_clothes")) {
			productList = userProdDAO.searchProdByDefaultKey(key);
		}
		else {
			productList = userProdDAO.searchProdByKey(key);
		}
		
		return productList;
	}
	
}
