package com.wipro.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/employeenewregister")
public class employeenewregister extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String employee_name = request.getParameter("employeename");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String employee_type = request.getParameter("employeetype");
		String designation = request.getParameter("designation");
		String department = request.getParameter("department");

		
		String dob = request.getParameter("dob");
		SimpleDateFormat ft = new SimpleDateFormat("yyyy/mm/dd");
		java.util.Date now = new java.util.Date();
		try {
			now = ft.parse(dob);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date new1 =new java.sql.Date(now.getTime());

		String email = request.getParameter("email");
		String number = request.getParameter("contact");
		Connection con = Dbutil.getConnection();
		System.out.println("connnection:" + con);
		try {

			response.setContentType("text/html");

			String sql = "insert into emp (employee_type,employee_name,designation,department,dob,email,number,username,password) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, employee_type);
			ps.setString(2, employee_name);
			ps.setString(3, designation);
			ps.setString(4, department);
			ps.setDate(5, new1);
			ps.setString(6, email);
			ps.setString(7, number);
			ps.setString(8, username);
			ps.setString(9, password);
			ps.executeUpdate();

			response.sendRedirect("employeelogin.html");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	

}
