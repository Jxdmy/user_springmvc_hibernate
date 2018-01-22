<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户注册</title>
<link rel="stylesheet" href="/user_springmvc_hibernate/css/style.css">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container_form">
		<div id="form-con">
			<header>
				<h1>新增&编辑用户信息</h1>
			</header>
			<form id="testForm" action="/user_springmvc_hibernate/user/save"
				method="post">
				<input type="Date" hidden="hidden"
					value="<fmt:formatDate value="${newDate}" pattern="yyyy-MM-dd"/>" class="input_value" name="createDate"/>
            <div class="input ">
                <label class="input-label">用户名称：</label>
                <input id="username" name="userName" type="text" class="input_value" placeholder="请输入您的用户名！">
            </div>
            <div class="input">
                <label class="input-label">登录密码：</label>
                <input id="password" name="password" type="password" class="input_value" placeholder="请输入您的密码！">
            </div>
            <div class="input">
                <label class="input-label">重复密码：</label>
                <input id="repeatPassword" name="repeatPassword" type="password" class="input_value" placeholder="请输入您的确认密码！">
            </div>
            <div class="input">
                <label class="input-label">电子邮箱：</label>
                <input id="email" name="email" type="email" class="input_value" placeholder="请输入您的邮箱！">
            </div>
            <div class="input">
                <label class="input-label">出生日期：</label>
                <input id="Date" name="birthDay" type="Date" class="input_value" placeholder="请输入您的出生日期！">
            </div>
            <div class="input">
                <label class="gender">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
                <div class="radio-gender">
                    <input type="radio" name="sex" id="male" value="1" checked="checked" required>
                    <label for="male">男</label>
                    <input type="radio" name="sex" id="female" value="0" required>
                    <label for="female">女</label>
                </div>
            </div>
            <div class="form-group" id="select">
                <label for="job" class="job-label">职业</label>
                <select class="form-control" id="job" name="job">
                    <c:forEach items="${job_list }" var="temp">
                		<option value="${temp.job }">${temp.job }</option>  
                	</c:forEach> 
                </select>
                <label for="hobby">爱好</label>
                <select multiple class="form-control" id="hobby" name="hobby">
                    <c:forEach items="${hobby_list }" var="temp">
                		<option value="${temp.hobby }">${temp.hobby}</option>  
                	</c:forEach> 
                </select>
            </div>
            <br>
            <hr>
            <div class="control">
                <button type="submit" class="btn btn-primary">添加</button>
                <button type="reset"  class="btn btn-secondary">重置</button>
                <button type="button" class="btn btn-info">返回</button>
            </div>
        </form>
        <footer>Copyright&copy;轻实训版权所有</footer>
    </div>
    <div id="head">
         <!-- 文件上传必须 method="
					post" enctype="multipart/form-data"--> <img id="image"
					src="/user_springmvc_hibernate/images/avatar.jpg" width="300"
					height="300" /> <input type="file" name="file" id="file" /> <input
					type="button" value="上传" onclick="upload()" />
		</div>
	</div>
	<script type="text/javascript"
		src="/user_springmvc_hibernate/plugins/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="/user_springmvc_hibernate/js/common.js"></script>
	<script type="text/javascript">
		function upload() {
			//js file 对象
			var file = $("#file")[0].files[0];

			//js form
			var form = new FormData();
			form.append("file", file);

			//jquery ajax
			var opt = {
				url : "http://localhost:8080/user_springmvc_hibernate/user/do_upload",
				type : "post",
				contentType : false,
				processData : false,
				data : form,
				success : function(data) {
					var json = eval("(" + data + ")");
					$("#image").attr("src",
							"/user_springmvc_hibernate/user/" + json.url);
				}
			};
			$.ajax(opt);
		}
	</script>

</body>
</html>