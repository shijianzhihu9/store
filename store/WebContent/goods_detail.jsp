<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Date"%>
<%@page import="utils.Stoptime" %>
<%@page import="model.Goods" %>
<%@page import="listener.StoptimeListener" %>
<%@page import="utils.Ipandtime" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>商品详情</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/flexslider.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/layer/layer.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/cart.js"></script>
	<script>
		$(function() {
		  $('.flexslider').flexslider({
			animation: "slide",
			controlNav: "thumbnails"
		  });
		});
	</script>
</head>
<body>

<%
session.setMaxInactiveInterval(10);//设置session有效活动时间
Goods g=(Goods)request.getAttribute("g");
Ipandtime i=new Ipandtime();
String ip=i.getIp(request);
StoptimeListener userline=new StoptimeListener();
userline.setip(ip);
userline.setgoodsname(g.getName());
session.setAttribute("logonuser",userline);
%>

	<!--header-->
    <jsp:include page="/header.jsp"></jsp:include>
	<!--//header-->

	<!--//single-page-->
	<div class="single">
		<div class="container">
			<div class="single-grids">				
				<div class="col-md-4 single-grid">		
					<div class="flexslider">
						
						<ul class="slides">
							<li data-thumb="${g.cover}">
								<div class="thumb-image"> <img src="<%=request.getContextPath()%>/${g.cover}" data-imagezoom="true" class="img-responsive"> </div>
							</li>
							<li data-thumb="${g.image1}">
								 <div class="thumb-image"> <img src="<%=request.getContextPath()%>/${g.image1}" data-imagezoom="true" class="img-responsive"> </div>
							</li>
							<li data-thumb="${g.image2}">
							   <div class="thumb-image"> <img src="<%=request.getContextPath()%>/${g.image2}" data-imagezoom="true" class="img-responsive"> </div>
							</li> 
						</ul>
					</div>
				</div>	
				<div class="col-md-4 single-grid simpleCart_shelfItem">		
					<h3>${g.name}</h3>
					<div class="tag">
						<p>分类 : <a href="goods.action?typeid=5">${g.type.name}</a></p>
					</div>
					<p>${g.intro}</p>
					<div class="galry">
						<div class="prices">
							<h5 class="item_price">¥ ${g.price}</h5>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="btn_form">
						<a href="javascript:;" class="add-cart item_add" onclick="buy(${g.id})">加入购物车</a>
					</div>
				</div>
				<div class="col-md-4 single-grid1">
					<!-- <h2>商品分类</h2> -->
					<ul>
                        <li><a  href="<%=request.getContextPath()%>/goods_list">全部系列</a></li>

                        <c:forEach items="${typeList}" var="t">
                            <li><a href="<%=request.getContextPath()%>/goods_list?typeid=${t.id}">${t.name}</a></li>
                        </c:forEach>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	
	




	<!--footer-->
    <jsp:include page="/footer.jsp"></jsp:include>
	<!--//footer-->


</body>
</html>