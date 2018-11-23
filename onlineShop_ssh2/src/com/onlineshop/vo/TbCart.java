package com.onlineshop.vo;

/**
 * TbCart entity. @author MyEclipse Persistence Tools
 */

public class TbCart implements java.io.Serializable {

	// Fields

	private Integer cartId;
	private Integer cartProdId;
	private String cartProdName;
	private String cartProdPrice;
	private Integer cartProdNum;
	private String cartProdPic;
	private Integer userId;

	// Constructors

	/** default constructor */
	public TbCart() {
	}

	/** full constructor */
	public TbCart(Integer cartProdId, String cartProdName, String cartProdPrice, Integer cartProdNum,
			String cartProdPic, Integer userId) {
		this.cartProdId = cartProdId;
		this.cartProdName = cartProdName;
		this.cartProdPrice = cartProdPrice;
		this.cartProdNum = cartProdNum;
		this.cartProdPic = cartProdPic;
		this.userId = userId;
	}

	// Property accessors

	public Integer getCartId() {
		return this.cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getCartProdId() {
		return this.cartProdId;
	}

	public void setCartProdId(Integer cartProdId) {
		this.cartProdId = cartProdId;
	}

	public String getCartProdName() {
		return this.cartProdName;
	}

	public void setCartProdName(String cartProdName) {
		this.cartProdName = cartProdName;
	}

	public String getCartProdPrice() {
		return this.cartProdPrice;
	}

	public void setCartProdPrice(String cartProdPrice) {
		this.cartProdPrice = cartProdPrice;
	}

	public Integer getCartProdNum() {
		return this.cartProdNum;
	}

	public void setCartProdNum(Integer cartProdNum) {
		this.cartProdNum = cartProdNum;
	}

	public String getCartProdPic() {
		return this.cartProdPic;
	}

	public void setCartProdPic(String cartProdPic) {
		this.cartProdPic = cartProdPic;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}