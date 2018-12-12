package com.onlineshop.dao;

import com.onlineshop.vo.TbUser;

public interface IUserDAO {
	/**
	 * µÇÂ¼DAO
	 * @param username, password
	 * @return
	 */
	public TbUser validateTbUser(String username, String password); //µÇÂ½
	
	/**
	 * ×¢²áDAO
	 * @param username, password, tel, mail, testresult, power
	 * @return
	 */
	public TbUser registerTbUser(TbUser tbUser);  //×¢²áservice

	public TbUser userInfoManage(TbUser tbUser);
	
	public String userPasswordModify(String userId, String newPWD);
}
