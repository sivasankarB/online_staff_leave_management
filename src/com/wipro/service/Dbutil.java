package com.wipro.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Dbutil 
{
	public static Connection con;
	public static Connection getConnection()
	{
		if(con==null)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oslm","root","kongu");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return con;
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}

}
