package com.work.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://127.0.0.1:3306/work";
	private static String user="root";
	private static String pass="520528";
	static{
		String path=ConnectionFactory.class.getResource("/").toString();
		path=path+"jdbc.properties";
		Properties p=new Properties();
		try {
			p.load(new FileInputStream(path.replace("file:","")));
			Class.forName((String)p.get("driver"));
			url=(String)p.get("url");
			user=(String)p.get("user");
			pass=(String)p.get("pass");		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static Connection tools(){
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}

}
