<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.io.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to SANraMon</title>

</head>
<body align="center">

<h1>SANraMon, where reporting and monitoring is a breeze</h1>

<button onclick="">Generate Report</button>
<button onclick="">Monitor DataSwift</button>

<%
	reportData rData = new reportData();
	String[] ar;//arbitrarily made to call main function properly
	rData.main(ar);//for some reason, the reportData class will not run without main function
%>

</body>
</html>