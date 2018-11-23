<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img width="198" height="60"src="../image/basic/logo.png" />
	</div>
	<div class="col-md-5">
		<img src="../image/basic/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<!-- 用户未登录 -->
			<c:if test="${empty sessionScope.user}">
				<li><a href="../user/login.jsp">你好，请登录</a></li>
				<li><a href="../user/register.jsp">注册</a></li>	
			</c:if>
			<!-- 用户已登录 -->
			<c:if test="${!empty sessionScope.user}">
				<li>${user.userName }</li>
				<li><a href="logout.action">退出</a></li>
			</c:if>
			<li><a href="searchCartProd.action">购物车</a></li>
			<li><a href="searchOrderProd.action">我的订单</a></li>
		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse" >
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="../index/index.jsp">首页</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="searchProdByDefaultKey_mobile.action">手机数码<span class="sr-only">(current)</span></a></li>
					<li><a href="searchProdByDefaultKey_computer.action">电脑办公</a></li>
					<li><a href="searchProdByDefaultKey_appliance.action">家用电器</a></li>
					<li><a href="searchProdByDefaultKey_clothes.action">服饰箱包</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search" action="searchAction.action" method="post">
					<div class="form-group">
						<input name="searchKey" type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</nav>
</div>