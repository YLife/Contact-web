<%@page import="util.Pagination"%>
<%@page import="entity.AddressInfo"%>
<%@page import="dao.AddressInfoDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="session.jsp" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>联系人列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/styles.css"/> 
</head>

<body>
	<div class="container1">
		<h3 class="clearfix">
			<span class="pull-left">联系人列表</span> <a class="pull-right"
				href="add.jsp">添加联系人</a>
		</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th width="25%">Id</th>
					<th width="25%">Name</th>
					<th width="25%">Phone</th>
					<th>Operation</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.data }" var="a">
					<tr>
						<td>${a.id }</td>
						<td>${a.name }</td>
						<td>${a.phone }</td>
						<td>
							<a href="find.action?id=${a.id }" class="btn btn-success">编辑联系人</a>
							<a href="find2.action?id=${a.id }" class="btn btn-danger">删除联系人</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 分页区 -->
		<div class="text-right">
			<ul class="pagination">
				${pag.html }
			</ul>
		</div>
	</div>
</body>
</html>
