package com.onlineshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.onlineshop.dao.BaseDAO;
import com.onlineshop.dao.IUserDAO;
import com.onlineshop.vo.TbUser;

public class UserDAO extends BaseDAO implements IUserDAO {

	/**
	 *	��½��֤
	 */
	@Override
	public TbUser validateTbUser(String username, String password) {
		String sql = "from TbUser u where u.userName=? and u.userPassword=?";
		Session session = getSession();
		Query query = session.createQuery(sql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List tbusers = query.list();
		if(!tbusers.isEmpty()) {
			TbUser tbuser = (TbUser)tbusers.get(0);
			return tbuser;
		}
		session.close();
		return null;
	}

	/**
	 * ע��
	 */
	@Override
	public TbUser registerTbUser(TbUser tbUser) {
		//��session
		Session session = getSession();
		//��user���󱣴浽���ݿ���
		Transaction tx = session.beginTransaction(); //��������
		Integer result = (Integer) session.save(tbUser);
		tx.commit();	//�ύ����
		if(result > 0) {
			return tbUser;
		}
		else {
			return null;
		}	
	}

}
