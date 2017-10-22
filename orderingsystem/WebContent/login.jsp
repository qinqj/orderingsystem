<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>点餐系统登录</title>
</head>
<script type="text/javascript">
	function login(){
		var flag=1;
		var username=document.getElementById("username").value;
		var pwd=document.getElementById("pwd").value;
		var usernamemsg=document.getElementById("usernamemsg");
		var pwdmsg=document.getElementById("pwdmsg");
		if(username==null||username==""){
		usernamemsg.innerHTML="<font color='red'>用户名不能为空</font>";
		flag=0;
		}	
		if(pwd==null||pwd==""){
		pwdmsg.innerHTML="<font color='red'>密码不能为空</font>";
		flag=0;
		} 
		if(flag==1){
		form1.action="LoginServlet";/* 如果出现404则是这里出错（跳转不到servlet中） */
		form1.submit();
		}
	}
</script>
<%
String username=null;
String password=null;
//获得请求中的所有cookie对象
Cookie[] cookies=request.getCookies();
//只要存在cookie，就查找是否有用户名和密码
if(cookies!=null){
	for(Cookie cookie:cookies){
		if(cookie.getName().equals("username")){
			username=cookie.getValue();
		}
		if(cookie.getName().equals("password")){
			password=cookie.getValue();
		}
	}
}
//如果存在username，password，则直接跳转到LoginServlet，进行登录验证，不再提示输入用户名密码
if(username!=null&&password!=null){
	request.getRequestDispatcher("LoginServlet?username="+username+"&pwd="+password).forward(request, response);
}
%>
<body>
	<form id="form1" action="" method="post">
		<%
		String msg=(String)request.getAttribute("msg");
         if(msg!=null&&!msg.equals("")) {%>
		<font color='red'>提示信息：<%=msg %></font><br>
		<%} %>
		用户名：<input type="text" id="username" name="username"><div id="usernamemsg"></div><br> 
		密 码：<input	type="password" id="pwd" name="pwd"><div id="pwdmsg"></div><br> 
		<select id="timelength" name="timelength">
			<option value="0" selected>每次都需要登录</option>
			<option value="3">3小时内</option>
			<option value="24">1天内</option>
			<option value="72">3天内</option>
		</select><br>
		<input type="button" value="登录" onclick="login()">
	</form>
</body>
</html>