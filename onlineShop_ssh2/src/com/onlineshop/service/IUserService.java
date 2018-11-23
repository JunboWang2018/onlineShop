package com.onlineshop.service;

import com.onlineshop.vo.TbUser;

public interface IUserService {
	/**
	 * µÇÂ¼service
	 * @param username, password
	 * @return
	 */
	public TbUser validateTbUser(String username, String password);	//µÇÂ½service
	
	/**
	 * ×¢²áservice
	 * @param username, password, tel, mail, testresult, power
	 * @return
	 */
	public TbUser registerTbUser(TbUser tbUser);  //×¢²áservice

}
