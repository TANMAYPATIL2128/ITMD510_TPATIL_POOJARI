package model;

import javafx.fxml.FXML;

import java.sql.SQLException;
import java.sql.Statement;

import dao.DBConnect;
import javafx.event.ActionEvent;

public class DeleteMovieModel extends DBConnect {
	
	private String title;
	
	public DeleteMovieModel(String title) {
		super();
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	// Declare DB objects
			DBConnect conn = null;
			Statement stmt = null;
					
					public DeleteMovieModel()
					{
						conn = new DBConnect();
						
					}

					public void deleting_movies() {
						// INSERT INTO BANK TABLE
						try {
							// Execute a query
							System.out.println("Deleting records from the table...");
							stmt = DBConnect.connect().createStatement();
							String sql = null;

							// Include all object data to the database table

							sql = "Update movie set title='bec' where (title= '"+title+"')";
							stmt.executeUpdate(sql);
							System.out.println("Movie Updated");

							DBConnect.connect().close();
						} catch (SQLException se) {
							se.printStackTrace();
						}
		}

		
	}
