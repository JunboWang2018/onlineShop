package com.onlineshop.dao;

import java.util.List;

import com.onlineshop.vo.TbCart;
import com.onlineshop.vo.TbProduct;

public interface ICartDAO {
	/**
	 * 查询购物车中商品信息，返回List
	 * @param keys
	 * @return
	 */
	public List<TbCart> searchCartProd(String userId);
	
	/**
	 * 添加商品到购物车
	 * @param userId
	 * @param prodId
	 * @param prodNum
	 * @return
	 */
	public String addProdToCart(String userId, String prodId, String prodNum);
	
}
