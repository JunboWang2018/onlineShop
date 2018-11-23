package com.onlineshop.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlineshop.dao.BaseDAO;
import com.onlineshop.dao.IOrderDAO;
import com.onlineshop.vo.TbCart;
import com.onlineshop.vo.TbOrder;

public class OrderDAO extends BaseDAO implements IOrderDAO {

	@Override
	public List<TbOrder> searchOrderProd(String userId) {
		String sql = "FROM TbOrder o where o.userId=?";
	    Session session = getSession();
	    Query query = session.createQuery(sql);
	    query.setParameter(0, Integer.valueOf(userId));
	    List<TbOrder> orderList = query.list();
	    session.close();
	    if(orderList.size() > 0) {
	    	return orderList;
	    }
		return null;
	}

	@Override
	public String addOrder(String userId) {
		//get cart information from table cart by userid
		String sql = "FROM TbCart c where c.userId=?";
	    Session session = getSession();
	    Query query = session.createQuery(sql);
	    query.setParameter(0, Integer.valueOf(userId));
	    List<TbCart> cartList = query.list();
	    if(cartList == null) {
	    	System.out.println("cart is empty, add to order fiald");
	    	return "error";
	    }
	    //open transaction
	    Transaction tx = session.beginTransaction();
	    TbOrder order = null;
	    for(TbCart cart : cartList) {
	    	order = new TbOrder();
	    	order.setOrderProdId(cart.getCartProdId());
	    	order.setOrderProdName(cart.getCartProdName());
	    	order.setOrderProdNum(cart.getCartProdNum());
	    	order.setOrderProdPic(cart.getCartProdPic());
	    	order.setOrderProdPrice(cart.getCartProdPrice());
	    	order.setOrderIsPayOff("0");
	    	order.setOrderIsSale("0");
	    	order.setOrderBusinessDate(new Date());
	    	order.setOrderSubmitTime(new Date());
	    	order.setUserId(Integer.valueOf(userId));
	    	Integer result = (Integer) session.save(order);
	    	if(result > 0) {
	    		System.out.println("order item save success");
	    		String deleteSql = "delete from TbCart c Where c.userId=?" ;
	    	    Query deleteQuery = session.createQuery(deleteSql);
	    	    deleteQuery.setParameter(0, Integer.valueOf(userId));
	    	    int deleteResult = deleteQuery.executeUpdate();
	    	    System.out.println("delete cart success, userId is " + userId);
	    	}
	    	else {
	    		System.out.println("order item save fiald, cartId is " + cart.getCartId());
	    	}
	    }
	    tx.commit();	//提交事务
		return "success";
	}
	
	
}
