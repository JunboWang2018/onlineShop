package com.onlineshop.vo;

/**
 * TbProduct entity. @author MyEclipse Persistence Tools
 */

public class TbProduct implements java.io.Serializable {

	// Fields

	private Integer productId;
	private String productName;
	private String productRightPrice;
	private String productOriginalPrice;
	private Integer productStock;
	private String productPromotion;
	private String productType;
	private String productPic;
	private String productDetailPic;

	// Constructors

	/** default constructor */
	public TbProduct() {
	}

	/** minimal constructor */
	public TbProduct(Integer productStock, String productPic, String productDetailPic) {
		this.productStock = productStock;
		this.productPic = productPic;
		this.productDetailPic = productDetailPic;
	}

	/** full constructor */
	public TbProduct(String productName, String productRightPrice, String productOriginalPrice, Integer productStock,
			String productPromotion, String productType, String productPic, String productDetailPic) {
		this.productName = productName;
		this.productRightPrice = productRightPrice;
		this.productOriginalPrice = productOriginalPrice;
		this.productStock = productStock;
		this.productPromotion = productPromotion;
		this.productType = productType;
		this.productPic = productPic;
		this.productDetailPic = productDetailPic;
	}

	// Property accessors

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductRightPrice() {
		return this.productRightPrice;
	}

	public void setProductRightPrice(String productRightPrice) {
		this.productRightPrice = productRightPrice;
	}

	public String getProductOriginalPrice() {
		return this.productOriginalPrice;
	}

	public void setProductOriginalPrice(String productOriginalPrice) {
		this.productOriginalPrice = productOriginalPrice;
	}

	public Integer getProductStock() {
		return this.productStock;
	}

	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}

	public String getProductPromotion() {
		return this.productPromotion;
	}

	public void setProductPromotion(String productPromotion) {
		this.productPromotion = productPromotion;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductPic() {
		return this.productPic;
	}

	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}

	public String getProductDetailPic() {
		return this.productDetailPic;
	}

	public void setProductDetailPic(String productDetailPic) {
		this.productDetailPic = productDetailPic;
	}

}