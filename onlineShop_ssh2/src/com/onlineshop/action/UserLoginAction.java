package com.onlineshop.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.onlineshop.service.IUserService;
import com.onlineshop.vo.TbUser;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport {
	private TbUser tbUser;
	protected IUserService userService;
	/**
	 * 处理用户登陆请求的executeLogin()方法
	 */
	public String executeLogin() {
		if((tbUser.getUserName().equals("")) || tbUser.getUserPassword().equals("")) {
			return ERROR;
		}
		//获得request对象
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		//获取HttpSession中的内容
		Map session = ActionContext.getContext().getSession();
		String rightCheckCode = (String) session.get("checkcode_session");
		if(!rightCheckCode.equals(request.getParameter("checkcode"))) {
			return ERROR;
		}
		TbUser tb = userService.validateTbUser(tbUser.getUserName(), tbUser.getUserPassword());
		if(tb != null) {
			//讲用户存到session中
			session.put("user", tb);
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * 处理用户注册请求的executeRegister()方法
	 */
	public String executeRegister() {
		
		//验证输入的注册信息
		if(tbUser == null){
			System.out.println("tbUser is null");
			return ERROR;
		}
		else if(tbUser.getUserName().equals("")) {
			System.out.println("username is null");
			return ERROR;
		}
		else if(tbUser.getUserPassword().equals("")) {
			System.out.println("password is null");
			return ERROR;
		}
		else if(tbUser.getUserMail().equals("")) {
			System.out.println("mail is null");
			return ERROR;
		}
		else if(tbUser.getUserRealname() == null) {
			System.out.println("realname is null");
			return ERROR;
		}
		else if(tbUser.getUserSex() == null) {
			System.out.println("sex is null");
			return ERROR;
		}
		else if(tbUser.getUserDate() == null) {
			System.out.println("date is null");
			return ERROR;
		}
		else {
			//更正性别信息
			if(tbUser.getUserSex().equals("option1")) {
				tbUser.setUserSex("男");
			}
			else if(tbUser.getUserSex().equals("option2")) {
				tbUser.setUserSex("女");
			}
			else {
				return ERROR;
			}
			System.out.println("something wrong unknow");
		}
		
		System.out.println("username=" + tbUser.getUserName() + ", password=" + tbUser.getUserPassword() + ", mail=" + tbUser.getUserMail() + 
				", realname=" + tbUser.getUserRealname() + ", sex=" + tbUser.getUserSex() + ", date=" + tbUser.getUserDate().toString());	
		//获取HttpSession中的内容
		Map session = ActionContext.getContext().getSession();
		//获得request对象
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String rightCheckCode = (String) session.get("checkcode_session");
		if(!rightCheckCode.equals(request.getParameter("checkcode"))) {
			return ERROR;
		}
		TbUser tb = userService.registerTbUser(tbUser);
		if(tb != null){
			//讲用户存到session中
			session.put("user", tb);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String logout() {
		Map session = ActionContext.getContext().getSession();
		session.remove("user");
		return SUCCESS;
	}

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
}
