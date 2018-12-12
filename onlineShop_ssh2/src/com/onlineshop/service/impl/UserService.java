package com.onlineshop.service.impl;

import com.onlineshop.utils.Const;
import com.onlineshop.utils.UserPwdMD5;
import com.onlineshop.service.IUserService;
import com.onlineshop.dao.IUserDAO;
import com.onlineshop.vo.TbUser;

public class UserService implements IUserService{
	private IUserDAO userDAO;
	
	/**
	 * ʵ�ֽ���½��֤��ҵ����������ע���˻�
	 */
	@Override
	public TbUser validateTbUser(String username, String password) {
		password = UserPwdMD5.GetMD5Code(password); //��MD5�㷨���ܺ���֤
		return userDAO.validateTbUser(username, password);
	}
	
	/**
	 * ʵ��ע���ҵ��������δע���˻�
	 */
	@Override
	public TbUser registerTbUser(TbUser tbUser) {
		//��������MD5�����㷨����
		tbUser.setUserPassword(UserPwdMD5.GetMD5Code(tbUser.getUserPassword()));
		return userDAO.registerTbUser(tbUser);
	}
	
	@Override
	public TbUser userInfoManage(TbUser tbUser) {
		return userDAO.userInfoManage(tbUser);
	}
	
	@Override
	public String userPasswordModify(String userId, String originPWD, String newPWD) {
		if(newPWD == null || newPWD.equals("")) {
			System.out.println("newPWD is null");
			return Const.ERROR;
		}
		//����
		newPWD = UserPwdMD5.GetMD5Code(newPWD);
		if(originPWD.equals(newPWD)) {
			System.out.println("originPWD == newPWD");
			return Const.ERROR;
		}
		else {
			return userDAO.userPasswordModify(userId, newPWD);
		}
	}	

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}



}
