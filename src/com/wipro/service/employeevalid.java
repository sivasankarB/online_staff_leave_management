package com.wipro.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/employeevalid")
public class employeevalid extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try
		{
			Connection con=Dbutil.getConnection();
			Statement st=con.createStatement();
			ResultSet rt=st.executeQuery("select * from emp");
			while(rt.next())
			{
				String dname=rt.getString(8);
				String dpassword=rt.getString(9);
				if(username.matches(dname))
				{
					if(dpassword.matches(password))
					{
						HttpSession session=request.getSession();
						session.setAttribute("s_id",rt.getString(10));
						session.setAttribute("uname", username);
						response.sendRedirect("employeelogin1.html");
					}else
					{
						response.sendRedirect("employeelogin.html");
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
