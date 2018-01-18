<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="res/css/bootstrap.css">
<link rel="stylesheet" href="res/css/animate.min.css">
<link rel="stylesheet" href="res/css/main.css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>

	<section id="nav">
	<div class="container">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-3">
				<a class="btn btn-primary">第一步 我的购物车</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-default">第二步 填写核对订单信息</a>
			</div>
			<div class="col-sm-3">
				<a class="btn btn-default">第三步 成功提交订单</a>
			</div>
			<div class="col-sm-1"></div>
		</div>
	</div>
	</section>
	<hr />
	<form action="adminorder/orderCheck.shtml" method="post" id="f1">
		<section id="shoppingcart">
		<div class="container">
			<table class="table">
				<tr>
					<th width="6%">全选 &nbsp;<input type="checkbox" id="all"
						onclick="checkboxall(this)" /></th>
					<th width="50%">商品</th>
					<th>单价（元）</th>
					<th>数量</th>
					<th>小计</th>
					<th>操作</th>
				</tr>
				<c:choose>
				<c:when test="${cars!=null}">
				<c:forEach var="car" items="${cars}">
				<tr>
					<td>
						<input type="hidden" name="goodsDescs" value="${car.value["goods_id"]},${car.value["goods_name"]},${car.value["goods_price"]},${car.value["goods_url"]}"/>
						<input type="checkbox" name="goodsIds" id="goodsIds" value="${car.value["goods_id"]}" onchange="cs(${car.value["goods_price"]},${car.value["goods_id"]},this.checked)"  />
					</td>
					<td>
						<a href="html/${car.value["goods_id"]}.html">
							<img src="${imgurl}${car.value["goods_url"]}"> ${car.value["goods_name"]}
						</a>
					</td>
					<td>
							${car.value["goods_price"]}
					</td>
					<td>
						<input type="text" name="orderNumber" class="number"
							   id="number_${car.value["goods_id"]}"
							   onchange="total(${car.value["goods_price"]},this.value,${car.value["goods_id"]})"
						value="1">
					</td>
					<td>
						￥<span class="total" id="total${car.value["goods_id"]}">${car.value["goods_price"]}</span>
					</td>
					<td>
						<a href="#">删除</a>
					</td>
				</tr>
				</c:forEach>
				</c:when>
				<c:otherwise>
				<tr>
					<td colspan="6">
						<h1>
							购物车里面空荡荡的！<a href="front/list.shtml">请选择商品</a>
						</h1>
					</td>
				</tr>
				</c:otherwise>
				</c:choose>

			</table>
			<hr />
			<div class="footer" style="display: ${cars==null?'none':'block'};">
				<div class="row">
					<div class="col-sm-6">
						<a href="javascript:void(0)" onclick="del()">删除选中商品</a>
					</div>
					<div class="col-sm-6" align="right">
						<c:if test="${cars!=null}">
						已选中<span style="color: red;" id="che_goods">0</span>
						</c:if>

						件商品 &nbsp; 总价：￥ <span class="price">0.00</span> <input
							type="submit" class="btn btn-danger" value="去结算"> <a
							class="btn btn-info" href="front/list.shtml">继续购物</a>
					</div>
				</div>

			</div>
			<hr />
		</div>

		</section>
	</form>



	<footer>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<p>版权所有：天狗</p>
			</div>
		</div>
	</div>
	</footer>
	<script type="text/javascript" src="res/common/js/jquery.js"></script>

	<script type="text/javascript">
		function cs(price,id,che){
            var sum = 0;
            sum = parseFloat($(".price").html());
            var num = $("#number_"+id).val();
		    if(che==true){
                sum = sum+parseFloat(num*price);
			}else{
                sum = sum-parseFloat(num*price);
			}
            $(".price").html(sum);
		    //获取选中商品个数
           $("#che_goods").html($("input[name='goodsIds']:checked").length);

		}
		function total(price,num,id){
			var tal = "#total"+id;
			$(tal).html(price*num);
			init();

		}
		
		function init(){
			var sum = 0;
			$(".total").each(function(){
				sum = sum+parseFloat($(this).text());
			});
			$(".price").html(sum);
		}
		
		//init();
		
		
		function checkboxall(che){
			var ids = document.getElementsByName("goodsIds");
			for(var i=0;i<ids.length;i++){
				ids[i].checked = che.checked;
			}
		}
		
	
		function del(){
			if (confirm("您确定删除商品吗？")) {
			var form = document.getElementById("f1");
			form.action="front/deleteGoods.shtml";
			form.submit();//提交表单
			}
		}
		</script>

</body>
</html>