package com.onlineshop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.onlineshop.dao.BaseDAO;
import com.onlineshop.dao.IUserProdDAO;
import com.onlineshop.vo.TbProduct;


public class UserProdDAO extends BaseDAO implements IUserProdDAO{

	@Override
	public List searchProdByKey(String key) {
		String sql = "FROM TbProduct";
		Session session = getSession();
		Query query = session.createQuery(sql);
		List<TbProduct> productListAll = query.list();
		List<TbProduct> productList = new ArrayList<TbProduct>();
		for(TbProduct product : productListAll) {
			if(product.getProductName().contains(key)) {
				productList.add(product);
			}
		}
		session.close();
		if(productList.size() != 0) {
			return productList;
		}
		else {
			return null;
		}
	}

	@Override
	public List searchProdByDefaultKey(String key) {
		String sql = "FROM TbProduct p where p.productType=?";
		Session session = getSession();
		Query query = session.createQuery(sql);
		if(key.equals("default_moblie")) {
			query.setParameter(0, "�ֻ�����");
		}
		else if(key.equals("default_computer")) {
			query.setParameter(0, "���԰칫");
		}
		else if(key.equals("default_appliance")) {
			query.setParameter(0, "���õ���");
		}
		else if(key.equals("default_clothes")) {
			query.setParameter(0, "�������");
		}
		else {
			List<TbProduct> productList = searchProdByKey(key);
			return productList;
		}
		List<TbProduct> productList = query.list();
		session.close();
		if(productList.size() != 0) {
			return productList;
		}
		else {
			return null;
		}
	}

}
