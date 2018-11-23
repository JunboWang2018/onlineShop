package com.onlineshop.service.impl;

import java.util.List;

import com.onlineshop.dao.IOrderDAO;
import com.onlineshop.service.IOrderService;
import com.onlineshop.vo.TbOrder;

public class OrderService implements IOrderService{
	private IOrderDAO orderDAO;
	
	@Override
	public List<TbOrder> searchOrderProd(String userId) {
		List<TbOrder> orderList = orderDAO.searchOrderProd(userId);
		if(orderList != null) {
			return orderList;
		}
		else {
			return null;
		}
	}

	@Override
	public String addOrder(String userId) {
		return orderDAO.addOrder(userId);
	}

	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	
}
