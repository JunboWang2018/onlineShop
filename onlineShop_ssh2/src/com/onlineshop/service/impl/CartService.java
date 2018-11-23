package com.onlineshop.service.impl;

import java.util.List;

import com.onlineshop.dao.ICartDAO;
import com.onlineshop.service.ICartService;
import com.onlineshop.vo.TbCart;

public class CartService implements ICartService{
	private ICartDAO cartDAO;
	
	/**
	 * ���ﳵ�в�ѯ��Ʒ��Ϣ
	 */
	@Override
	public List<TbCart> searchCart(String userId) {
		List cartProdlist = cartDAO.searchCartProd(userId);
		return cartProdlist;
	}
	
	/**
	 * �����Ʒ�����ﳵ
	 */
	@Override
	public String addProdToCart(String userId, String prodId, String prodNum) {
		return cartDAO.addProdToCart(userId, prodId, prodNum);
	}

	public ICartDAO getCartDAO() {
		return cartDAO;
	}

	public void setCartDAO(ICartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	

	
	
	
}
