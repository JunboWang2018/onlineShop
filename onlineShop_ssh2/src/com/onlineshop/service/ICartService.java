package com.onlineshop.service;

import java.util.List;

import com.onlineshop.vo.TbCart;

public interface ICartService {
	/**
	 * ���ﳵ�в�ѯ��Ʒ
	 * @param key
	 * @return
	 */
	public List<TbCart> searchCart(String userId);
	
	/**
	 * �����Ʒ�����ﳵ
	 * @param userId
	 * @param prodId
	 * @param prodNum
	 * @return
	 */
	public String addProdToCart(String userId, String prodId, String prodNum);
	
	/**
	 * delete prodcut
	 * @param deleteKey
	 * @return
	 */
	public String deleteProd(String deleteKey);
}
