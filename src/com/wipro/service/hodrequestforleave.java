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

@WebServlet("/hodrequestforleave")
public class hodrequestforleave extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con=Dbutil.getConnection();
		try {
			java.sql.Statement st = con.createStatement();
			HttpSession session=request.getSession();
			String hod_id=(String)session.getAttribute("hod_id");
			ResultSet pt=st.executeQuery("select department from hod where username='"+hod_id+"'  ");
			pt.next();
			String department=pt.getString(1);
			System.out.println("dep1"+department);
			ResultSet rt = st.executeQuery("select * from  leavereq where dept ='"+department+"'");
			request.setAttribute("rs",rt);
			RequestDispatcher rd=request.getRequestDispatcher("hodrequestforleave.jsp");
			rd.forward(request,response);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

}
