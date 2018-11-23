package com.onlineshop.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.onlineshop.service.ICartService;
import com.onlineshop.vo.TbCart;
import com.onlineshop.vo.TbUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {
	private ICartService cartService;
	
	public String addProdToCart() {
		//���request����
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String prodId = (String) request.getParameter("buy");
		String prodNum = (String) request.getParameter("buyNum");
		//��ȡHttpSession�е�����
		Map session = ActionContext.getContext().getSession();
		TbUser user = (TbUser) session.get("user");
		String userId = user.getUserId().toString();
		System.out.println("CartAction prodId=" + prodId + ",prodNum=" + prodNum + ",userId=" + userId);
		String result = cartService.addProdToCart(userId, prodId, prodNum);
		if(result.equals("success")) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	/**
	 * ��ѯ���ﳵ��Ʒ��Ϣ
	 */
	public String searchCartProd() {
		System.out.println("search cart");
		//��ȡHttpSession�е�����
		Map session = ActionContext.getContext().getSession();
		TbUser user = (TbUser) session.get("user");
		String userId = user.getUserId().toString();
		List<TbCart> cartList = cartService.searchCart(userId);
		session.put("cartList", cartList);
		return SUCCESS;
	}
	public ICartService getCartService() {
		return cartService;
	}
	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}
	
	
}
