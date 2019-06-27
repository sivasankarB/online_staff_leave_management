<%@ page import="com.wipro.service.Dbutil, java.sql.* " language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
table
{
margin-left:110px;
margin-top:100px;
border-collaspe:collapse;
width:80%;
}
th,td
{
text-align:left;
padding:8px;
}
tr:nth-child(even){
background-color:#f2f2f2;
}
tr:nth-child(odd) {
	background-color:  #d4d4aa;
}
th
{
background-color:#4CAF50;
color:white;
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
				<li><a href="leaverequestform.jsp">LEAVE REQUEST FORM</a></li>
				<li><a href="#">LEAVE STATISTIC</a></li>
				<li><a href="employeeprofile.html	">PROFILES</a></li>
				<li><a href="employeelogin.html">LOGOUT</a></li>
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
	
	ResultSet rt=(ResultSet)request.getAttribute("rs");
	String hod="",h="",a="";
	out.println("<table ><tr><th>Employee name</th><th>Leave Request Date</th><th>Head of the Department</th><th>Admin</th></tr>");

	while(rt.next())
	{
		String username=rt.getString(1);
		Date date=rt.getDate(4);
		String dusername=rt.getString(2);
		String date1=rt.getString(5);
		hod=rt.getString(9);
		System.out.println(hod);
		String admin=rt.getString(10);
		System.out.println(admin);
		if(hod.equals("pending"))
		{
			 h="pending";
		}
		else
		{
			h="Granted";
		}
		if(admin.equals("pending")){
			 a="pending";
		}
		else
		{
			a="Granted";
		}
		
		if(admin.equalsIgnoreCase("Reject"))
		{
			a="Reject";
		}
		if(hod.equalsIgnoreCase("Reject"))
		{
			h="Reject";
			a="Reject";
			
		}
		out.println("<tr><td>"+username+"</td><td>"+date+"</td><td>"+h+"</td><td>"+a+"</td></tr>");
	}
	out.println("</table>");


%>
</body>
</html>