<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'del.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/styles.css"/> 

  </head>
  
  <body>
    <div class="container">
    	<form action="del.action?id=${requestScope.id.id }" method="post">
    		<div class="form-group"> 
    			<label>编号:</label>
    			<input type="text" name="id" value="${requestScope.id.id }" class="form-control" disabled>	
    		</div>
    		<div class="form-group">
    			<label>姓名:</label>
    			<input type="text" name="name" value="${requestScope.id.name }" class="form-control" disabled="disabled">
    		</div>
    		<div class="form-group">
    			<label>电话号码:</label>
    			<input type="text" name="phone" value="${requestScope.id.phone }" class="form-control" disabled="disabled">
    		</div>
	   		<div class="text-right">
	   			<button class="btn btn-danger">删除联系人</button>
	   			<a href="list.action" class="btn btn-success">返回</a>
	   		</div>
    	</form>
    </div>
  </body>
</html>
