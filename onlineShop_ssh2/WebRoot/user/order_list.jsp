<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.onlineshop.vo.TbOrder" %>
<%@ page import="com.onlineshop.vo.TbUser" %>
<!-- 判断是否已登录 -->
<%
	TbUser user = (TbUser)session.getAttribute("user");
	if (user == null){
		response.sendRedirect("../user/login.jsp");
	}
%>
<% 
	List<TbOrder> orderList = (List)session.getAttribute("orderList");
%>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>订单</title>
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
</style>
</head>

<body>


	<!-- 引入header.jsp -->
	<jsp:include page="../footer&header/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
				<strong>我的订单</strong>
				<table class="table table-bordered">
					<% 
						int sumPrice = 0;
						if(orderList != null) {
							for(TbOrder order : orderList) {
								double itemSumPrice = 0;
								int price = Integer.parseInt(order.getOrderProdPrice());
								int num = order.getOrderProdNum();
								itemSumPrice += price * num;
								sumPrice += itemSumPrice;
					%>
						<tbody>
							<tr class="success">
								<th colspan="5">订单编号:<%=order.getOrderId() %></th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<tr class="active">
								<td width="60" width="40%"><input type="hidden" name="id"
									value="22"> <img src="../image/product/<%=order.getOrderProdPic() %>" width="70"
									height="60"></td>
								<td width="30%"><a target="_blank"><%=order.getOrderProdName() %></a></td>
								<td width="20%">￥<%=order.getOrderProdPrice() %></td>
								<td width="10%"><%=order.getOrderProdNum() %></td>
								<td width="15%"><span class="subtotal">￥<%=itemSumPrice %></span></td>
							</tr>
						</tbody>
					<%  
							}
						}
					%>
				</table>
			</div>
		</div>
		<div style="margin-right:130px;">
			<div style="text-align:right;">
				<em style="color:#ff6600;">
			登录后确认是否享有优惠&nbsp;&nbsp;
		</em> 赠送积分: <em style="color:#ff6600;">596</em>&nbsp; 商品金额: <strong style="color:#ff6600;">￥<%=sumPrice %>元</strong>
			</div>
			<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
				<a href="order_info.htm">
					<input type="submit" width="100" value="结账" name="submit" border="0" style="background: url('../image/basic/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
					height:35px;width:100px;color:white;">
				</a>
			</div>
		</div>
		<div style="text-align: center;">
			<ul class="pagination">
				<li class="disabled"><a href="#" aria-label="Previous"><span
						aria-hidden="true">&laquo;</span></a></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">6</a></li>
				<li><a href="#">7</a></li>
				<li><a href="#">8</a></li>
				<li><a href="#">9</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="../footer&header/footer.jsp"></jsp:include>
	
</body>

</html>