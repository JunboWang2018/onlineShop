<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.onlineshop.vo.TbCart" %>
<%@ page import="com.onlineshop.vo.TbUser" %>
<!-- 判断是否已登录 -->
<%
	TbUser user = (TbUser)session.getAttribute("user");
	if (user == null){
		response.sendRedirect("../user/login.jsp");
	}
%>
<% 
	List<TbCart> cartList = (List)session.getAttribute("cartList");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title> 购物车</title>
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
				height: 300px;
			}
			
			font {
				color: #3164af;
				font-size: 18px;
				font-weight: normal;
				padding: 0 10px;
			}
		</style>
	</head>

	<body>
		<!-- 引入header.jsp -->
		<jsp:include page="../footer&header/header.jsp"></jsp:include>

		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong style="font-size:16px;margin:5px 0;">购物车详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
								<th>操作</th>
							</tr>
							<% 
								int sumPrice = 0;
								if(cartList != null) {
									for(TbCart cart : cartList) {
										int itemSumPrice = 0;
										int price = Integer.parseInt(cart.getCartProdPrice());
										int num = cart.getCartProdNum();
										itemSumPrice += price * num;
										sumPrice += itemSumPrice;									
							%>
										<tr class="active">
											<td width="60" width="40%">
												<input type="hidden" name="id" value="22">
												<img src="../image/product/<%=cart.getCartProdPic() %>" width="70" height="60">
											</td>
											<td width="30%">
												<a target="_blank"><%=cart.getCartProdName() %></a>
											</td>
											<td width="20%">
												￥<%=cart.getCartProdPrice() %>
											</td>
											<td width="10%">
												<span class="subtotal"><%=num %></span>
											</td>
											<td width="15%">
												<span class="subtotal">￥<%=itemSumPrice %></span>
											</td>
											<td>
												<a href="deleteCartProd.action?deleteKey=<%=cart.getCartProdId() %>" class="delete">删除</a>
											</td>
										</tr>
									<%} %>
								<%}%>
						</tbody>
					</table>
				</div>
			</div>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
					<em style="color:#ff6600;">
			</em> 赠送积分: <em style="color:#ff6600;"><%=user.getUserScore() %></em>&nbsp; 商品金额: <strong style="color:#ff6600;">￥<%=sumPrice %>元</strong>
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<a href="searchCartProd.action" id="refresh" class="clear">刷新</a>
					<a href="deleteCartProd.action?deleteKey=ALL" id="clear" class="clear">清空购物车</a>
					<a href="addOrderAction.action">
						<input type="submit" width="100" value="提交订单" name="submit" border="0" style="background: url('../image/basic/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
					</a>
				</div>
			</div>

		</div>

		<!-- 引入footer.jsp -->
		<jsp:include page="../footer&header/footer.jsp"></jsp:include>

	</body>

</html>