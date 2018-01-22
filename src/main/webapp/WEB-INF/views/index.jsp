<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<link rel="stylesheet" type="text/css"
	href="/user_springmvc_hibernate/css/style.css">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</head>

<body>
	<div id="top">
		<div class="img">
			<img src="/user_springmvc_hibernate/images/logo.jpg">
		</div>
		<div class="administer">用户管理系统</div>
		<div class="help">
			<a>帮助</a>&nbsp;&nbsp;<a>退出</a>
		</div>
	</div>
	<div id="menu">
		<hr />
		<a class="list"
			href="http://localhost:8080/user_springmvc_hibernate/user/index">用户管理</a>
		<hr />
		<button class="job">职业管理</button>
		<hr />
		<button class="hobby">爱好管理</button>
		<hr />
		<div class="avatar">
			<img src="/user_springmvc_hibernate/images/avatar.jpg" width="80%">
			<p>当前登录用户</p>
		</div>
	</div>
	<div id="content">
		<div class="edit">
			<button class="add">用户新增</button>
			<button>批量删除</button>
			<button>导出用户</button>
			<div class="search">
				<form action="#" method="post" id="form">
					用户名称： <input type="" name="">
					<button onclick="go(1)">查询</button>
					<button type="reset">重置</button>
				</form>
			</div>
		</div>
		<div class="user">
			<table align="left" width="100%" border="1" rules="all">
				<thead bgcolor="#CCFFFF">
					<tr height="40px">
						<td><input type="checkbox" /></td>
						<td>用户名称</td>
						<td>职业</td>
						<td>邮箱</td>
						<td>性别</td>
						<td>爱好</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="temp" varStatus="vs">
						<tr height="40px">
							<td><input type="checkbox" /></td>
							<td>${temp.userName }</td>
							<td>${temp.job }</td>
							<td>${temp.email }</td>
							<td>${temp.sex?"男":"女" }</td>
							<td>${temp.hobby }</td>
							<td><a href="/user_springmvc_hibernate/user/to_edit?id=${temp.id }" class="editUser">编辑</a> 
								&nbsp;<a href="/user_springmvc_hibernate/user/remove?id=${temp.id }">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="7">
							<ul class="pagination">
								<li class="page-item"><a class="page-link"
									href="javascript:go(${pageInfo.prePage})">Previous</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item active"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link"
									href="javascript:go(${pageInfo.nextPage})">Next</a></li>
							</ul>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	<script type="text/javascript"
		src="/user_springmvc_hibernate/plugins/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="/user_springmvc_hibernate/js/common.js"></script>
	<script type="text/javascript"
		src="/user_springmvc_hibernate/js/job.js"></script>
	<script type="text/javascript"
		src="/user_springmvc_hibernate/js/hobby.js"></script>
	<script type="text/javascript">
	$(function(){
		function go(page) {
			$("#pageNum").val(page)
			$("#form")
					.attr("action",
							"http://localhost:8080/user_springmvc_hibernate/user/index");
			$("#form").submit();
		}	
	})
	</script>
</body>
</html>