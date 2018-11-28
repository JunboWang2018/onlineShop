package com.onlineshop.dao.impl;

import com.onlineshop.dao.BaseDAO;
import com.onlineshop.dao.ICartDAO;
import com.onlineshop.vo.TbCart;
import com.onlineshop.vo.TbProduct;
import java.io.PrintStream;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CartDAO extends BaseDAO implements ICartDAO {
	  public List<TbCart> searchCartProd(String userId) {
		    String sql = "FROM TbCart c where c.userId=?";
		    Session session = getSession();
		    Query query = session.createQuery(sql);
		    query.setParameter(0, Integer.valueOf(userId));
		    List<TbCart> cartList = query.list();
		    session.close();
		    if (cartList.size() != 0) {
		      return cartList;
		    }
		    return null;
	  }
  
	  public String addProdToCart(String userId, String prodId, String prodNum) {
			System.out.println("CartDAO prodId=" + prodId + ",prodNum=" + prodNum + ",userId=" + userId);
			Session session = getSession();
			Transaction tx = session.beginTransaction();
			
			String sqlProd = "from TbProduct p where p.productId=?";
			Query queryProd = session.createQuery(sqlProd);
			queryProd.setParameter(0, Integer.valueOf(prodId));
			List productList = queryProd.list();
			TbProduct product = null;
			if (productList == null) {
				return "error";
			}
			product = (TbProduct)productList.get(0);
			
			
			String sqlCart = "FROM TbCart c where c.userId=?";
			Query queryCart = session.createQuery(sqlCart);
			queryCart.setParameter(0, Integer.valueOf(userId));
			List<TbCart> cartList = queryCart.list();
			System.out.println("list from order and product, order=" + cartList + ",product=" + productList);
			//if product is exist in cart, add number
			for (TbCart cart : cartList) {
				if (cart.getCartProdId().toString().equals(prodId)) {
				    int originNum = cart.getCartProdNum().intValue();
				    int addNum = Integer.valueOf(prodNum).intValue();
				    Integer num = Integer.valueOf(originNum + addNum);
				    cart.setCartProdNum(num);
				    Integer result = (Integer)session.save(cart);
				    tx.commit();
				    if (result.intValue() > 0) {
				      return "success";
				    }
				    return "error";
				}
			}
			//if product is not exist in cart, create.
			TbCart cart = new TbCart();
			cart.setCartProdId(Integer.valueOf(prodId));
			cart.setCartProdPic(product.getProductPic().split(",")[0]);
			cart.setCartProdName(product.getProductName());
			cart.setCartProdPrice(product.getProductRightPrice());
			cart.setCartProdNum(Integer.valueOf(prodNum));
			cart.setUserId(Integer.valueOf(userId));
			Integer result = (Integer)session.save(cart);
			tx.commit();
			if (result.intValue() > 0) {
			  return "success";
			}
			return "error";
	  }
}
