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
	 * �����û���½�����executeLogin()����
	 */
	public String executeLogin() {
		if((tbUser.getUserName().equals("")) || tbUser.getUserPassword().equals("")) {
			return ERROR;
		}
		//���request����
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		//��ȡHttpSession�е�����
		Map session = ActionContext.getContext().getSession();
		String rightCheckCode = (String) session.get(Const.CHECKCODE_SESSION);
		if(!rightCheckCode.equals(request.getParameter("checkcode"))) {
			return ERROR;
		}
		TbUser tb = userService.validateTbUser(tbUser.getUserName(), tbUser.getUserPassword());
		if(tb != null) {
			//���û��浽session��
			session.put("user", tb);
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * �����û�ע�������executeRegister()����
	 */
	public String executeRegister() {
		
		//��֤�����ע����Ϣ
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
		//�����Ա���Ϣ
		if(tbUser.getUserSex().equals("option1")) {
			tbUser.setUserSex("��");
		}
		else {
			tbUser.setUserSex("Ů");
		}
		System.out.println("username=" + tbUser.getUserName() + ", password=" + tbUser.getUserPassword() + ", mail=" + tbUser.getUserMail() + 
				", realname=" + tbUser.getUserRealname() + ", sex=" + tbUser.getUserSex() + ", date=" + tbUser.getUserDate().toString() + ", score=" + tbUser.getUserScore());	
		tbUser.setUserScore(Integer.valueOf(0));
		//��ȡHttpSession�е�����
		Map session = ActionContext.getContext().getSession();
		//���request����
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String rightCheckCode = (String) session.get("checkcode_session");
		if(!rightCheckCode.equals(request.getParameter("checkcode"))) {
			return ERROR;
		}
		TbUser tb = userService.registerTbUser(tbUser);
		if(tb != null){
			//���û��浽session��
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
	
	public String userInfoManage() {
		//��ȡHttpSession�е�����
		Map session = ActionContext.getContext().getSession();
		TbUser sessionUser = (TbUser) session.get("user");
		//��֤�����ע����Ϣ
		if(tbUser == null){
			System.out.println("tbUser is null");
			return ERROR;
		}
		else if(tbUser.getUserName().equals("")) {
			System.out.println("username is null");
			tbUser.setUserName(sessionUser.getUserName());
		}
		else if(tbUser.getUserMail().equals("")) {
			System.out.println("mail is null");
			tbUser.setUserMail(sessionUser.getUserMail());
		}
		else if(tbUser.getUserRealname() == null) {
			System.out.println("realname is null");
			tbUser.setUserRealname(sessionUser.getUserRealname());
		}
		else if(tbUser.getUserSex() == null) {
			System.out.println("sex is null");
			tbUser.setUserSex(sessionUser.getUserSex());
		}
		else if(tbUser.getUserDate() == null) {
			System.out.println("date is null");
			tbUser.setUserDate(sessionUser.getUserDate());
		}
		else {
			tbUser.setUserScore(sessionUser.getUserScore());
			tbUser.setUserPassword(sessionUser.getUserPassword());
		}
		System.out.println("username=" + tbUser.getUserName() + ", password=" + tbUser.getUserPassword() + ", mail=" + tbUser.getUserMail() + 
				", realname=" + tbUser.getUserRealname() + ", sex=" + tbUser.getUserSex() + ", date=" + tbUser.getUserDate().toString() + ", score=" + tbUser.getUserScore());	
		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		StringBuffer userAddress = new StringBuffer();
		//add address, spilt with ,_
		if(!request.getParameter("address0").equals("") && request.getParameter("address0") != null) {
			userAddress.append(request.getParameter("address0"));	
		}
		if(!request.getParameter("address1").equals("") && request.getParameter("address1") != null) {
			userAddress.append(", ");
			userAddress.append(request.getParameter("address1"));
		}
		if(!request.getParameter("address2").equals("") && request.getParameter("address2") != null) {
			userAddress.append(", ");
			userAddress.append(request.getParameter("address2"));
		}
		System.out.println("address=" + userAddress.toString());
		tbUser.setUserAddress(userAddress.toString());
		TbUser tb = userService.userInfoManage(tbUser);
		if(tb != null){
			//���û��浽session��
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
		if(tb.getUserPassword().equals(UserPwdMD5.GetMD5Code(originPWD))) {
			System.out.println("origin password enter error");
			return ERROR;
		}
		return userService.userPasswordModify(originPWD, newPWD);
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
