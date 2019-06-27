package com.wipro.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/staff")
public class staff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con=Dbutil.getConnection();
		try {
			java.sql.Statement st = con.createStatement();
			ResultSet rt = st.executeQuery("select * from  emp");
			request.setAttribute("rs",rt);
			RequestDispatcher rd=request.getRequestDispatcher("staff.jsp");
			rd.forward(request,response);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}


}
