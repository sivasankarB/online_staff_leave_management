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

@WebServlet("/LeaveSt")
public class LeaveSt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String sid=(String)session.getAttribute("s_id");
		int s_id=Integer.parseInt(sid);
		Connection con=Dbutil.getConnection();
		System.out.println(s_id);
		try {
			java.sql.Statement st = con.createStatement();
			ResultSet rt = st.executeQuery("select * from  leavereq where emp_id="+s_id+" ");
			request.setAttribute("rs",rt);
			RequestDispatcher rd=request.getRequestDispatcher("employeeleavestatic.jsp");
			rd.forward(request,response);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}



}
