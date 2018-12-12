<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.onlineshop.vo.TbUser" %>
<%@ page import="java.text.SimpleDateFormat" %>
	<!-- 判断是否已登录 -->
<%
	TbUser user = (TbUser)session.getAttribute("user");
	if (user == null){
		response.sendRedirect("../user/login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员信息管理</title>
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

	<div class="container"
		style="width: 100%; background: url('image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员信息管理</font>USER INFORMATION MANAGE
				<form class="form-horizontal" style="margin-top: 5px;" method="post" action="infoManage.action">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
								<input name="tbUser.userName" type="text" class="form-control" id="username" 
							value="<%=user.getUserName() %>">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input name="tbUser.userMail" type="email" class="form-control" id="inputEmail3"
								value="<%=user.getUserMail() %>">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-6">
							<input name="tbUser.userRealname" type="text" class="form-control" id="usercaption"
								value="<%=user.getUserRealname() %>">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<%
								if(user.getUserSex().equals("男")){
							%>
									<label class="radio-inline"> <input name="tbUser.userSex" type="radio"
									name="inlineRadioOptions" id="inlineRadio1" value="option1" checked="checked">男
									</label>
									</label> <label class="radio-inline"> <input name="tbUser.userSex" type="radio"
									name="inlineRadioOptions" id="inlineRadio2" value="option2">女
									</label>
							<%
								}
								else {
							 %>
							 		<label class="radio-inline"> <input name="tbUser.userSex" type="radio"
									name="inlineRadioOptions" id="inlineRadio1" value="option1">男
									</label>
									</label> <label class="radio-inline"> <input name="tbUser.userSex" type="radio"
									name="inlineRadioOptions" id="inlineRadio2" value="option2" checked="checked">女
									</label>
							 <%} %>
						</div>
					</div>
					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input name="tbUser.userDate" type="date" class="form-control">
						</div>
						<%
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						%>
						<label for="originDate" class="col-sm-2 control-label"><%=sdf.format(user.getUserDate()) %></label>
					</div>
					<% 
						int i = 0;
						if(user.getUserAddress() != null) {
							String userAddress[] = user.getUserAddress().split(", ");
							for(; i < userAddress.length; i++) {
					%>
							<div class="form-group">
								<label for="userAddress" class="col-sm-2 control-label">收获地址 <%=i+1 %></label>
								<div class="col-sm-6">
									<input name="address<%=i %>" type="text" class="form-control" id="usercaption"
										value="<%=userAddress[i] %>">
								</div>
							</div>						
					<%
							}
						}
						for(; i < 3; i++) {
					%>
						<div class="form-group">
							<label for="userAddress" class="col-sm-2 control-label">收获地址 <%=i+1 %></label>
							<div class="col-sm-6">
								<input name="address<%=i %>" type="text" class="form-control" id="usercaption">
							</div>
						</div>
					<%} %>
					<div class="form-group">
						<label for="userScore" class="col-sm-2 control-label">用户积分</label>
						<div class="col-sm-6">
							<label for="userScore" class="form-control"><%=user.getUserScore() %></label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="修改" name="submit"
								style="background: url('../image/basic/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
		
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>修改密码</font>USER PASSWORD MODIFY
				<form class="form-horizontal" style="margin-top: 5px;" method="post" action="pwdModify.action">
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">原密码</label>
						<div class="col-sm-6">
							<input name="originPWD" type="password" class="form-control" id="inputPassword3"
								placeholder="请输入原密码">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">新密码</label>
						<div class="col-sm-6">
							<input name="newPWD" type="password" class="form-control" id="inputPassword3"
								placeholder="请输入新密码">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input name="newPWDConfirm" type="password" class="form-control" id="inputPassword3"
								placeholder="请再次输入密码">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="修改" name="submit"
								style="background: url('../image/basic/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="../footer&header/footer.jsp"></jsp:include>

</body>
</html>




