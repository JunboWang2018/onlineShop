<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.onlineshop.vo.TbProduct" %>
<%@ page import="com.onlineshop.vo.TbUser" %>
<!-- 判断是否已登录 -->
<%
	TbUser user = (TbUser)session.getAttribute("user");
	if (user == null){
		response.sendRedirect("../user/login.jsp");
	}
%>
<%  
	List<TbProduct> productList = (List<TbProduct>)session.getAttribute("productList");
	TbProduct realProduct = null;
	if(productList != null){
		for(TbProduct product : productList) {
			if(product.getProductId().toString().equals(request.getParameter("productId"))) {
				realProduct = product;
				break;
			}
		}
	}
	String[] prodPic = realProduct.getProductPic().split(",");
	String[] prodDetailPic = realProduct.getProductDetailPic().split(",");
%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>商品详情</title>
<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css" />
<script src="../js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="../css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 400px;
}
</style>
</head>

<body>
	<!-- 引入header.jsp -->
	<jsp:include page="../footer&header/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div
				style="border: 1px solid #e4e4e4; width: 930px; margin-bottom: 10px; margin: 0 auto; padding: 10px; margin-bottom: 10px;">
				<a href="./index.htm">首页&nbsp;&nbsp;&gt;</a><a><%=realProduct.getProductType() %></a>
			</div>

			<div style="margin: 0 auto; width: 950px;">
				<div class="col-md-6">
					<!-- 轮播图 -->
					<div class="container-fluid">
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
						<!-- 轮播图的中的小点 -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner" role="listbox">
								<div class="item active">
									<img src="../image/product/2_1_1.jpg">
									<div class="carousel-caption">
										<!-- 轮播图上的文字 -->
									</div>
								</div>
								<div class="item">
									<img src="../image/product/2_1_2.jpg">
									<div class="carousel-caption">
										<!-- 轮播图上的文字 -->
									</div>
								</div>
						</div>
					</div>
	
						<!-- 上一张 下一张按钮 -->
						<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a>
						<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
				</div>
					
				</div>
				
				<div class="col-md-6">
					<div>
						<strong><%=realProduct.getProductName() %></strong>
					</div>
					<div style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
						<div>商品编号：<%=realProduct.getProductId().toString() %></div>
					</div>

					<div style="margin: 10px 0 10px 0;">
						优惠价: <strong style="color: #ef0101;">￥：<%=realProduct.getProductRightPrice() %>元</strong>
						<%
							if(realProduct.getProductOriginalPrice() != null) {
								out.write(" 参 考 价：<del>￥" + realProduct.getProductOriginalPrice() + "元</del>");
							}
						%>
						
					</div>
					
					<%
						if(realProduct.getProductOriginalPrice() != null) {
							out.write("<div style=\"margin: 10px 0 10px 0;\">");
							out.write("促销: <a target=\"_blank\" title=\"限时抢购 (2014-07-30 ~ 2015-01-01)\"");
							out.write("style=\"background-color: #f07373;\">" + realProduct.getProductPromotion() + "</a></div>");
						}
					%>
			
					<div style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
						<div>库存数量：<%=realProduct.getProductStock() %></div>
					</div>
					
					<div
						style="padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #fffee6;">
						<form action="addCartAction.action" method="post">
							<div style="margin: 5px 0 10px 0;">白色</div>
	
							<div
								style="border-bottom: 1px solid #faeac7; margin-top: 20px; padding-left: 10px;">
								购买数量: <input id="buyNum" name="buyNum" value="1"
									maxlength="4" size="10" type="text">
							</div>
							
							<div style="margin: 20px 0 10px 0;; text-align: center;">
								<input
									style="background: url('../image/basic/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0); height: 36px; width: 127px;"
									value="加入购物车" type="submit">&nbsp;收藏商品
							</div>
							<input type="hidden" name="buy" value="<%=realProduct.getProductId()%>">
						</form>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<div style="width: 950px; margin: 0 auto;">
				<div
					style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>商品介绍</strong>
				</div>

				<div>
					<% 
						for(String detailPath : prodDetailPic) {
					%>
							<img src="../image/product/<%=detailPath%>">
					<% 
						}
					%>
				</div>

				<div
					style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>商品参数</strong>
				</div>
				<div style="margin-top: 10px; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th colspan="2">基本参数</th>
							</tr>
							<tr>
								<th width="10%">级别</th>
								<td width="30%">标准</td>
							</tr>
							<tr>
								<th width="10%">标重</th>
								<td>500</td>
							</tr>
							<tr>
								<th width="10%">浮动</th>
								<td>200</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div style="background-color: #d3d3d3; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>商品评论</strong></th>
							</tr>
							<tr class="warning">
								<th>暂无商品评论信息 <a>[发表商品评论]</a></th>
							</tr>
						</tbody>
					</table>
				</div>

				<div style="background-color: #d3d3d3; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>商品咨询</strong></th>
							</tr>
							<tr class="warning">
								<th>暂无商品咨询信息 <a>[发表商品咨询]</a></th>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>


	<!-- 引入footer.jsp -->
	<jsp:include page="../footer&header/footer.jsp"></jsp:include>

</body>

</html>