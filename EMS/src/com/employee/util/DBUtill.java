package com.employee.util;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;
public class DBUtill {
public static Connection getConnection()
{
	Connection connection=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
			connection=DriverManager.getConnection("jdbc:mysql://localhost/Employee","root","root");
	}	
	 catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
	
}
public static void close(Connection connection,ResultSet result,PreparedStatement stmt) {
	try {
	if(result!=null)
	{
		result.close();
	}
	if(stmt!=null)
	{
		stmt.close();
	}
	if(connection!=null)
	{
		connection.close();
	}
	}
	 catch (Exception e) {
			e.printStackTrace();
		}
}
}
