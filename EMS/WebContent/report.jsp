<%@ page language="java" import="com.employee.bean.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table cellpadding="3" border="2">
<%
	out.println("<tr><th bgcolor=blue>EmpId</th><th bgcolor=blue>Name</th><th bgcolor=blue>Age</th><th bgcolor=blue>Address</th><th bgcolor=blue>Salary</th><th bgcolor=blue>Description</th><th bgcolor=blue>E-mail</th><th bgcolor=blue>PhoneNo</th></tr>");
	List<Employee> emplist1 = (List<Employee>)request.getAttribute("emplist");
for(Employee emp : emplist1){
	out.println("<tr> <td>"+emp.getSno()+"</td><td>"+emp.getName()+"</td><td>"+emp.getAge()+"</td><td>"+emp.getAddress()+"</td><td>"+emp.getSalary()+"</td><td>"+emp.getDescription()+"</td><td>"+emp.getEmail()+"</td><td>"+emp.getPhone()+"</td></tr>");
}	
%>
</table>
</body>
</html>