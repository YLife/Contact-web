<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
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
    	<form action="edit.action?id=${requestScope.id.id }" method="post">
    		<div class="form-group">
    			<label>编号:</label>
	    		<input type="text" name="id" value="${requestScope.id.id }" class="form-control" disabled="disabled">
    		</div>
    		<div class="form-group">
    			<label>姓名:</label>
    			<input type="text" name="name" value="${requestScope.id.name }" class="form-control">
    		</div>
    		<div class="form-group">
    			<label>手机号码:</label>
    			<input type="text" name="phone" value="${requestScope.id.phone }" class="form-control">
    		</div>
    		<div class="text-right">
    			<button class="btn btn-success">保存修改</button>
    			<a href="list.action" class="btn btn-default">返回</a>
    		</div>
    	</form>
    </div>
  </body>
</html>
