package com.wipro.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hodprofileupdate")
public class hodprofileupdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String designation=request.getParameter("designation");
		String department=request.getParameter("department");
		String email=request.getParameter("email");
		String number=request.getParameter("contact");
		Connection con = Dbutil.getConnection();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println("connnection:"+con);
		try
		{
			Statement st=con.createStatement();
			String query="update hod set designation='"+designation+"',department='"+department+"',email='"+email+"',number='"+number+"',password='"+password+"' where username='"+name+"'";
			st.executeUpdate(query);
			System.out.println(name);
			System.out.println(email);
			response.sendRedirect("hodlogin.html");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	

}
