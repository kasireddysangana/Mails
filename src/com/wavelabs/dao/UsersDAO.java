package com.wavelabs.dao;

import com.wavelabs.entity.User;
import com.wavelabs.entity.UserDetails;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
public class UsersDAO {
	public boolean checkUser(User u)
	{
		boolean res = false;
		Connection con =null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try
		{
			con =DBConnect.getConnection();
			pst = con.prepareStatement("select username, password from users where username = ? and password = ?");
			pst.setString(1, u.getUserName());
			pst.setString(2, u.getPassword());
			
			rs = pst.executeQuery();
			if(rs.next())
				res = true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBConnect.closeResultSet(rs);
			DBConnect.closeStatement(pst);
			DBConnect.closeConnection(con);
		}
		return res;
	}
	public boolean createUser(UserDetails ud)
	{
		Connection con =null;
		PreparedStatement pst = null;
		int count=0;
		try
		{
			con =DBConnect.getConnection();
			pst = con.prepareStatement("insert into users values(?,?,?,?,?,?)");
			
			pst.setString(1, ud.getUser().getUserName());
			pst.setString(2, ud.getUser().getPassword());
			pst.setString(3, ud.getFirstName());
			pst.setString(4, ud.getLastName());
			pst.setLong(5, ud.getPhone());
			pst.setString(6, ud.getAddress());
			
			count  = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBConnect.closeStatement(pst);
			DBConnect.closeConnection(con);
		}
		return (count==1);
	}
	
	public List<String> getMailsOfUser(User u)
	{
		ArrayList<String> mails = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = DBConnect.getConnection();
			pst = con.prepareStatement("select subject from usermails where username=?");
			pst.setString(1, u.getUserName());
			rs = pst.executeQuery();
			while(rs.next())
			{
				mails.add(rs.getString(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)
				DBConnect.closeResultSet(rs);
			if(pst!=null)
				DBConnect.closeConnection(con);
			if(con!=null)
				DBConnect.closeConnection(con);
		}
		return mails;
		
	}
	public boolean transferMoney(String userName, Double amount)
	{
		int count = 0;
		double accountBalance = 0.0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = DBConnect.getConnection();
			pst = con.prepareStatement("select amount from accounts where username=? and acc_type=?");
			pst.setString(1, userName);
			pst.setString(2, "S");
			rs = pst.executeQuery();
			if(rs.next()) {
				accountBalance=rs.getDouble(1);
			}
			System.out.println("account Balance is : "+accountBalance);
			System.out.println("account Balance is : "+amount);
			accountBalance = accountBalance-amount;
			pst = con.prepareStatement("update accounts set amount = ? where username=? and acc_type=?");
			pst.setDouble(1, accountBalance);
			pst.setString(2, userName);
			pst.setString(3, "S");
			count=pst.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)
				DBConnect.closeResultSet(rs);
			if(pst!=null)
				DBConnect.closeConnection(con);
			if(con!=null)
				DBConnect.closeConnection(con);
		}
		return (count==1);
	}
}
