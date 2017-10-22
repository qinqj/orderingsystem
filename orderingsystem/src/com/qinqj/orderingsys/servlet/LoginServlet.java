package com.qinqj.orderingsys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qinqj.orderingsys.service.LoginService;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
//		接受请求，获得请求参数
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		
//		调用业务逻辑方法
		LoginService service=new LoginService();
		int flag=service.login(username, pwd);
		
//		根据不同的情况，跳转到不同的JSP
		if(flag==0){
//			使用请求属性传递数据
			request.setAttribute("msg", "正在审核，请等待。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if(flag==1){
//			获得JSP页面的时间信息
			String timelength=request.getParameter("timelength");
//			类型转换
			int hours=0;
			if(timelength!=null){
				hours=Integer.parseInt(timelength);
			}
//			只要天数不为0，则创建cookie，设置有效时间，存到客户端
			if(hours!=0){
				Cookie usernamecookie=new Cookie("username", username);
				Cookie passwordcookie=new Cookie("password",pwd);
				usernamecookie.setMaxAge(hours*3600);
				passwordcookie.setMaxAge(hours*3600);
				response.addCookie(usernamecookie);
				response.addCookie(passwordcookie);
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(flag==2){
			request.setAttribute("msg", "审核未通过，重新注册。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if(flag==3){
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
