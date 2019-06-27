package com.wipro.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminreject")
public class adminreject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int leave_id = Integer.parseInt(request.getParameter("leave_id"));

		try {
			String r = "Reject";
			Connection con = Dbutil.getConnection();
			Statement st = con.createStatement();
			String query = "update leavereq set admin='" + r + "' where leave_id='" + leave_id + "'";
			st.executeUpdate(query);
			System.out.println("successfully rejected");
			RequestDispatcher rd = request.getRequestDispatcher("adminleavestat");
			rd.forward(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
