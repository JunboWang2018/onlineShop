package com.onlineshop.service;

import java.util.List;

import com.onlineshop.vo.TbCart;

public interface ICartService {
	/**
	 * 购物车中查询商品
	 * @param key
	 * @return
	 */
	public List<TbCart> searchCart(String userId);
	
	/**
	 * 添加商品到购物车
	 * @param userId
	 * @param prodId
	 * @param prodNum
	 * @return
	 */
	public String addProdToCart(String userId, String prodId, String prodNum);
	
	/**
	 * delete prodcut
	 * @param deleteKey
	 * @return
	 */
	public String deleteProd(String deleteKey);
}
