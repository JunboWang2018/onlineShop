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
	 * ��Ʒ�ؼ��ֲ�ѯ
	 */
	public String searchProdByKey() {
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String searchKey = request.getParameter("searchKey");
		System.out.println("searchKey=" + searchKey);
		List productList = userProdService.searchProdByKey(searchKey);
		//��ȡHttpSession�е�����
		Map session = ActionContext.getContext().getSession();
		System.out.println("ProductList put session");
		//���û��浽session��
		session.put("productList", productList);
		return SUCCESS;
	}
	
	/**
	 * ͨ��ȱʡ�ؼ��֣�������Ϣ��mobile��ѯ
	 * @return
	 */
	public String searchProdByDefaultKey_mobile() {
		String key = "default_moblie";
		List productList = userProdService.searchProdByKey(key);
		//��ȡHttpSession�е�����
		Map session = ActionContext.getContext().getSession();
		System.out.println("ProductList put session");
		//���û��浽session��
		session.put("productList", productList);
		return SUCCESS;
	}
	
	/**
	 * ͨ��ȱʡ�ؼ��֣�������Ϣ��computer��ѯ
	 * @return
	 */
	public String searchProdByDefaultKey_computer() {
		String key = "default_computer";
		List productList = userProdService.searchProdByKey(key);
		//��ȡHttpSession�е�����
		Map session = ActionContext.getContext().getSession();
		System.out.println("ProductList put session");
		//���û��浽session��
		session.put("productList", productList);
		return SUCCESS;
	}
	
	/**
	 * ͨ��ȱʡ�ؼ��֣�������Ϣ��appliance��ѯ
	 * @return
	 */
	public String searchProdByDefaultKey_appliance() {
		String key = "default_appliance";
		List productList = userProdService.searchProdByKey(key);
		//��ȡHttpSession�е�����
		Map session = ActionContext.getContext().getSession();
		System.out.println("ProductList put session");
		//���û��浽session��
		session.put("productList", productList);
		return SUCCESS;
	}
	
	/**
	 * ͨ��ȱʡ�ؼ��֣�������Ϣ��clothes��ѯ
	 * @return
	 */
	public String searchProdByDefaultKey_clothes() {
		String key = "default_clothes";
		List productList = userProdService.searchProdByKey(key);
		//��ȡHttpSession�е�����
		Map session = ActionContext.getContext().getSession();
		System.out.println("ProductList put session");
		//���û��浽session��
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
