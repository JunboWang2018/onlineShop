package com.onlineshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.onlineshop.dao.BaseDAO;
import com.onlineshop.dao.IUserDAO;
import com.onlineshop.utils.Const;
import com.onlineshop.vo.TbUser;

public class UserDAO extends BaseDAO implements IUserDAO {

	/**
	 *	登陆验证
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
	 * 注册
	 */
	@Override
	public TbUser registerTbUser(TbUser tbUser) {
		//打开session
		Session session = getSession();
		//将user对象保存到数据库中
		Transaction tx = session.beginTransaction(); //开启事务
		Integer result = (Integer) session.save(tbUser);
		tx.commit();	//提交事务
		if(result > 0) {
			return tbUser;
		}
		else {
			return null;
		}	
	}

	@Override
	public TbUser userInfoManage(TbUser tbUser) {
		Session session = this.getSession();
		Transaction tsc = session.beginTransaction();
		String updateHql = "update TbUser u set u.userName=?,u.userMail=?,u.userRealname=?," + 
						"u.userSex=?,u.userDate=?,u.userAddress=? where u.userId=?";
		Query query = session.createQuery(updateHql);
		query.setParameter(0, tbUser.getUserName());
		query.setParameter(1, tbUser.getUserMail());
		query.setParameter(2, tbUser.getUserRealname());
		query.setParameter(3, tbUser.getUserSex());
		query.setParameter(4, tbUser.getUserDate());
		query.setParameter(5, tbUser.getUserAddress());
		query.setParameter(6, tbUser.getUserId());
		int result = query.executeUpdate();
		System.out.println("result = " + result);
		tsc.commit();
		if(result == 1) {
			return tbUser;
		}
		return null;
	}
	
	/**
	 * change password
	 */
	@Override
	public String userPasswordModify(String userId, String newPWD) {
		Session session = this.getSession();
		Transaction tsc = session.beginTransaction();
		String updateHql = "update TbUser u set u.userPassword=? where u.userId=?";
		Query query = session.createQuery(updateHql);
		query.setParameter(0, newPWD);
		query.setParameter(1, Integer.parseInt(userId));
		int result = query.executeUpdate();
		System.out.println("result = " + result);
		tsc.commit();
		if(result == 1) {
			return Const.SUCCESS;
		}
		return Const.ERROR;
	}

}
