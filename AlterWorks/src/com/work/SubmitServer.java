package com.work;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitServer {
	public  void write(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="";
		 try{
			   File f=new File("e:/文本框.txt");//向指定文本框内写入
			   FileWriter fw=new FileWriter(f);
			   String line=request.getParameter("text");
			   System.out.println(line);
			   fw.write(line);
			   fw.close();
			   path  = "submit.jsp";
			  }catch(Exception e){
				 e.printStackTrace(); 
			  }
		 	RequestDispatcher dis = request.getRequestDispatcher(path);
			dis.forward(request, response);
		 }
	
}
