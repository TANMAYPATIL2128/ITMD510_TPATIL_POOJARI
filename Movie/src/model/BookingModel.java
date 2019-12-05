package model;

import java.sql.Connection;
import java.sql.SQLException;

import dao.DBConnect;

public class BookingModel {
		Connection connection;
		
		public BookingModel()
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
}
