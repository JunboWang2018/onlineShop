package com.onlineshop.service;

import com.onlineshop.vo.TbUser;

public interface IUserService {
	/**
	 * ��¼service
	 * @param username, password
	 * @return
	 */
	public TbUser validateTbUser(String username, String password);	//��½service
	
	/**
	 * ע��service
	 * @param username, password, tel, mail, testresult, power
	 * @return
	 */
	public TbUser registerTbUser(TbUser tbUser);  //ע��service

}
