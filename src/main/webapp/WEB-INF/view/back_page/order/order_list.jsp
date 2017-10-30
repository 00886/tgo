<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>订单查询</title>
<link href="res/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>订单管理</li>
			<li>订单查询</li>
		</ul>
	</div>
	<form action="order/list.do" class="form-inline" method="post">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<!-- <div class="form-group">
				<label>商品名称:</label> <input type="text" name="goodsName"
					class="form-control" placeholder="请输入商品名称" />
			</div> -->
			<input type="submit" class="btn btn-danger" value="查询">
		</div>

		<div class="row">
			<div class="container">
			
		
		<div class="alert alert-danger alert-dismissible" role="alert"
			style="margin: 5px;display:${info ==null?'none':'block'};">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
	
		</div>
	</div>
		</div>
		<div class="row" style="padding: 15px;">
<table class="table">
		<tr>
			<th>订单编号</th>
			<th>订单时间</th>
				<th> 购买人</th>
			<th>收货人</th>
			<th>总金额</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="om">
		<tr>
			<td>${om.order_id }</td>
			<td>${om.order_time }</td>
			<td>${om.user_name }</td>
			<td>${om.consignee_name }</td>
			<td>${om.order_total }</td>
			<td><a href="javascript:void(0)">详情</a></td>
		</tr>
		</c:forEach>		
	</table>
	
		</div>
	</form>

	<script type="text/javascript">
		function del(id) {
			if (confirm("您确定下架吗")) {
				window.location = "goods/delete.do?goodsId=" + id;
			}

		}
	</script>
</body>
</html>