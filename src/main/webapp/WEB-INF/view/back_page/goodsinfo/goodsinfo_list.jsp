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
<title>商品查询</title>
<link href="res/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>商品管理</li>
			<li>商品查询</li>
		</ul>
	</div>
	<form action="goods/list.do" class="form-inline" method="post">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>商品名称:</label> <input type="text" name="goodsName"
					class="form-control" placeholder="请输入商品名称" />
			</div>
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
			<div align="center"> 商品信息<b>${info }!</b></div>
		</div>
	</div>
		</div>
		<div class="row" style="padding: 15px;">
			<table class="table table-hover table-condensed">
				<tr>
					<th>商品编号</th>
					<th>商品名称</th>
					<th>商品图片</th>
					<th>商品价格</th>
					<th>商品状态</th>
					<td>操作</td>
				</tr>
				<c:forEach items="${list }" var="goods">
					<tr>
						<td>${goods.goods_id}</td>
						<td><a href="goods/goodsinfo.do?goodsId=${goods.goods_id }">${goods.goods_name }</a></td>
						<td><img src="${imgurl}${goods.goods_url }" height="50"
							width="100" /></td>
						<td>${goods.goods_price }</td>
						<td>${goods.goods_state=='-1'?'未上架':'' }
						${goods.goods_state=='1'?'销售中':'' }
						${goods.goods_state=='0'?'已下架':'' }
						</td>
						<td><a href="goods/loadupdate.do?goodsId=${goods.goods_id }">修改</a>
							<a href="goods/upgoods.do?goodsId=${goods.goods_id }" style="display:${goods.goods_state =='-1'?'block':'none'};" >上架</a>
							<a href="javascript:void(0)" style="display:${goods.goods_state =='1'?'block':'none'};" onclick="del('${goods.goods_id }')">下架</a>
							<a href="goods/upgoods.do?goodsId=${goods.goods_id }" style="display:${goods.goods_state =='0'?'block':'none'};" >上架</a>
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

	<script type="text/javascript">
		function del(id) {
			if (confirm("您确定下架吗")) {
				window.location = "goods/delete.do?goodsId=" + id;
			}

		}
	</script>
</body>
</html>