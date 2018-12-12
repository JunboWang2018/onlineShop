package com.onlineshop.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.onlineshop.service.IUserService;
import com.onlineshop.utils.Const;
import com.onlineshop.utils.UserPwdMD5;
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
		String rightCheckCode = (String) session.get(Const.CHECKCODE_SESSION);
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
			System.out.println("something wrong unknow");
		}
		//更正性别信息
		if(tbUser.getUserSex().equals("option1")) {
			tbUser.setUserSex("男");
		}
		else {
			tbUser.setUserSex("女");
		}
		System.out.println("username=" + tbUser.getUserName() + ", password=" + tbUser.getUserPassword() + ", mail=" + tbUser.getUserMail() + 
				", realname=" + tbUser.getUserRealname() + ", sex=" + tbUser.getUserSex() + ", date=" + tbUser.getUserDate().toString() + ", score=" + tbUser.getUserScore());	
		tbUser.setUserScore(Integer.valueOf(0));
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
	
	public String searchInfo() {
		
		return SUCCESS;
	}
	
	public String userInfoManage() {
		//获取HttpSession中的内容
		Map session = ActionContext.getContext().getSession();
		TbUser sessionUser = (TbUser) session.get("user");
		//验证输入的注册信息
		if(tbUser == null){
			System.out.println("tbUser is null");
			return ERROR;
		}
		tbUser.setUserId(sessionUser.getUserId());
		if(tbUser.getUserName().equals("")) {
			System.out.println("username is null");
			tbUser.setUserName(sessionUser.getUserName());
		}
		if(tbUser.getUserMail().equals("")) {
			System.out.println("mail is null");
			tbUser.setUserMail(sessionUser.getUserMail());
		}
		if(tbUser.getUserRealname().equals("")) {
			System.out.println("realname is null");
			tbUser.setUserRealname(sessionUser.getUserRealname());
		}
		if(tbUser.getUserSex().equals("option1")) {
			System.out.println("sex is option1, change to man");
			tbUser.setUserSex("男");
		}
		else {
			System.out.println("sex is option2, change to woman");
			tbUser.setUserSex("女");
		}
		if(tbUser.getUserDate() == null) {
			System.out.println("date is null");
			tbUser.setUserDate(sessionUser.getUserDate());
		}
		tbUser.setUserScore(sessionUser.getUserScore());
		tbUser.setUserPassword(sessionUser.getUserPassword());
		System.out.println("username=" + tbUser.getUserName() + ", password=" + tbUser.getUserPassword() + ", mail=" + tbUser.getUserMail() + 
				", realname=" + tbUser.getUserRealname() + ", sex=" + tbUser.getUserSex() + ", date=" + tbUser.getUserDate().toString() + ", score=" + tbUser.getUserScore());	
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		StringBuffer userAddress = new StringBuffer();
		String[] userAddressArray = new String[3];
		//add origin address
//		if(!sessionUser.getUserAddress().isEmpty() && sessionUser.getUserAddress() != null) {
//			System.out.println("origin address = " + sessionUser.getUserAddress());
//			String[] originAddress = sessionUser.getUserAddress().split(Const.ADDRESS_SPLIT);
//			for(int i = 0; i < originAddress.length; i++) {
//				userAddressArray[i] = originAddress[i];
//			}
//		}
		
		//add address, spilt with ,_
		if(!request.getParameter("address0").equals("") && request.getParameter("address0") != null) {
			userAddressArray[0] = request.getParameter("address0").trim();	
		}
		if(!request.getParameter("address1").equals("") && request.getParameter("address1") != null) {
			userAddressArray[1] = request.getParameter("address1").trim();
		}
		if(!request.getParameter("address2").equals("") && request.getParameter("address2") != null) {
			userAddressArray[2] = request.getParameter("address2").trim();
		}
		for(int i = 0; i < userAddressArray.length; i++) {
			if(userAddressArray[i] != null && !userAddressArray[i].equals("")) {
				userAddress.append(userAddressArray[i]);
				if(i + 1 < userAddressArray.length && userAddressArray[i + 1] != null && !userAddressArray[i + 1].equals("")) {
					userAddress.append(Const.ADDRESS_SPLIT);
				}
			}
		}	
		System.out.println("address=" + userAddress.toString());
		tbUser.setUserAddress(userAddress.toString());
		TbUser tb = userService.userInfoManage(tbUser);
		if(tb != null){
			//讲用户存到session中
			session.put("user", tb);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String userPasswordModify() {
		Map session = ActionContext.getContext().getSession();
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String originPWD = request.getParameter("originPWD");
		String newPWD = request.getParameter("newPWD");
		TbUser tb = (TbUser) session.get("user");
		System.out.println("originPWD = " + originPWD + ", newPWD = " + newPWD + ", userId = " + tb.getUserId());
		System.out.println(tb.getUserPassword().equals(UserPwdMD5.GetMD5Code(originPWD)));
		if(!tb.getUserPassword().equals(UserPwdMD5.GetMD5Code(originPWD))) {
			System.out.println("origin password enter error");
			return ERROR;
		}
		return userService.userPasswordModify(tb.getUserId().toString(), originPWD, newPWD);
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
