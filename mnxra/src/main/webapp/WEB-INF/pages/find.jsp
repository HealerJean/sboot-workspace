<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="com.minixiao.domain.Mnxra" %>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
<% Mnxra mnxra =(Mnxra) request.getAttribute("mnxra");%>

    <table>
        <tr><td>id</td><%=mnxra.getId()%></tr>
        <tr><td>name</td><%=mnxra.getName()%></tr>
        <tr><td>href</td><%=mnxra.getHref()%></tr>
        <tr><td>subdomain</td><%=mnxra.getSubdomain()%></tr>
        <tr><td>cretetime</td><%=mnxra.getCreatetime()%></tr>
    </table>
  </body>
</html>
