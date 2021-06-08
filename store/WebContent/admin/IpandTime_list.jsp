<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>登录信息列表</title>
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
		<th width="10%">时间</th>
		<th width="10%">用户名</th>
		<th width="10%">用户类型</th>
		<th width="12%">操作</th>
	</tr>
		<c:forEach items="${p.list }" var="i">
			<tr>
				<td><p>${i.ip }</p></td>
				<td><p>${i.time }</p></td>
				<td><p>${i.name }</p></td>
				<td><p>${i.type }</p></td>
				<td><p>${i.op }</p></td>
			</tr>
		</c:forEach>
     
     
</table>

<br>
	<jsp:include page="/page.jsp">
		<jsp:param value="/admin/IpandTime_list" name="url"/>
	</jsp:include>
<br>
</div>
</body>
</html>