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
			<div class="header-bottom-left"></div>
			<div class="header-bottom-right">
				<span class="menu">菜单</span>
				<ul class="nav1">
					<li class="cap"><a
						href="${pageContext.request.contextPath }/GoIndexServlet?pageNo=1&pageSize=2&jingdianName=">主页</a></li>
					<li><a href="${pageContext.request.contextPath }/CartServlet?jingdianNo=${jingDian.jingdianNo}">我的预定</a></li>
					<li><a href="gallery.jsp">景色欣赏</a></li>
					<c:if test="${ not empty  user }">
						<li><a>${user.username}&nbsp;欢迎您</a></li>
						<li><a>退出</a></li>
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

			<div align="center" class="col-md-8 sing-img-text"
				style="float: center; width: 100%">
				<div class="Semibold"
					style="font-family: monospace; ">
					<h1 class="glyphicon glyphicon-ok">${gongGao.gongGaoNo }:${gongGao.gongGaoTitle  }
						<br class="glyphicon glyphicon-ok"> ${gongGao.gongGaoContent}
					</h1>
									<h3 style="float: right; margin-right: 20px;margin-top: 50px;">公告日期${gongGao.gongGaoTime }</h3>
					
				</div>
				<img alt="" src="images/aaa.png" height="450px;"
					style="width: 800px;"> <img src="${gongGao.gongGaoPic }" style="width: 900px;"
					alt=" "> <img alt="" src="images/aaa.png" height="450px;"
					style="width: 800px;">
				<div class="sing-img-text1">

					<a class="btn btn-primary btn-lg"
						href="${pageContext.request.contextPath }/SingleJingDianServlet?jingdianNo=${gongGao.jingdianNo}"
						role="button">查看景点详情</a>
					<div class="list"></div>

				</div>
			</div>
			<div class="clearfix"></div>
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