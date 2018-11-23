package com.onlineshop.vo;

import java.util.Date;

/**
 * TbOrder entity. @author MyEclipse Persistence Tools
 */

public class TbOrder implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Integer orderProdId;
	private String orderProdPrice;
	private String orderProdName;
	private String orderProdPic;
	private Integer orderProdNum;
	private Date orderSubmitTime;
	private Date orderBusinessDate;
	private String orderIsPayOff;
	private String orderIsSale;
	private Integer userId;

	// Constructors

	/** default constructor */
	public TbOrder() {
	}

	/** full constructor */
	public TbOrder(Integer orderProdId, String orderProdPrice, String orderProdName, String orderProdPic,
			Integer orderProdNum, Date orderSubmitTime, Date orderBusinessDate, String orderIsPayOff,
			String orderIsSale, Integer userId) {
		this.orderProdId = orderProdId;
		this.orderProdPrice = orderProdPrice;
		this.orderProdName = orderProdName;
		this.orderProdPic = orderProdPic;
		this.orderProdNum = orderProdNum;
		this.orderSubmitTime = orderSubmitTime;
		this.orderBusinessDate = orderBusinessDate;
		this.orderIsPayOff = orderIsPayOff;
		this.orderIsSale = orderIsSale;
		this.userId = userId;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderProdId() {
		return this.orderProdId;
	}

	public void setOrderProdId(Integer orderProdId) {
		this.orderProdId = orderProdId;
	}

	public String getOrderProdPrice() {
		return this.orderProdPrice;
	}

	public void setOrderProdPrice(String orderProdPrice) {
		this.orderProdPrice = orderProdPrice;
	}

	public String getOrderProdName() {
		return this.orderProdName;
	}

	public void setOrderProdName(String orderProdName) {
		this.orderProdName = orderProdName;
	}

	public String getOrderProdPic() {
		return this.orderProdPic;
	}

	public void setOrderProdPic(String orderProdPic) {
		this.orderProdPic = orderProdPic;
	}

	public Integer getOrderProdNum() {
		return this.orderProdNum;
	}

	public void setOrderProdNum(Integer orderProdNum) {
		this.orderProdNum = orderProdNum;
	}

	public Date getOrderSubmitTime() {
		return this.orderSubmitTime;
	}

	public void setOrderSubmitTime(Date orderSubmitTime) {
		this.orderSubmitTime = orderSubmitTime;
	}

	public Date getOrderBusinessDate() {
		return this.orderBusinessDate;
	}

	public void setOrderBusinessDate(Date orderBusinessDate) {
		this.orderBusinessDate = orderBusinessDate;
	}

	public String getOrderIsPayOff() {
		return this.orderIsPayOff;
	}

	public void setOrderIsPayOff(String orderIsPayOff) {
		this.orderIsPayOff = orderIsPayOff;
	}

	public String getOrderIsSale() {
		return this.orderIsSale;
	}

	public void setOrderIsSale(String orderIsSale) {
		this.orderIsSale = orderIsSale;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}