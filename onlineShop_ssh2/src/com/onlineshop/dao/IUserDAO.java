package com.onlineshop.dao;

import com.onlineshop.vo.TbUser;

public interface IUserDAO {
	/**
	 * ��¼DAO
	 * @param username, password
	 * @return
	 */
	public TbUser validateTbUser(String username, String password); //��½
	
	/**
	 * ע��DAO
	 * @param username, password, tel, mail, testresult, power
	 * @return
	 */
	public TbUser registerTbUser(TbUser tbUser);  //ע��service

	public TbUser userInfoManage(TbUser tbUser);
	
	public String userPasswordModify(String userId, String newPWD);
}
