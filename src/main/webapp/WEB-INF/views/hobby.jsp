<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css"
	href="/user_springmvc_hibernate/css/style.css">
<div id="content_hobby">
	<div class="hobby">
		<button class="add_hobby">新增爱好</button>
	</div>
	<div class="user">
		<table align="left" width="100%" border="1" rules="all">
			<thead bgcolor="#CCFFFF">
				<tr height="40px">
					<td>序号</td>
					<td>爱好名称</td>
					<td>创建时间</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${hobby_list }" var="temp" varStatus="vs">
					<tr height="40px">
						<td>${temp.id }</td>
						<td>${temp.hobby }</td>
						<td>${temp.createDate }</td>
						<td><a
							href="http://localhost:8080/user_springmvc_hibernate/hobby/remove?id=${temp.id }">删除</a>&nbsp;<a
							href="http://localhost:8080/user_springmvc_hibernate/hobby/to_edit?id=${temp.id }">编辑</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="#">上一页</a> <a href="#">1</a> <a href="#">下一页</a>
	</div>
	<script type="text/javascript"
		src="/user_springmvc_hibernate/plugins/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="/user_springmvc_hibernate/js/hobby.js"></script>