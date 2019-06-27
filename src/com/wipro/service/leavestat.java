package com.wipro.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

@WebServlet("/leavestat")
public class leavestat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String username=request.getParameter("name");
		String typeofleave=request.getParameter("typeofleave");
		String dept=request.getParameter("dept");
		String dor=request.getParameter("dor");
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		String noofdays=request.getParameter("noofdays");
		String purpose=request.getParameter("mes");
		String hod="pending";
		String admin="pending";
		
		try
		{
			Connection con=Dbutil.getConnection();
			java.sql.Statement st=con.createStatement();
			String sql = "insert into leavereq (username,typeofleave,dept,dor,leavefrom,leaveto,noofdays,purpose,hod,admin,emp_id) values (?,?,?,?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, username);
			ps.setString(2, typeofleave);
			ps.setString(3, dept);
			ps.setString(4, dor);
			ps.setString(5, from);
			ps.setString(6, to );
			ps.setString(7, noofdays);
			ps.setString(8, purpose);
			ps.setString(9,hod );
			ps.setString(10, admin);
			
			HttpSession session=request.getSession();
			String sid=(String)session.getAttribute("s_id");
			int s_id=Integer.parseInt(sid);
			ps.setInt(11, s_id);			
			ps.executeUpdate();

			ResultSet rt=st.executeQuery("select * from  leavereq where emp_id="+s_id+" ");
			request.setAttribute("rs",rt);
			RequestDispatcher rd=request.getRequestDispatcher("employeeleavestatic.jsp");
			rd.forward(request,response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
