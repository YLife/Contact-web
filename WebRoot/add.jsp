<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="session.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/styles.css" />

  </head>
  
  <body>
    <div class="container">
    	<h3>添加联系人</h3>
    	<form action="add.action" method="post">
    		<div class="form-group">
    			<label>Name</label>
    			<input type="text" name="name" class="form-control">
    		</div>
    		<div class="form-group">
    			<label>Phone</label>
    			<input type="text" name="phone" class="form-control">
    		</div>
    		<div class="text-right">
    			<button class="btn btn-info">保存联系人</button>
    			<a href="list.action" class="btn btn-default">返回</a>
    		</div>
    	</form>
    </div>
  </body>
</html>
