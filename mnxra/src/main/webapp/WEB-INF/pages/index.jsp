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
  <table>
  <tr><td>id</td><td>name</td><td>href</td><td>subdoamin</td><td>createtima</td><td>??</td><td>??</td></tr>
    <%ArrayList<Mnxra> mnxras =(ArrayList<Mnxra>)request.getAttribute("mnxras");
        if (mnxras.size()!=0){
            for (Mnxra mnxra:mnxras){


                %>


        <tr><%=mnxra.getId()%> </tr>
        <tr><%=mnxra.getName()%></tr>
        <tr><%=mnxra.getHref()%></tr>
        <tr><%=mnxra.getSubdomain()%></tr>
        <tr><%=mnxra.getCreatetime()%></tr>
      <tr><a href="/delete"></a></tr>
      <tr><a href="/update"></a></tr>


    </table>
    <%
            }
        }
    %>

  </body>
</html>
