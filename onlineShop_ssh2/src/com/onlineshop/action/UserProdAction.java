package com.onlineshop.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.onlineshop.service.IUserProdService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserProdAction extends ActionSupport {
	private IUserProdService userProdService;
	/**
	 * 商品关键字查询
	 */
	public String searchProdByKey() {
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String searchKey = request.getParameter("searchKey");
		System.out.println("searchKey=" + searchKey);
		List productList = userProdService.searchProdByKey(searchKey);
		//获取HttpSession中的内容
		Map session = ActionContext.getContext().getSession();
		System.out.println("ProductList put session");
		//讲用户存到session中
		session.put("productList", productList);
		return SUCCESS;
	}
	
	/**
	 * 通过缺省关键字（分类信息）mobile查询
	 * @return
	 */
	public String searchProdByDefaultKey_mobile() {
		String key = "default_moblie";
		List productList = userProdService.searchProdByKey(key);
		//获取HttpSession中的内容
		Map session = ActionContext.getContext().getSession();
		System.out.println("ProductList put session");
		//讲用户存到session中
		session.put("productList", productList);
		return SUCCESS;
	}
	
	/**
	 * 通过缺省关键字（分类信息）computer查询
	 * @return
	 */
	public String searchProdByDefaultKey_computer() {
		String key = "default_computer";
		List productList = userProdService.searchProdByKey(key);
		//获取HttpSession中的内容
		Map session = ActionContext.getContext().getSession();
		System.out.println("ProductList put session");
		//讲用户存到session中
		session.put("productList", productList);
		return SUCCESS;
	}
	
	/**
	 * 通过缺省关键字（分类信息）appliance查询
	 * @return
	 */
	public String searchProdByDefaultKey_appliance() {
		String key = "default_appliance";
		List productList = userProdService.searchProdByKey(key);
		//获取HttpSession中的内容
		Map session = ActionContext.getContext().getSession();
		System.out.println("ProductList put session");
		//讲用户存到session中
		session.put("productList", productList);
		return SUCCESS;
	}
	
	/**
	 * 通过缺省关键字（分类信息）clothes查询
	 * @return
	 */
	public String searchProdByDefaultKey_clothes() {
		String key = "default_clothes";
		List productList = userProdService.searchProdByKey(key);
		//获取HttpSession中的内容
		Map session = ActionContext.getContext().getSession();
		System.out.println("ProductList put session");
		//讲用户存到session中
		session.put("productList", productList);
		return SUCCESS;
	}
	
	public IUserProdService getUserProdService() {
		return userProdService;
	}
	public void setUserProdService(IUserProdService userProdService) {
		this.userProdService = userProdService;
	}
}
