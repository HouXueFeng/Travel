<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8">
<title>登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- CSS -->
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/supersized.css">
<link rel="stylesheet" href="css/style.css">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
</head>
<script src="js/jquery-1.8.2.min.js"></script>






<script type="text/javascript">
	$(function() {
		$("#user").focus(); //输入焦点
		$("#user").blur(function() {
			var readerno = $("#user").val();
			var pass = $("#pass").val();

			$.ajax({
				url : "${pageContext.request.contextPath }/LoginRegex", //提交的action
				type : "post",
				dataType : "json",
				data : {
					"user" : readerno,
					"pass" : pass

				},
				error : function(request) {
					console.log(request);
				},
				success : function(json) {
					if (json.success == 1) {
						$("#toast").html(json.msg);
						$("#toast").css("color", "red")
						$("#user").focus(function() {
							$("#toast").hide();
						});
						$("#pass").focus(function() {
							$("#toast").hide();
						});
						$("#toast").show();
					}
					if (json.success == 2) {
						$("#toast").html(json.msg);
						$("#toast").css("color", "red")
						$("#user").focus(function() {
							$("#toast").hide();
						});
						$("#pass").focus(function() {
							$("#toast").hide();
						});
						$("#toast").show();
					}
				}
			});
		})

	})
</script>

 <script type="text/javascript">
	function login() {
		var readerno = $("#user").val();
		var readername = $("#pass").val();
		$
				.ajax({
					url : "${pageContext.request.contextPath }/LoginRegex", //提交的action
					type : "post",
					dataType : "json",
					data : {
						"user" : readerno,
						"pass" : readername,
					},
					error : function(request) {
						console.log(request);
					},
					success : function(json) {
						if (json.success == 3) {
							$("#toast").html(json.msg);
							$("#toast").css("color", "red")
							$("#user").focus(function() {
								$("#toast").hide();
							});
							$("#pass").focus(function() {
								$("#toast").hide();
							});
							$("#toast").show();
						} else if (json.success == 4){
							location.href = "${pageContext.request.contextPath }/GoIndexServlet?pageNo=1&pageSize=2&jingdianName=";
						}
					}
				});
	}
</script> 
<body>
	<div class="page-container">
		<h1>登录</h1>
		<form>
			<div id="toast" style="height: 35px; width: 256px;"></div>
			<input type="text" name="username" class="username" placeholder="用户名"
				id="user" /> <input type="password" name="password"
				class="password" placeholder="密码" id="pass" /> <br> <br>
			<br> <br>
			<button type="button" onclick="login()">登录</button>
		</form>
	</div>
	<!-- Javascript -->
	<script src="js/supersized.3.2.7.min.js"></script>
	<script src="js/supersized-init.js"></script>
</body>

</html>


