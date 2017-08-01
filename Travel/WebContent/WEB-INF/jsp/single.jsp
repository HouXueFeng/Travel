<%@page import="com.xapi.domain.JingDian"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.xapi.util.*"%>
<%@ page import="java.util.List "%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>

<title>Home</title>
<link href="css/style222.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- js -->
<script src="js/jquery.min.js"></script>
<script type="text/javaScript">
	
</script>
<!-- //js -->
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Eco Travel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!-- start-smoth-scrolling -->
<!-- start-smoth-scrolling -->
</head>

<body style="background-color: #eae8dc">
	<!-- banner -->
	<div class="header">
			<div class="clearfix"></div>
			<div class="header-bottom">
				<div class="header-bottom-left">
				</div>
				<div class="header-bottom-right">
					<span class="menu">菜单</span>
					<ul class="nav1">
						<li class="cap"><a href="${pageContext.request.contextPath }/GoIndexServlet?pageNo=1&pageSize=2&jingdianName=">主页</a></li>
						<li><a href="${pageContext.request.contextPath }/CartServlet?jingdianNo=${jingDian.jingdianNo}">我的预定</a></li>
						<li><a href="gallery.jsp">景色欣赏</a></li>
						<c:if test="${ not empty  user }">
							<li><a>${user.username}&nbsp;欢迎您</a></li>
							<li><a
								href="${pageContext.request.contextPath }/LayoutServlet">退出</a></li>
						</c:if>
						<c:if test="${empty user}">
							<a href="${pageContext.request.contextPath }/LoginServlet">请您登陆</a>
						</c:if>
					</ul>
					<!-- script for menu -->
					<script>
						$("span.menu").click(function() {
							$("ul.nav1").slideToggle(300, function() {
								// Animation complete.
							});
						});
					</script>
					<!-- //script for menu -->
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	<div class="container">
			<div class="single">
			<div class="col-md-8 sing-img-text">
				<img src="${jingDian.jingdianPic }" alt=" ">
				<div class="sing-img-text1">
				<h3>景点介绍</h3>	
				<br><br>				
				
				<h5>${jingDian.jingdianDetail }</h5>
					<div class="list">
					<c:if test="${not empty  user }">
												 <button type="button" class="btn btn-info" style="float: right;" onclick="window.location.href='${pageContext.request.contextPath }/CartServlet?jingdianNo=${jingDian.jingdianNo}'">加入购物车</button> 
					</c:if>
					</div>
					
				</div>
			</div>
			<div class="col-md-4 sing-img-text-left">
				<div class="blog-right1">
					<div class="categories">
						<h3>景点名称--->${jingDian.jingdianTitle}</h3>
						<ul>
							<li><a href="#">景点地点--->${jingDian.jingdianAddress}</a></li>
							<li><a href="#">景点价格--->${jingDian.jingdianPrice}￥</a></li>
							<li><a href="#">景点时间--->${jingDian.jingdianTime}</a></li>
						</ul>
					</div>
					<div class="categories categories-mid">
						<h3>旅游旺季</h3>
						<ul>
							<li><a href="#">1月 20,2017</a></li>
							<li><a href="#">3月 20,2014</a></li>
							<li><a href="#">8月 20,2012</a></li>
							<li><a href="#">11月 2,2012</a></li>
							<li><a href="#">12月 25,2014</a></li>
							<li><a href="#">2月 14,2015</a></li>
						</ul>
					</div>
					<div class="related-posts">
						<h3>旅游周刊</h3>
						<c:forEach begin="0" end="1">
						<div class="related-post">
							<div class="related-post-left">
								<a href="single.html"><img src="images/4.jpg" alt=" " /></a>
							</div>
							<div class="related-post-right">
							
								<h4><a href="single.html">畅游${jingDian.jingdianTitle}</a></h4>
									<span>景点编号[1]：${jingDian.jingdianNo}</span>
								<p>${jingDian.jingdianTime}
								</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						</c:forEach>
						
					</div>
				</div>
			</div>
			<div class="clearfix"> </div>
		</div>
		</div>
	

	<div class="footer">
		<p>
			Copyright &copy; 2015.Company name All rights reserved.More Templates
			<a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
			- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
				target="_blank">网页模板</a>
		</p>
	</div>
</body>
</html>