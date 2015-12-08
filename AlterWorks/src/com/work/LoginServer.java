package com.work;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.work.server.ConnectionFactory;
public class LoginServer {
	public  void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username===="+username);
		System.out.println("password===="+password);
		System.out.println("**********");
		Connection conn = ConnectionFactory.tools();
		String sql = "SELECT * FROM user WHERE username=? AND password=?";
		String path  = "";
		try {
			PreparedStatement parma = conn.prepareStatement(sql);
			parma.setString(1,username);
			parma.setString(2,password);
			ResultSet rs = parma.executeQuery();
			if(rs.next()){
				HttpSession session=request.getSession();
				session.setAttribute("loginname", rs.getString("loginname"));
				path = "submit.jsp";
				System.out.println("登陆成功！");
				response.sendRedirect("submit.jsp");		
			}else{
				path = "login.jsp";
				request.setAttribute("error","用户名或密码错误！");
				System.out.println("ssssssss");
			}
		} catch (Exception e) {
			path = "error.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}
}



