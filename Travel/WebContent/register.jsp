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
<script type="text/javascript">
	function changeImage() {
		$("#myimg").src="${pageContext.request.contextPath }/RegisterServlet?time="
			+ new Date().getTime();
		}
	
</script>
<!-- 随机变化 -->

<script type="text/javascript">
	function register() {
		var readerno = $("#user").val();
		var readername = $("#pass").val();
		var yanzhengcode = $("#yanzhengma").val();
		var truename = $("#truename").val();
		$.ajax({
			url : "${pageContext.request.contextPath }/RegisterRegex", //提交的action
			type : "post",
			dataType : "json",
			data : {
				"user" : readerno,
				"pass" : readername,
				"truename" : truename,
				"yanzhengma" : yanzhengcode
			},
			error : function(request) {
				console.log(request);
			},
			success : function(json) {
				if (json.success == false) {
					$("#toast").html(json.msg);
					$("#toast").css("color", "red")
					$("#user").focus(function() {
						$("#toast").hide();
					});
					$("#pass").focus(function() {
						$("#toast").hide();
					});
					$("#yanzhengma").focus(function() {
						$("#toast").hide();
					});
					$("#truename").focus(function() {
						$("#toast").hide();
					});
					$("#toast").show();
				} else {
					location.href = "${pageContext.request.contextPath }/LoginServlet";
				}
			}
		});
	}
</script>

<body>
	<div class="page-container">
		<h1>注册</h1>
		<form>
		<div  id="toast" style="height: 35px; width : 256px;"></div>
			<input type="number" name="username" class="username" placeholder="用户名"
				id="user" /> <input type="password" name="password"
				class="password" placeholder="密码" id="pass" /> <input
				type="text" name="truename" class="username" placeholder="真实姓名"
				id="truename" />
				<div style="width: 300px;">
				<input type="text" name="text"
				placeholder="输入左侧验证码" style="width: 150px" id="yanzhengma" /> 
				<img id="myimg"
				src="${pageContext.request.contextPath }/RegisterServlet"
				style="margin-top: 20px; "/>
				
				
				<button class="btn btn-info" onclick="changeImage()" style="width: 130px; float: right;">点击换一张</button>
			</div>
			
			<button type="button" onclick="register()">注册</button>
			<!-- 通过按钮点击切换图片使用jquerydom事件 
			注意：这里只能使用button
			-->
		</form>
	</div>
	<!-- Javascript -->
	<script src="js/jquery-1.8.2.min.js"></script>
	<script src="js/supersized.3.2.7.min.js"></script>
	<script src="js/supersized-init.js"></script>
</body>

</html>


