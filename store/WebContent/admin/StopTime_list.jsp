<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>用户浏览信息列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	




	<jsp:include page="header.jsp"></jsp:include>

	<c:if test="${!empty msg }">
		<div class="alert alert-success">${msg }</div>
	</c:if>
	<c:if test="${!empty failMsg }">
		<div class="alert alert-danger">${failMsg }</div>
	</c:if>
	<br>
	<br>
	
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ip</th>
		<th width="10%">浏览商品名</th>
		<th width="10%">停留时间</th>
	</tr>


		<c:forEach items="${p.list }" var="s">
			<tr>
				<td><p>${s.ip }</p></td>
				<td><p>${s.goodsname }</p></td>
				<td><p>${s.stoptime }</p></td>
			</tr>
		</c:forEach>
     
     
</table>

<br>
	<jsp:include page="/page.jsp">
		<jsp:param value="/admin/StopTime_list" name="url"/>
	</jsp:include>
<br>
</div>
</body>
</html>