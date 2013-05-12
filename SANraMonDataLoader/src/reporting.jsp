<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to SANraMon</title>
</head>
<body align="center">

<h1>SANraMon, where reporting and monitoring is a breeze</h1>

<% 
	try {
		String connectionURL = null; //should be connection to db "jdbc:mysql://localhost:3306/db_name"
		Connection connect = null; //use connection interface
		Statement stment = null; //used for executing sql statements
		ResultSet resSet = null; //used as a table for output data from the table
		Class.forName("com.mysql.jdbc.Driver").newInstance(); //load jdbc driver
		
		connect = DriverManager.getConnection(connectionURL, userName, psword); //create connection to database
		stment = connect.createStatement(); //used for sending sql statements to specified db
		
		String qryStr = "SELECT * FROM stu_info";
		resSet = stment.executeQuery(qryStr);	
%>

<TABLE> 

<%
	while (resSet()) {
 %>
 <TR> 
 	<td><%=resSet.getInt(1)%></td>
 	<TD><%=resSet.getString(2)%></TD> 
	<TD><%=resSet.getString(3)%></TD> 
	<TD><%=resSet.getString(4)%></TD> 
 </TR>
<%
	}
 %>

<%
	resSet.close();
	stment.close();
	connect.close();
	}
	catch (Exception ex) {
%>
<%
	out.println("Unable to connect to db");
	}
%>
</TABLE>

<table>
<tr>
<td>
	<FORM ACTION="reporting.jsp" method="get" />
	<button type="submit">Submit</button>
</td>
</tr>

</table>

<button onclick="">Generate Report</button>
<button onclick="">Monitoring Report</button>

</body>
</html>