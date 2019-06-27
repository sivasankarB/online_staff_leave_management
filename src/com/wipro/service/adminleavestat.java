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
import javax.servlet.http.HttpSession;

@WebServlet("/adminleavestat")
public class adminleavestat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection con = Dbutil.getConnection();
			java.sql.Statement st = con.createStatement();
			ResultSet rt = st.executeQuery("select * from  leavereq");
			request.setAttribute("rt", rt);
			RequestDispatcher rd = request.getRequestDispatcher("adminleavestat.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
