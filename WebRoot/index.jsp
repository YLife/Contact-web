<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/styles.css">
	<script>
		function getImage(){
			var vImg = document.getElementById("vImg");
			//清除缓存
			vImg.src = "validate-image.jsp?nocache=" + Math.random();
		}
	</script>
  </head>
  	
  <body>
    <div class="container">
    	<form action="checkCode.action" method="post">
    		<div class="form-group">
    			<label>用户名：</label>
    			<input type="text" name="user" class="form-control">
    		</div>
    		<div class="form-group">
    			<label>密码：</label>
    			<input type="password" name="pwd" class="form-control">
    		</div>
    		<div class="form-group">
    			<img id="vImg" src="validate-image.jsp" alt="" />
	  			<a href="#" onclick="getImage()">看不清楚，换一张</a>
    		</div>
    		<div class="form-group">
    			<label>请输入验证码：</label>
    			<input type="text" name="checkNo">
    		</div>
    		<div class="form-group">
    			<label>
    				<input type="checkbox" name="remember" value="yes">记住密码
    			</label>
    		</div>
    		<div class="form-group">
    			<button class="btn btn-default">确定</button>
    		</div>
    	</form>
    </div>
  </body>
</html>
