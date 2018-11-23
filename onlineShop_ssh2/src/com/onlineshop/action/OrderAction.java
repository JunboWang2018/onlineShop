package com.onlineshop.action;

import java.util.List;
import java.util.Map;

import com.onlineshop.service.IOrderService;
import com.onlineshop.vo.TbCart;
import com.onlineshop.vo.TbOrder;
import com.onlineshop.vo.TbUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	private IOrderService orderService;
	
	public String searchOrderProd() {
		//获取HttpSession中的内容
		Map session = ActionContext.getContext().getSession();
		TbUser user = (TbUser) session.get("user");
		String userId = user.getUserId().toString();
		System.out.println("search order information, userId=" + userId);
		List<TbOrder> orderList = orderService.searchOrderProd(userId);
		if(orderList != null) {
			session.put("orderList", orderList);
			System.out.println("orderList is not null and already add to session");
			return SUCCESS;
		}
		else {
			System.out.println("orderList is null");
			return ERROR;
		}
		
	}

	public String addOrder() {
		//获取HttpSession中的内容
		Map session = ActionContext.getContext().getSession();
		TbUser user = (TbUser) session.get("user");
		String userId = user.getUserId().toString();
		System.out.println("add order information, userId=" + userId);
		String result = orderService.addOrder(userId);
		if(result.equals("success")) {
			System.out.println("add order success");
			return SUCCESS;
		}
		else {
			System.out.println("add order field");
			return ERROR;
		}
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	
	
}
