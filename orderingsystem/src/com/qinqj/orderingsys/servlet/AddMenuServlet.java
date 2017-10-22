package com.qinqj.orderingsys.servlet;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddMenuServlet
 */
public class AddMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMenuServlet() {
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
		try {
			//TXT文件路径
			String path = "E:\\JavaEEWorkspace\\orderingsystem\\WebContent\\WEB-INF\\menutable.txt";
			// 打开一个随机访问文件流，按读写方式
			RandomAccessFile randomFile = new RandomAccessFile(path, "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			//获取用户提交的参数
			String menu=request.getParameter("menu");
			String price=request.getParameter("price");
			String number=request.getParameter("number");
			System.out.println(number);
			if(menu==null||menu.equals("")||price==null||price.equals("")){
				
			}else{
				String content=menu+"#"+price;
				randomFile.writeBytes(content+"\r\n");
			}
			randomFile.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
		String msg = "添加成功！";
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
