<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("currentUser") == null){
		response.sendRedirect("index.jsp");
		return;
	}
%>
