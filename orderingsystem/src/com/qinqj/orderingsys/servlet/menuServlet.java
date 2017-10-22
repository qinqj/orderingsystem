package com.qinqj.orderingsys.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class menuServlet
 */
public class menuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menuServlet() {
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
//		获得上下文对象，得到实际地址
		ServletContext ctxt=this.getServletContext();
		String ctxtPath=ctxt.getRealPath("/");
		File file=new File(ctxtPath+"/WEB-INF/menutable.txt");
		BufferedReader fbr=new BufferedReader(new FileReader(file));
		
//		使用Map对象，保存用户名和密码信息
		Map<String,String> map=new HashMap<String,String>();
		
		String line=fbr.readLine();
		while(line!=null){
			String[] s=line.split("#");
			map.put(s[0],s[1]);
			line=fbr.readLine();
		}
//	         将map保存到请求属性中，以便传递给JSP	
		request.setAttribute("map", map);	
//		使用请求转发跳转到JSP，不能用响应重定向
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

}
