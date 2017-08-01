<%@page import="javax.swing.text.Document"%>
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
<script type="application/x-javascript">

	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<%
	int pageNo = 1;
	int pageSize = 2;
	PageModel pageModel = (PageModel) request.getAttribute("pageModel");
%>
<!-- //for-mobile-apps -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
</head>

<body style="background-color: #eae8dc">
	<!-- banner -->
	<div class="container">
		<!-- header -->
		<div class="header">
			<div class="clearfix"></div>
			<div class="header-bottom">
				<div class="header-bottom-left">
					<a href="index.html">爱Go</a>
				</div>
				<div class="header-bottom-right">
					<span class="menu">菜单</span>
					<ul class="nav1">
						<li class="cap"><a
							href="${pageContext.request.contextPath }/GoIndexServlet?pageNo=1&pageSize=2&jingdianName=">主页</a></li>
						<li><a href="${pageContext.request.contextPath }/CartServlet?jingdianNo=${jingDian.jingdianNo}">我的预定</a></li>
						<li><a href="gallery.jsp">景色欣赏</a></li>
						<c:if test="${ not empty  user }">
							<li><a>${user.username}&nbsp;欢迎您</a></li>
							<li><a
								href="${pageContext.request.contextPath }/LayoutServlet">退出</a></li>
						</c:if>
						<c:if test="${empty user}">
						<li>	<a href="${pageContext.request.contextPath }/LoginServlet">请您登陆</a></li>
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
		<!-- //header -->
		<!-- Slider-starts-Here -->
		<script src="js/responsiveslides.min.js"></script>
		<script>
			// You can also use "$(window).load(function() {"
			$(function() {
				// Slideshow 4
				$("#slider3").responsiveSlides({
					auto : true,
					pager : true,
					nav : false,
					speed : 500,
					namespace : "callbacks",
					before : function() {
						$('.events').append("<li>before event fired.</li>");
					},
					after : function() {
						$('.events').append("<li>after event fired.</li>");
					}
				});

			});
		</script>
		<!--//End-slider-script -->


		<ul class="rslides" id="slider3">

			<c:forEach items="${gonggaoList }" var="gonggao">
				<div
					style="height: 550px;width: 100%;background: url('${gonggao.gongGaoPic }');">


					<div class="banner">
						<div class="jumbotron banner-info">

							<h1>${gonggao.gongGaoTitle }</h1>
							<p>${gonggao.gongGaoContent }</p>
							<p>${gonggao.gongGaoTime }</p>
							<a class="btn btn-primary btn-lg"
								href="${pageContext.request.contextPath }/SingleGonggaoServlet?gonggaoNo=${gonggao.gongGaoNo }"
								role="button">查看详情</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</ul>
	</div>

	<!-- //banner -->
	<div class="copyrights">
		Collect from <a href="http://www.cssmoban.com/">网页模板</a>
	</div>
	<!-- banner-bottom -->
	<div class="banner-bdy">
		<div class="container">
			<div class="banner-bottom" id="events">
				<div class="banner-bottom-grids">
					<div class="col-md-4 banner-bottom-grid">
						<img src="images/6.jpg" alt=" " />
						<div class="more">
							<a href="#">More</a>
						</div>
					</div>
					<div class="col-md-4 banner-bottom-grid">
						<img src="images/7.jpg" alt=" " />
						<div class="more">
							<a href="#">More</a>
						</div>
					</div>
					<div class="col-md-4 banner-bottom-grid">
						<img src="images/5.jpg" alt=" " />
						<div class="more">
							<a href="#">More</a>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>

				<div class="features">
					<form action="${pageContext.request.contextPath }/GoIndexServlet">

						<div class="input-group col-md-3"
							style="margin-top: 0px positon:relative; margin-left: 30px;"
							align="right">
							<input type="hidden" class="form-control" value="1" name="pageNo"
								id="pageNo" /> <input type="hidden" class="form-control"
								value="2" name="pageSize" id="pageSize" /> <input type="text"
								class="form-control" placeholder="请输入景点名称" name="jingdianName"
								id="jingdianName" /> <span class="input-group-btn">
								<button class="btn btn-info btn-search" type="submit">搜索</button>
							</span>
						</div>

						<c:forEach items="${pageModel.list }" var="jingdian" begin="0"
							end="1">
							<div class="col-md-9 features-left">
								<h3>${jingdian.jingdianTitle}</h3>
								<div class="features-left-grids">
									<div class="col-md-4 features-left-grid">
										<a
											href="${pageContext.request.contextPath }/SingleJingDianServlet?jingdianNo=${jingdian.jingdianNo}"><img
											src="${jingdian.jingdianPic }" alt=" " /></a>
									</div>
									<div class="col-md-8 jumbotron features-left-grid1">
										<h4>
											<a
												href="${pageContext.request.contextPath }/SingleJingDianServlet?jingdianNo=${jingdian.jingdianNo}">${jingdian.jingdianTitle }</a>
										</h4>
										<p>${jingdian.jingdianDetail }</p>
										<p>
											<a class="btn read btn-primary btn-lg"
												href="${pageContext.request.contextPath }/SingleJingDianServlet?jingdianNo=${jingdian.jingdianNo}"
												role="button">查看详情</a>
										</p>
									</div>
								</div>
							</div>

						</c:forEach>

						<div class="col-md-3 features-right"></div>
						<ul class="pagination"
							style="float: right; margin-right: 50px; width: 500px;">
							
							<li><a>
									当前第&nbsp;<%=pageModel.getPageNo()%>页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</a></li>
							<li><a
								href="${pageContext.request.contextPath }/GoIndexServlet?pageNo=<%=pageModel.getTopPageNo()%>&pageSize=2&jingdianName= <%= request.getParameter("jingdianName") %>">首页</a></li>
							<li><a
								href="${pageContext.request.contextPath }/GoIndexServlet?pageNo=<%=pageModel.getPreviousPageNo()%>&pageSize=2&jingdianName=<%= request.getParameter("jingdianName") %>">
									上一页</a></li>
							<li><a
								href="${pageContext.request.contextPath }/GoIndexServlet?pageNo=<%=pageModel.getNextPageNo()%>&pageSize=2&jingdianName=<%= request.getParameter("jingdianName") %>">
									下一页 </a></li>
							<li><a
								href="${pageContext.request.contextPath }/GoIndexServlet?pageNo=<%=pageModel.getBottomPageNo()%>&pageSize=2&jingdianName=<%= request.getParameter("jingdianName") %>">尾页
							</a></li>
						</ul>
						<div class="clearfix"></div>
				</div>

			</div>

			<!-- //banner-bottom -->
			<!-- slider -->
			<div class="sliderfig">
				<ul id="flexiselDemo1">
					<li>
						<div class="sliderfig-grids">
							<div class="sliderfig-grid">
								<img src="images/4.jpg" alt=" " />
								<div class="slider-text">
									<p>Et Quas Molestias Officia</p>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="sliderfig-grids">
							<div class="sliderfig-grid">
								<img src="images/5.jpg" alt=" " />
								<div class="slider-text">
									<p>Et Quas Molestias Officia</p>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="sliderfig-grids">
							<div class="sliderfig-grid">
								<img src="images/6.jpg" alt=" " />
								<div class="slider-text">
									<p>Et Quas Molestias Officia</p>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="sliderfig-grids">
							<div class="sliderfig-grid">
								<img src="images/7.jpg" alt=" " />
								<div class="slider-text">
									<p>Et Quas Molestias Officia</p>
								</div>
							</div>
						</div>
					</li>
				</ul>
				<script type="text/javascript">
					$(window).load(function() {
						$("#flexiselDemo1").flexisel({
							visibleItems : 4,
							animationSpeed : 1000,
							autoPlay : true,
							autoPlaySpeed : 3000,
							pauseOnHover : true,
							enableResponsiveBreakpoints : true,
							responsiveBreakpoints : {
								portrait : {
									changePoint : 480,
									visibleItems : 2
								},
								landscape : {
									changePoint : 640,
									visibleItems : 3
								},
								tablet : {
									changePoint : 768,
									visibleItems : 3
								}
							}
						});

					});
				</script>
				<script type="text/javascript" src="js/jquery.flexisel.js"></script>
			</div>
		</div>
	</div>
	<!-- //slider -->
	<!-- footer -->
	<div class="footer">
		<p>
			Copyright &copy; 2015.Company name All rights reserved.More Templates
			<a href="http://www.cssmoban.com/" target="_blank" title="">侯雪枫</a> -
			Collect from <a href="http://www.cssmoban.com/" title=""
				target="_blank">侯雪枫</a>
		</p>
	</div>
	<!-- //footer -->
	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			 */

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<!-- //here ends scrolling icon -->
</body>
</html>