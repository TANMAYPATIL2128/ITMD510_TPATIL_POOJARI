package dao;

import java.sql.Connection;
import java.sql.DriverManager; 

  
public class DBConnect {
 
	private static String url = "jdbc:mysql://www.papademas.net:3307/510fp";
	private static String username = "fp510";
	private static String password = "510";

//public Connection connect;
public static Connection connect()
{
	try 
	{
		Connection conn=DriverManager.getConnection(url, username, password);;
		return conn;
	}
	catch(Exception e)
	{
		return null;
	}
}
}