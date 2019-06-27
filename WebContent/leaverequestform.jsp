<%@ page import="com.wipro.service.Dbutil, java.sql.* " language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=password], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=date], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=email], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=number], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

input[type=reset] {
	width: 100%;
	background-color: #d33734;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=reset]:hover {
	background-color: #f71511;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 30px;
	width: 450px;
	margin-left: 450px;
	margin-top: 100px;
	height: 850px;
}

a:link, a:visited {
	width: 88%;
	background-color: #f44336;
	color: white;
	padding: 14px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}
body {
  background-color:#adad85;
  background-repeat: no-repeat, repeat;
  background-size:cover;
}
</style>
<body>

	<h1
		style="color: yellow; background-color: black; height: 40px; text-align: center; padding: 10px;margin: 0px;">Leave
		Request Form</h1>

	<div>
		<form action="leavestat"  method="post" style="width: 400px;">
			<label>LOGIN ID</label> <input type="text" value=<%= session.getAttribute("uname")%>   id="loginid"
				name="name" placeholder="Login id.."><br> <label>TYPE
				OF LEAVE</label> <select required name="typeofleave">
				<option value=""></option>
				<option value="EL">EARNED LEAVE</option>
				<option value="SL">SICK LEAVE</option>
				<option value="CL">CASUAL LEAVE</option>
			</select> <br> <label>DEPARTMENT</label> <select name="dept">
				<option></option>
				<option>cse</option>
				<option >ece</option>
				<option >it</option>
				<option >eee</option>
				<option >auto</option>
				<option >mech</option>
				
			</select><br> <label>DATE OF
				REQUEST</label> <input type="date" id="dateofrequest" name="dor"
				placeholder=DateOfRequest.."> <br> <label>LEAVE
				FROM</label> <input type="date" id="leavefrom" name="from"
				placeholder="Leave From.."> <label>TO</label> <input
				type="date" id="to" name="to" placeholder="To.."> <label>NO
				OF DAYS</label> <input type="number" id="noofdays" name="noofdays"
				placeholder="DateOfRequest.."> PURPOSE OF LEAVE<br>
			<textarea rows="8" cols="54" name="mes"></textarea>
			<input type="submit" value="Apply Leave"> <input type="reset"
				value="Reset">
			<hr>
			<a href="employeelogin1.html">Back</a>
		</form>
	</div>
</body>
</html>
