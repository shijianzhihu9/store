<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>销售员列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	




	<jsp:include page="header.jsp"></jsp:include>

	<div class="text-right"><a class="btn btn-warning" href="Salesperson_add.jsp">添加销售员</a></div>
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
		<th width="5%">ID</th>
		<th width="10%">用户名</th>
		<th width="10%">电话</th>
		<th width="10%">地址</th>
		<th width="12%">操作</th>
	</tr>


		<c:forEach items="${p.list }" var="u">
			<tr>
				<td><p>${u.id }</p></td>
				<td><p>${u.salespersonname }</p></td>
				<td><p>${u.phone }</p></td>
				<td><p>${u.address }</p></td>
				<td>
					<a class="btn btn-info" href="<%=request.getContextPath()%>/admin/Salesperson_reset.jsp?id=${u.id }&salespersonname=${u.salespersonname }">重置密码</a>
					<a class="btn btn-primary" href="<%=request.getContextPath()%>/admin/Salesperson_editshow?id=${u.id }">修改</a>
					<a class="btn btn-danger" href="${pageContext.request.contextPath }/admin/Salesperson_delete?id=${u.id }">删除</a>
				</td>
			</tr>
		</c:forEach>
     
     
</table>

<br>
	<jsp:include page="/page.jsp">
		<jsp:param value="/admin/Salesperson_list" name="url"/>
	</jsp:include>
<br>
</div>
</body>
</html>