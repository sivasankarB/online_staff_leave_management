package com.wipro.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employeeprofileupdate")
public class employeeprofileupdate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String employee_name=request.getParameter("employeename");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String employee_type=request.getParameter("employeetype");
		String designation=request.getParameter("designation");
		String department=request.getParameter("department");
		String dob=request.getParameter("dob");
		String email=request.getParameter("email");
		String number=request.getParameter("contact");
		Connection con = Dbutil.getConnection();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println("connnection:"+con);
		try
		{
			Statement st=con.createStatement();
			String query="update emp set employee_type='"+employee_type+"',designation='"+designation+"',department='"+department+"',dob='"+dob+"',email='"+email+"',number='"+number+"',username='"+name+"',password='"+password+"' where employee_name='"+employee_name+"'";
			st.executeUpdate(query);
			System.out.println(name);
			System.out.println(employee_name);
			response.sendRedirect("employeelogin.html");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
