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
code {
	padding: 0px 4px;
	color: #d14;
	background-color: #f7f7f9;
	border: 1px solid #e1e1e8;
}
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
					<li><a href="about.html">景点预定</a></li>
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
		<div class="single">
			<div class="container">
				<div class="gallery">
		<h3>景点欣赏</h3>
		<p class="gal-txt"></p>
		<div class="gallery-grids">
			<div class="gallery-grid">
				 <a class="fancybox" href="images/25.jpg" data-fancybox-group="gallery"><img src="images/25.jpg" class="img-style row6" alt=""><span> </span></a>					
			</div>
			<div class="gallery-grid1">
				<a class="fancybox" href="images/26.jpg" data-fancybox-group="gallery"><img src="images/26.jpg" class="img-style row6" alt=""><span> </span></a>
			</div>
			<div class="gallery-grid">
				<a class="fancybox" href="images/27.jpg" data-fancybox-group="gallery"><img src="images/27.jpg" class="img-style row6" alt=""><span> </span></a>
			</div>
			<div class="gallery-grid1">
				<a class="fancybox" href="images/28.jpg" data-fancybox-group="gallery"><img src="images/28.jpg" class="img-style row6" alt=""><span> </span></a>
			</div>
			<div class="gallery-grid">
				<a class="fancybox" href="images/29.jpg" data-fancybox-group="gallery"><img src="images/29.jpg" class="img-style row6" alt=""><span> </span></a>
			</div>
			<div class="clearfix"> </div>
		</div>
		<div class="gallery-grids">
			<div class="gallery-grid">
				 <a class="fancybox" href="images/20.jpg" data-fancybox-group="gallery"><img src="images/20.jpg" class="img-style row6" alt=""><span> </span></a>					
			</div>
			<div class="gallery-grid">
				<a class="fancybox" href="images/21.jpg" data-fancybox-group="gallery"><img src="images/21.jpg" class="img-style row6" alt=""><span> </span></a>
			</div>
			<div class="gallery-grid1">
				<a class="fancybox" href="images/22.jpg" data-fancybox-group="gallery"><img src="images/22.jpg" class="img-style row6" alt=""><span> </span></a>
			</div>
			<div class="gallery-grid">
				<a class="fancybox" href="images/23.jpg" data-fancybox-group="gallery"><img src="images/23.jpg" class="img-style row6" alt=""><span> </span></a>
			</div>
			<div class="gallery-grid1">
				<a class="fancybox" href="images/24.jpg" data-fancybox-group="gallery"><img src="images/24.jpg" class="img-style row6" alt=""><span> </span></a>
			</div>
			<div class="clearfix"> </div>
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