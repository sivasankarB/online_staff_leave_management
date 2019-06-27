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
		style="color: yellow; background-color: black; height: 60px; text-align: center; padding: 10px;margin 0px;">Online
		Staff Leave Management</h2>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<ul class="nav navbar-nav">
			<li><a href="index.html" target="_self">HOME</a></li>
			<li><a href="#">LEAVE STATISTIC</a></li>
			<li><a href="staff">STAFF</a></li>
			<li><a href="hodprofile.html">PROFILES</a></li>
			<li><a href="hodlogin.html">LOGOUT</a></li>
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
		String h = " ", r = " ";
		out.println(
				"<table ><tr><th>Employee name</th><th>Type of Leave </th><th>Date of request</th><th>Leave from</th><th>Leave to</th><th>Total Days</th><th>  purpose</th><th>Accept</th><th>Reject</th></tr>");

		while (rt.next()) {
			String username = rt.getString(1);
			String typeofleave = rt.getString(2);
			Date dor = rt.getDate(4);
			Date leavefrom = rt.getDate(5);
			Date leaveto = rt.getDate(6);
			String noofdays = rt.getString(7);
			String purpose = rt.getString(8);
			String hod = rt.getString(9);
			String admin = rt.getString(10);
			int leave_id=rt.getInt(11);
			int emp_id=rt.getInt(12);
			if (hod.equals("pending")) {
				h = "Forward";
				r="Reject";
				out.println("<tr><td>" + username + "</td><td>" + typeofleave + "</td>  <td>" + dor + "</td>   <td>"+ leavefrom + "</td>   <td>" + leaveto + "</td>   <td>" + noofdays + "</td>   <td>"+ purpose+"</td>   <td><form action='hodapprove' method='get'><input name='leave_id' type='hidden' value='"+leave_id+"'> <input name='emp_id' type='hidden' value='" +emp_id+ "'><button type='submit' value='" + h + "'</button></form></td>  <td><form action='hodreject' method='get'><input name='leave_id' type='hidden' value='"+leave_id+"'> <input name='emp_id' type='hidden' value='" +emp_id+ "'><button type='submit' value='" + r + "'</button></form></td></tr>");
			}

		}
		out.println("</table>");
	%>
</body>
</html>