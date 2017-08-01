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
<style>
table {
	width: 500px;
	border: 0;
	text-align: center;
	border-collapse: collapse;
	border-spacing: 0;
}

table th {
	background: #0090D7;
	font-weight: normal;
	line-height: 30px;
	font-size: 20px;
	color: #FFF;
}

table tr:nth-child(odd) {
	background: #F4F4F4;
}

table td:nth-child(even) {
	color: #C00;
}

table tr:hover {
	background: #73B1E0;
	color: #FF0000;
}

table td, table th {
	border: 1px solid #EEE;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: none;
}

a:active {
	text-decoration: none;
}
</style>
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
					<li><a
						href="${pageContext.request.contextPath }/CartServlet?jingdianNo=${jingDian.jingdianNo}">我的预定</a></li>
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
			<table class="table table-bordered ">
				<tr>
					<td align="center" width="25%"><strong>清单</strong></td>
					<td align="center" width="25%"><strong> 数量</strong></td>
					<td align="center" width="25%"><strong>单价</strong></td>
					<td align="center" width="25%"><strong>操作</strong></td>

				</tr>

				<c:forEach items="${userCart}" var="cart" varStatus="status">
					<tr class="active">
						<td width="25%" align="center"><strong>${cart.detail.jingDians[status.index].jingdianTitle}风景观光区</strong></td>
						<td width="25%" align="center"><strong>${cart.order_number}个</strong></td>
						<td width="25%" align="center"><strong>${cart.detail.jingDians[status.index].jingdianPrice}￥</strong></td>
						  
						<td width="25%" align="center">  
							<button type="button" class="btn btn-danger">
								<a
									href="${ pageContext.request.contextPath}/SettingServlet?orderno=${cart.order_no}"
									style="color: white;">取消</a>
							</button>
						</td>
					</tr>
				</c:forEach>
				<%
					List<Order> list = (List<Order>) request.getAttribute("userCart");
					int a = 0;

					for (int i = 0; i < list.size(); i++) {
						a += list.get(i).getDetail().getJingDians().get(i).getJingdianPrice();
					}
				%>

				<tr>
					<td align="center" width="33%"><strong>总计</strong></td>

					<td align="center" width="33%"><strong><%=list.size()%>个</strong></td>

					<td align="center" width="33%"><strong><%=a%>￥</strong></td>
					<td align="center" width="33%"><button class="btn btn-primary">
							 <a href="${ pageContext.request.contextPath}/PayServlet?money=<%=a %>"
								style="color: white;">去付款</a>

						</button></td>

				</tr>

			</table>
		</div>
		<!-- /table-responsive -->


		<div class="text-right"></div>

		<div class="well m-t">
			<strong>注意：</strong> 请在30日内完成付款，否则订单会自动取消。
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