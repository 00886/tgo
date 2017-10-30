<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>用户管理-用户添加</title>
<link href="res/css/bootstrap.min.css" rel="stylesheet" />
<link href="res/css/jquery.validator.css" rel="stylesheet" />
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript"
	src="res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="res/js/jquery.validator.js"></script>
<script type="text/javascript" src="res/js/zh_CN.js"></script>
</head>
<body>
<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>用户添加</li>
		</ul>
	</div>
<form action="user/add.do" class="form-horizontal" method="post"
data-validator-option="{theme:'yellow_top',stopOnError:true}"
>
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户姓名</label>
					<div class="col-xs-9 ">
						<input type="text" name="userName" data-rule="用户姓名:required;" class="form-control" placeholder="请输入用户姓名" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户类型</label>
					<div class="col-xs-5 ">
						<select class="form-control" name="userType">
							<option value="普通用户">普通用户</option>
							<option value="管理员">管理员</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户性别</label>
					<div class="col-xs-3 ">
						<select class="form-control" name="userSex">
							<option value="保密">保密</option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</div>
				</div>
			</div>

		</div>
		<!--结束2 -->


		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">账号信息
			
			<span id="errorinfo"  style="color: red;margin-left: 50px"></span>
			
			</h5>
		<!-- 开始5 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">手机号码</label>
					<div class="col-xs-9">
						<input type="text" class="form-control" id="userPhone" data-rule="手机号码:required;" name="userPhone" placeholder="请输入手机号码" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户密码</label>
					<div class="col-xs-9 ">
						<input type="text" class="form-control" data-rule="用户密码:required;" name="userPw" placeholder="请输入用户密码" />
					</div>
				</div>
			</div>
		</div>
		<!--结束5 -->

		<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="保存用户" /> <input
					type="reset" class="btn btn-danger" value="重置信息" />
			</div>
		</div>
	</form>
	
	<script type="text/javascript">
		$(function(){
			$("#userPhone").blur(function(){
				//ajax JSON
				$.post('user/userajax.do',{userPhone:$(this).val()},function(str){
                   //var o = jQuery.parseJSON(str);
				     //$("#errorinfo").html(str.msg);
                    $("#errorinfo").html(str);
				},"text");
			});
		});
	</script>
</body>
</html>