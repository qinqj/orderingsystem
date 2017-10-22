<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点餐系统首页</title>
</head>
<body>
		<%String username=(String)request.getParameter("username");
         if(username!=null&&!username.equals("")) {%>
		<font color='red'>登录成功！欢迎您：<%=username %></font><br>
		<%} %>
 	
 	 <%
		String msg=(String)request.getAttribute("msg");
         if(msg!=null&&!msg.equals("")) {%>
		<font color='red'>提示信息：<%=msg %></font><br>
		<%} %>
	<form action="addmenu" method="post">
		<table border="1">
			<tr><td colspan="2"><center>添加菜品</center></td></tr>
			<tr>
				<td>菜名</td>
				<td><input type="text" name="menu"></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr><td colspan="2"><center><input type="submit" value="保存"></center></td></tr>
			<tr><td colspan="2"><center><a href="menu">点击显示所有菜品</a></center></td></tr>
		</table>
		<hr>
		<table border="1">
			<tr><td colspan="2"><center>设置桌号</center></td></tr>
			<tr>
				<td>桌号：</td>
				<td><select name="number">
				<% for(int i=1;i<100;i++){
					
				%>
				<option><%=i %></option>
				<% }%>
				</select></td>
			</tr>
			<tr><td colspan="2"><center><input type="submit" value="保存"></center></td></tr>
		</table>
	</form>
</body>
</html>