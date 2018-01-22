<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" href="/user_springmvc_hibernate/css/common_form.css">
</head>

<body>
	<header>
		<div class="header-line"></div>
	</header>
	<div class="content">
		<img class="content-logo"
			src="/user_springmvc_hibernate/images/login.png" alt="logo">
		<h1 class="content-title">登录</h1>
		<div class="content-form">
			<form method="post" action="http://localhost:8080/user_springmvc_hibernate/admin/do_login" id="testForm">
				<div id="change_margin_1">
					<input class="user" type="text" name="loginName"
						placeholder="请输入用户名">
				</div>
				<!-- input的value为空时弹出提醒 -->
				<p id="remind_1"></p>
				<div id="change_margin_2">
					<input class="password" type="password" name="password"
						placeholder="请输入密码">
				</div>
				<!-- input的value为空时弹出提醒 -->
				<p id="remind_2"></p>
				<div id="change_margin_3">
					<input class="content-form-signup" type="submit" value="登录">
				</div>
			</form>
		</div>
		<div class="content-login-description">没有账户？</div>
		<div>
			<a class="content-login-link" href="register.html">注册</a>
		</div>
	</div>
	<script type="text/javascript"
		src="/user_springmvc_hibernate/plugins/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="/user_springmvc_hibernate/js/common_form_test.js"></script>
</body>

</html>