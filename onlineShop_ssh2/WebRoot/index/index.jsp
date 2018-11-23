<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>商城首页</title>
		<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css" />
		<script src="../js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="../js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container-fluid">

			<!-- 引入header.jsp -->
			<jsp:include page="../footer&header/header.jsp"></jsp:include>

			<!-- 轮播图 -->
			<div class="container-fluid">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- 轮播图的中的小点 -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<!-- 轮播图的轮播图片 -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="../image/basic/lunbotu1.jpg">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
						<div class="item">
							<img src="../image/basic/lunbotu2.jpg">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
							</div>
						</div>
						<div class="item">
							<img src="../image/basic/lunbotu3.jpg">
							<div class="carousel-caption">
								<!-- 轮播图上的文字 -->
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
			
			<!-- 热门商品 -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>热门商品&nbsp;&nbsp;<img src="../image/basic/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="../image/basic/big01.jpg" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="product_info.htm">
							<img src="../image/basic/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>
				
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/1_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【新品发售 享3期免息】Huawei华为 nova 3i...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;1999.00</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/2_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【限时下单减200享6期免息】Huawei华为 P20...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;3688.00</font></p>
					</div>

					<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/3_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【套餐赠好礼】Xiaomi小米 小米8年度旗舰全面屏...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;2699.00</font></p>
					</div>
					
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/4_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【26日128G直降100】Xiaomi小米 小米8SE...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;1799.00</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/5_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【享6期免息赠运动耳机】Huawei华为 Mate 10...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;3399.00</font></p>
					</div>

					<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/6_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【晒单送好礼】Huawei华为 MateBook X Pro...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;7899.00</font></p>
					</div>
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/1_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【新品发售 享3期免息】Huawei华为 nova 3i...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;1999.00</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/2_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【限时下单减200享6期免息】Huawei华为 P20...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;3688.00</font></p>
					</div>

					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/3_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【套餐赠好礼】Xiaomi小米 小米8年度旗舰全面屏...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;2699.00</font></p>
					</div>
				</div>
			</div>
			
			<!-- 广告条 -->
            <div class="container-fluid">
				<img src="../image/basic/ad.jpg" width="100%"/>
			</div>
			
			<!-- 最新商品 -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>最新商品&nbsp;&nbsp;<img src="../image/basic/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="../image/basic/big01.jpg" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
										<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="product_info.htm">
							<img src="../image/basic/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>
				
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/1_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【新品发售 享3期免息】Huawei华为 nova 3i...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;1999.00</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/2_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【限时下单减200享6期免息】Huawei华为 P20...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;3688.00</font></p>
					</div>

					<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/3_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【套餐赠好礼】Xiaomi小米 小米8年度旗舰全面屏...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;2699.00</font></p>
					</div>
					
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/4_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【26日128G直降100】Xiaomi小米 小米8SE...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;1799.00</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/5_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【享6期免息赠运动耳机】Huawei华为 Mate 10...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;3399.00</font></p>
					</div>

					<div class="col-md-2 yes-right-border" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/6_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【晒单送好礼】Huawei华为 MateBook X Pro...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;7899.00</font></p>
					</div>
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/1_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【新品发售 享3期免息】Huawei华为 nova 3i...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;1999.00</font></p>
					</div>
	
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/2_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【限时下单减200享6期免息】Huawei华为 P20...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;3688.00</font></p>
					</div>

					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="product_info.htm">
							<img src="../image/product/3_1_1.jpg" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="product_info.html" style='color:#666'>【套餐赠好礼】Xiaomi小米 小米8年度旗舰全面屏...</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;2699.00</font></p>
					</div>
				</div>
			</div>			
			
			<!-- 引入footer.jsp -->
			<jsp:include page="../footer&header/footer.jsp"></jsp:include>
			
		</div>
	</body>

</html>