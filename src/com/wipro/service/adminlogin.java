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
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Connection con = Dbutil.getConnection();
		System.out.println(con);
		String username=request.getParameter("username");
		String password=request.getParameter("pass");
		try
		{
			Statement st=con.createStatement();
			ResultSet rt=st.executeQuery("select * from login");
			while(rt.next())
			{
				String dname=rt.getString(1);
				String dpassword=rt.getString(2);
				if(username.matches(dname))
				{
					if(password.matches(dpassword))
					{
						response.sendRedirect("adminrequest.html");
					}
					else
					{
						response.sendRedirect("admin.html");
					}
				}
			}
			
					
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		


	}

}
