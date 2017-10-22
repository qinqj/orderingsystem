<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有菜单</title>
</head>
<body>
	<table border="1">
  	<tr>
  		<td>菜名</td>
  		<td>价格</td>
  	<tr>
  <%
  Map<String,String> map=(Map<String,String>)request.getAttribute("map");
  Set<String> usernameset=map.keySet(); 
  for(String key:usernameset) {%>
  	<tr>
  		<td><%=key%></td>
  		<td><%=map.get(key)%></td>
  	<tr>
  <%}%>
  </table>
  <a href="index.jsp">返回添加页面</a>
</body>
</html>