package com.onlineshop.dao;

import java.util.List;

import com.onlineshop.vo.TbOrder;

public interface IOrderDAO {
	/**
	 * 查询订单中商品信息，返回List
	 * @param keys
	 * @return
	 */
	public List<TbOrder> searchOrderProd(String userId);
	
	/**
	 * 添加到订单
	 * @param userId
	 * @return
	 */
	public String addOrder(String userId);
}
