package com.onlineshop.test;

import org.junit.Test;

import com.onlineshop.dao.impl.OrderDAO;

public class OrderDAOTest {
	private OrderDAO orderDao = new OrderDAO();
	
	/**
	 * delete cart, add order
	 */
	@Test
	public void addOrderTest() {
		orderDao.addOrder("wangjunbo");
	}
}
