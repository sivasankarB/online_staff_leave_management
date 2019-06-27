package com.wipro.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

@WebServlet("/hodnewregister")
public class hodnewregister extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String designation=request.getParameter("designation");
		String department=request.getParameter("department");
		String email=request.getParameter("email");
		String number=request.getParameter("contact");
		Connection con=Dbutil.getConnection();
		System.out.println("con:"+con);
		try
		{
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			Statement st=(Statement) con.createStatement();
			st.executeUpdate("insert into hod values('"+username+"','"+password+"','"+designation+"','"+department+"','"+email+"','"+number+"')");
			response.sendRedirect("hodlogin.html");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
