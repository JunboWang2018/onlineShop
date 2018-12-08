package com.onlineshop.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlineshop.dao.BaseDAO;
import com.onlineshop.dao.IOrderDAO;
import com.onlineshop.vo.TbCart;
import com.onlineshop.vo.TbOrder;
import com.onlineshop.vo.TbProduct;

public class OrderDAO extends BaseDAO implements IOrderDAO {

	@Override
	public List<TbOrder> searchOrderProd(String userId) {
		String sql = "FROM TbOrder o where o.userId=?";
	    Session session = getSession();
	    Query query = session.createQuery(sql);
	    query.setParameter(0, Integer.valueOf(userId));
	    List<TbOrder> orderList = query.list();
	    session.close();
	    if(!orderList.isEmpty()) {
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
	    if(cartList.isEmpty()) {
	    	System.out.println("cart is empty, add to order fiald");
	    	return "error";
	    }
	    //save product id, number
	    Map<Integer, Integer> cartProductMap = new HashMap<Integer, Integer>();
	    for(TbCart cart : cartList) {
	    	cartProductMap.put(cart.getCartProdId(), cart.getCartProdNum());
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
	    		//delete cart table
	    		System.out.println("order item save success");
	    		String deleteSql = "delete from TbCart c Where c.userId=?" ;
	    	    Query deleteQuery = session.createQuery(deleteSql);
	    	    deleteQuery.setParameter(0, Integer.valueOf(userId));
	    	    deleteQuery.executeUpdate();
	    	    System.out.println("delete cart success, userId is " + userId);
	    	    
	    	    //update product stock
	    	    this.updateStock(cartProductMap, session);
	    	}
	    	else {
	    		System.out.println("order item save fiald, cartId is " + cart.getCartId());
	    	}
	    }
	    tx.commit();	//commit transaction
		return "success";
	}
	
	private void updateStock(Map<Integer, Integer> cartProductMap, Session session) {
	    System.out.println("update stock");
	    String selectSql = "from TbProduct p where p.productId=?";
	    for (Map.Entry<Integer, Integer> entry : cartProductMap.entrySet()) {
	    	Integer key = entry.getKey();
	    	Integer updateNumber = entry.getValue();
	    	System.out.println("product id = " + key + " updateNumber = " + updateNumber);
	    	Query selectQuery = session.createQuery(selectSql);
	    	selectQuery.setParameter(0, key);
	    	List<TbProduct> list = selectQuery.list();
	    	Integer originStock = list.get(0).getProductStock();
	    	Integer newStock = originStock - updateNumber;
	    	System.out.println("originStock = " + originStock + " newStock = " + newStock);
	    	list.get(0).setProductStock(newStock);
	    	session.save(list.get(0));
	    	System.out.println("stock update success");
	    }
	}
	
	
}
