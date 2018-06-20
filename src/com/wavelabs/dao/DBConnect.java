package com.wavelabs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {

	public static Connection getConnection() throws Exception
	{
		String url="jdbc:oracle:thin:@192.168.0.7:1521:xe";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, "satya", "Hanuman1");
		
//		String url="jdbc:mysql://localhost:3306/mysql";
//		Class.forName("com.mysql.jdbc.Driver");
//		return DriverManager.getConnection(url, "root", "kasi");
//		
	}
	public static void closeConnection(Connection con)
	{
		try
		{
			if(con!=null)
				con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void closeStatement(Statement st)
	{
		try
		{
			if(st!=null)
				st.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void closeResultSet(ResultSet rs)
	{
		try
		{
			if(rs!=null)
				rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
