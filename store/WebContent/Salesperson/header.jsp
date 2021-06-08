<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">销售员后台</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li ><a href="<%=request.getContextPath()%>/Salesperson/order_list">订单管理</a></li>
                <li ><a href="<%=request.getContextPath()%>/Salesperson/type_list">类目管理</a></li>
                <li><a href="<%=request.getContextPath()%>/Salesperson_logout">退出</a></li>
            </ul>
        </div>
    </div>
</nav>