<%@page import="com.xapi.domain.Order"%>
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
<style type="text/css">
</style>

<title>Home</title>
<link href="css/style222.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="css/page-min.css" rel="stylesheet" type="text/css" />
<!-- 下面的样式，仅是为了显示代码，而不应该在项目中使用-->
<link href="css/prettify.css" rel="stylesheet" type="text/css" />
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
<body>
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
			<div class="container">
				<div class="row" style="margin-left: 350px;">
					<div class="span10">
						<div class="tips tips-large tips-success">
							<span class="x-icon x-icon-success"><i
								class="icon icon-ok icon-white"></i></span>
							<div class="tips-content">
								<h2>支付成功共支付<font size="15sp">${money }元</font></h2>
								<p class="auxiliary-text">你可以继续操作以下内容：</p>
								<p>
									<a class="page-action" data-type="setTitle" title="返回用户管理"
										href="${pageContext.request.contextPath }/GoIndexServlet?pageNo=1&pageSize=2&jingdianName=">返回主页</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="js/bui-min.js"></script>

	<script type="text/javascript" src="js/config-min.js"></script>
	<script type="text/javascript">
		BUI.use('common/page');
	</script>
	<!-- 仅仅为了显示代码使用，不要在项目中引入使用-->
	<script type="text/javascript" src="js/prettify.js"></script>
	<script type="text/javascript">
		$(function() {
			prettyPrint();
		});
	</script>


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