package com.onlineshop.service.impl;

import java.util.List;

import com.onlineshop.dao.ICartDAO;
import com.onlineshop.service.ICartService;
import com.onlineshop.vo.TbCart;

public class CartService implements ICartService{
	private ICartDAO cartDAO;
	
	/**
	 * 购物车中查询商品信息
	 */
	@Override
	public List<TbCart> searchCart(String userId) {
		List cartProdlist = cartDAO.searchCartProd(userId);
		return cartProdlist;
	}
	
	/**
	 * 添加商品到购物车
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
