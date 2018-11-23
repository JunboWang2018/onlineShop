package com.onlineshop.dao;

import java.util.List;

import com.onlineshop.vo.TbOrder;

public interface IOrderDAO {
	/**
	 * ��ѯ��������Ʒ��Ϣ������List
	 * @param keys
	 * @return
	 */
	public List<TbOrder> searchOrderProd(String userId);
	
	/**
	 * ��ӵ�����
	 * @param userId
	 * @return
	 */
	public String addOrder(String userId);
}
