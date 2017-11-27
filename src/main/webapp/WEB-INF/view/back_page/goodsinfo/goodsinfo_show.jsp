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
<title>商品添加</title>
<link href="res/css/bootstrap.min.css" rel="stylesheet" />
<link href="res/css/jquery.validator.css" rel="stylesheet" />
<script type="text/javascript" src="res/js/jquery.min.js"></script>
<script type="text/javascript" src="res/js/bootstrap.min.js"></script>
<script type="text/javascript" src="res/js/jquery.validator.js"></script>
<script type="text/javascript" src="res/js/zh_CN.js"></script>
<script src="res/common/js/jquery.form.js"></script>
<script type="text/javascript" src="res/ckeditor/ckeditor.js"></script>

</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>商品管理</li>
			<li>商品添加</li>
		</ul>
	</div>
	<form id="goodsform" action="goods/add.do" class="form-horizontal" method="post"
		data-validator-option="{theme:'yellow_top',stopOnError:true}"
		enctype="multipart/form-data">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品名称</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${goods.goods_name}</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品价格</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${goods.goods_price}</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row" style="height: 14em">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品图片</label>
					<div class="col-xs-3 ">
						<img src="${imgurl}${goods.goods_url}" width="100" height="100"/>
					</div>
				</div>
			</div>
		</div>
		<!--结束2 -->


		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">
			商品详情 <span id="errorinfo" style="color: red; margin-left: 50px"></span>

		</h5>
		<!-- 开始5 -->
		<div class="row">
			<div class="col-xs-12">
				<div class="form-group ">
				<div class="col-xs-1"></div>
					${goods.goods_desc}
				</div>
			</div>

		</div>
		<!--结束5 -->

		<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<a href="goods/loadupdate.do?goodsId=${goods.goods_id}" class="btn btn-info">修改商品</a>&nbsp;&nbsp;<a href="goods/list.do" class="btn btn-warning">返回上一级</a>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		var info ="${info}";
		if(info.length>1){
			alert(info);
		}
	
	
		function uploadImg() {
			var options={
					url:"goods/upload.do",
					dataType:"json",
					type:"post",
					success:function(data){
						//alert(data.path+"  "+data.url);
						$("#goodsUrl").val(data.path);
						$("#shopimg").attr("src",data.url);
					}	
			};
			
			$("#goodsform").ajaxSubmit(options);
		}
	</script>

</body>
</html>