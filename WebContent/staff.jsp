<%@ page import="com.wipro.service.Dbutil, java.sql.* " language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Statistics</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
table {
	margin-left: 110px;
	margin-top: 60px;
	border-collaspe: collapse;
	width: 80%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
tr:nth-child(odd) {
	background-color:  #d4d4aa;
}

th {
	background-color: #4CAF50;
	color: white;
}
body {
  background-image: url("bg9.jpg");
  background-repeat: no-repeat, repeat;
  background-size:cover;
}
</style>

</head>

<body>
	<h2
		style="color: yellow; background-color: black; height: 60px; text-align: center; padding: 10px;margin: 0px;">Online
		Staff Leave Management</h2>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<ul class="nav navbar-nav">
			<li><a href="index.html" target="_self">HOME</a></li>
			<li><a href="#">STAFF</a></li>
			<li><a href="admin.html">LOGOUT</a></li>
		</ul>
		<form class="navbar-form navbar-right" action="/action_page.php">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search"
					name="search">

			</div>
		</form>
	</div>
	</nav>




	<%
		ResultSet rt = (ResultSet) request.getAttribute("rs");
		String h = "", a = "";
		out.println(
				"<table ><tr><th>Employee name</th><th>Employee Type </th><th>Department</th><th>Date of Birth</th><th>Phone number</th></tr>");

		while (rt.next()) {
			String employee_name=rt.getString(2);
			String employee_type=rt.getString(1);
			String department=rt.getString(4);
			Date date=rt.getDate(5);
			String number=rt.getString(7);

			out.println("<tr><td>" +employee_name + "</td><td>" + employee_type+ "</td>  <td>" +  department + "</td>   <td>"
					+ date + "</td>   <td>" + number + "</td>  ");
		}
		out.println("</table>");
	%>
</body>
</html>