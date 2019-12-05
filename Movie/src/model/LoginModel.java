package model;

import java.sql.*;

import dao.DBConnect;

public class LoginModel {
	Connection connection;
	public LoginModel()
	{
		connection = DBConnect.connect();
		if(connection == null)
		{
			System.exit(1);
		}
	}
	
	public boolean isDBConnected()
	{
		try 
		{
			return !connection.isClosed();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isLogin(String user, String pass) throws SQLException
	{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query ="select * from customer_login where userid = ? and password = ?";
		try 
		{
			stmt = connection.prepareStatement(query);
			stmt.setString(1,user);
			stmt.setString(2,pass);
			
			rs = stmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
			
			
		}catch(Exception e)
		{
			return false;
		}finally
		{
			stmt.close();
			rs.close();
		}
	}
	
	
}