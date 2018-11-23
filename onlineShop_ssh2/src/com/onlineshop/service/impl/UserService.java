package com.onlineshop.service.impl;

import com.onlineshop.utils.UserPwdMD5;
import com.onlineshop.service.IUserService;
import com.onlineshop.dao.IUserDAO;
import com.onlineshop.vo.TbUser;

public class UserService implements IUserService{
	private IUserDAO userDAO;
	
	/**
	 * 实现仅登陆验证的业务，适用于已注册账户
	 */
	@Override
	public TbUser validateTbUser(String username, String password) {
		password = UserPwdMD5.GetMD5Code(password); //用MD5算法加密后验证
		return userDAO.validateTbUser(username, password);
	}
	
	/**
	 * 实现注册的业务，适用于未注册账户
	 */
	@Override
	public TbUser registerTbUser(TbUser tbUser) {
		//将密码用MD5加密算法加密
		tbUser.setUserPassword(UserPwdMD5.GetMD5Code(tbUser.getUserPassword()));
		return userDAO.registerTbUser(tbUser);
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	
	

}
