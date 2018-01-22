<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/user_springmvc_hibernate/css/hobby.css">
<div class="add_name">
	<h4>
		修改职业信息
		</h2>
		<form action="/user_springmvc_hibernate/job/do_hobby" method="post" id="job_form">
			<input type="text" name="id" value="${jobDemo.id }" hidden="hidden"/>
			<div class="name">
				<label for="hobby_name">职业名称：</label> 
				<input type="text" name="hobby" id="hobby_name" placeholder="爱好名称" value="${jobDemo.job }" required="required">
			</div>
			<hr />
			<div class="control">
				<button type="submit" class="btn btn-primary">添加</button>
				<button type="reset" class="btn btn-secondary">重置</button>
				<button type="button" class="btn btn-info">返回</button>
			</div>
		</form>
</div>