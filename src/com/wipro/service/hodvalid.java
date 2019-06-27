package com.wipro.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hodvalid")
public class hodvalid extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			Connection con = Dbutil.getConnection();
			Statement st = con.createStatement();
			ResultSet rt = st.executeQuery("select * from hod");
			while (rt.next()) {
				String dname = rt.getString(1);
				String dpassword = rt.getString(2);
				String department = rt.getString(4);
				if (username.matches(dname)) {
					if (dpassword.matches(password)) {
						request.setAttribute("dept", department);

						HttpSession session = request.getSession();
						session.setAttribute("hod_id", username);

						response.sendRedirect("hodlogin1.html");

					} else {
						response.sendRedirect("hodlogin.html");
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
