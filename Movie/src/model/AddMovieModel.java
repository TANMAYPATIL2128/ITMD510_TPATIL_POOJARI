package model;

import java.sql.SQLException;
import java.sql.Statement;

import dao.DBConnect;


public class AddMovieModel extends DBConnect{
	
	private String movieid, title;

		public AddMovieModel(String movieid,String title) {
		super();
		this.movieid = movieid;
		this.title = title;
	}
	public String getMovieid() {
		return movieid;
	}

	public void setMovieid(String movieid) {
		this.movieid = movieid;}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

		// Declare DB objects
		DBConnect conn = null;
		Statement stmt = null;
				
				public AddMovieModel()
				{
					conn = new DBConnect();
					
				}
				
				public void adding_movies() {
					// INSERT INTO BANK TABLE
					try {
						// Execute a query
						System.out.println("Inserting records into the table...");
						stmt = DBConnect.connect().createStatement();
						String sql = null;

						// Include all object data to the database table

						sql = "insert into movie(movieid,title) values ('"+ movieid +"','"+title+"')";
						stmt.executeUpdate(sql);
						System.out.println("Movie Added");

						DBConnect.connect().close();
					} catch (SQLException se) {
						se.printStackTrace();
					}
	}

	
}
