package com.onlineshop.dao;

import java.util.List;

import com.onlineshop.vo.TbCart;
import com.onlineshop.vo.TbProduct;

public interface ICartDAO {
	/**
	 * ��ѯ���ﳵ����Ʒ��Ϣ������List
	 * @param keys
	 * @return
	 */
	public List<TbCart> searchCartProd(String userId);
	
	/**
	 * �����Ʒ�����ﳵ
	 * @param userId
	 * @param prodId
	 * @param prodNum
	 * @return
	 */
	public String addProdToCart(String userId, String prodId, String prodNum);
	
}
