package com.city.erp.action;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ProductAddProcessActio
 */
@WebServlet("/product/add.do")
@MultipartConfig
public class ProductAddProcessActio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection cn=null;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

		
	}
	

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String PID=request.getParameter("number");
		String PNAME=request.getParameter("name");
		Part part = request.getPart("photo");
		String fileName=part.getSubmittedFileName(); //取得提交的文件名
		String contentType=part.getContentType(); //取得文件类型
		ServletContext application=request.getServletContext();
		System.out.println(fileName);
		String hzm = fileName.substring(fileName.indexOf("."));//获取文件的后缀名
		
		//String path=application.getRealPath("/upload/tu"+new Date().getTime()+hzm);
		String PRICE=request.getParameter("price");
		
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cityerp?useUnicode=true&characterEncoding=utf8","root", "root");
		    String sql="insert into product(PCODE,PNAME,PRICE,PHOTO,PHOTOTYPE,PhotoFileName) values(?,?,?,?,?,?)";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1,PID);
			ps.setString(2,PNAME);
			ps.setString(3,PRICE);
			
			//part.write(path); //保存到指定的目录中
	        InputStream in=part.getInputStream(); //取得流，可以写入到数据库中
	        ps.setBinaryStream(4, in, in.available());
	        ps.setString(5,contentType);
			ps.setString(6,fileName);
		    ps.executeUpdate();
		    response.sendRedirect("add.jsp");	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
