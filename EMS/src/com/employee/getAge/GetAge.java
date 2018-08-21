package com.employee.getAge;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.bean.Employee;
import com.employee.util.DBUtill;

import java.util.*;


/**
 * Servlet implementation class getAge
 */
@WebServlet(urlPatterns="/getAge")
public class GetAge extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     PrintWriter out=response.getWriter();
     int inputAge=Integer.parseInt(request.getParameter("Age"));
     Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println(inputAge);
		List<Employee>list=new ArrayList<Employee>();
		try {
			String Data="Select*from userdetails";
			connection=DBUtill.getConnection();
			preparedStatement=connection.prepareStatement(Data);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				
				if(resultSet.getInt("Age") < inputAge)
				{
					
					Employee emp = new Employee();
					emp.setSno(resultSet.getString(1));
					emp.setName(resultSet.getString(2));
					emp.setAge(resultSet.getString(3));
					emp.setAddress(resultSet.getString(4));
					emp.setSalary(resultSet.getString(5));
					emp.setDescription(resultSet.getString(6));
					emp.setPhone(resultSet.getString(8));
					emp.setEmail(resultSet.getString(7));
					list.add(emp);
					
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		request.setAttribute("emplist", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/report.jsp");
		dispatcher.forward(request, response);
		
	}

}
