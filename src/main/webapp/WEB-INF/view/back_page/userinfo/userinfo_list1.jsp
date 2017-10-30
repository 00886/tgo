<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%--<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>用户管理-用户查询</title>
<link href="res/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>用户查询</li>
		</ul>
	</div>
	<form action="user/list.do" class="form-inline" method="post">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>姓名:</label> <input type="text" name="userName"
					class="form-control" placeholder="请输入姓名" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> <a
				href="user/loadadd.do" class="btn btn-success">添加用户</a>
		 <input type="button" value="导入用户信息"  class="btn btn-primary" data-toggle="modal" data-target="#myModal"/> 
		</div>

		<div class="row" style="padding: 15px;">
			<table class="table table-hover table-condensed">
				<tr>
					<th>用户编号</th>
					<th>用户姓名</th>
					<th>用户性别</th>
					<th>电话号码</th>
					<th>密码</th>
					<th>用户类型</th>
					<td>操作</td>
				</tr>
				<c:forEach items="${list }" var="user">
					<tr>
						<td>${user.userId }</td>
						<td>${user.userName }</td>
						<td>${user.userSex }</td>
						<td>${user.userPhone }</td>
						<td>${user.userPw }</td>
						<td>${user.userType }</td>
						<td><a href="user/loadupdate.do?userId=${user.userId }">修改</a> 
						<a href="javascript:void(0)" onclick="del('${user.userId}')">删除</a>
						
						</td>
					</tr>
				</c:forEach>

			</table>
			<div align="right" style="padding: 10px;">
				<pg:pager items="${total }" url="user/list.do" maxIndexPages="3"
					export="currentPageNumber=pageNumber" scope="request">
					<%-- <pg:param name="userName" value="${userName }" /> --%>

					<jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
				</pg:pager>
			</div>
		</div>
	</form>
	<form action="user/imuser.do" method="post" enctype="multipart/form-data">
<!-- 导入EXCELdiv  开始-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">用户信息——EXCEL导入</h4>
      </div>
      <div class="modal-body">
      	<input type="file" name="upfile"/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="submit" class="btn btn-primary">导入数据</button>
      </div>
    </div>
  </div>
</div>
<!-- 导入EXCELdiv  结束-->
</form>
	<script type="text/javascript">
		function del(userId){
			if(confirm("您确定删除吗")){
				window.location="user/delete.do?userId="+userId;
			}
			
			
		}
	
	</script>
</body>
</html>