<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css" />
<script src="../js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min.js" type="text/javascript"></script>
<!-- 页面定时器 -->
<script>
	//设定倒数秒数
	var t = 3;
	//显示倒数秒数
	function showTime(){
		t -= 1;
		document.getElementById('countdown').innerHTML = t + "秒后跳转到主页...";
		if(t==0){
			location.href='http://localhost:8080/onlineShop_ssh2/index/index.jsp';
		}
		//每秒执行一次,showTime()
		setTimeout("showTime()",1000);
	}
	//执行showTime()
	window.onload=showTime;
</script>
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
				style="background: #fff; width: 784px; heigth:559px; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员注册</font>USER REGISTER
				<div>&nbsp;</div>
				<div>注册成功</div>
				<span id="countdown">3秒后跳转到主页...</span>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="../footer&header/footer.jsp"></jsp:include>

</body>
</html>




