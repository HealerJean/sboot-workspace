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
  <%  Mnxra mnxra =(Mnxra) request.getAttribute("mnxra");%>

  <form action="/msg/update" method="get"></form>
  <table>
      <tr><td>id</td><td><%=mnxra.getId()%></td></tr>
      <tr><td>name</td><td><input type="text" value="<%=mnxra.getName()%>"></td></tr>
      <tr><td>href</td><td><input type="text" value="<%=mnxra.getHref()%>"></td></tr>
      <tr><td>subdomain</td><td><input type="text" value="<%=mnxra.getSubdomain()%>"></td></tr>
      <tr><td>cretetime</td><td><%=mnxra.getCreatetime()%></td></tr>
  </table>
    <input type="submit" value="??"/>
  </body>
</html>
