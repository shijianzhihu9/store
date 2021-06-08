<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">管理员后台</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li ><a href="<%=request.getContextPath()%>/admin/Salesperson_list">销售员管理</a></li>
                <li ><a href="<%=request.getContextPath()%>/admin/goods_list">商品管理</a></li>
                <li ><a href="<%=request.getContextPath()%>/admin/IpandTime_list">登录信息列表</a></li>
                <li ><a href="<%=request.getContextPath()%>/admin/OpRecord_list">操作信息列表</a></li>
                <li ><a href="<%=request.getContextPath()%>/admin/StopTime_list">用户浏览信息列表</a></li>
                <li><a href="<%=request.getContextPath()%>/Admin_logout">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
