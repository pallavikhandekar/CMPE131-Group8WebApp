<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.io.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Test java script code -->
<script > 
function fo() {
	alert("hi");	
	alert("it happend again");
	document.write("hi");
}

function bar() {
	document.write("how fun");
}
</script>
</head>
<body align="center">

<h1>SANraMon, where reporting and monitoring is a breeze</h1>

<input id="gen_but" type="button" onclick="fo()" value="Generate Report" />
<input id="monData" type="button" onclick="bar()" value="Monitor Data" />

<%
	reportData rData = new reportData();
	String[] ar; //arbitrary variable used to call main
	rData.main(ar); //calls main function to display data (time stamp and iops)
 %>

</body>
</html>