package model;

import java.sql.SQLException;
import java.sql.Statement;

import dao.DBConnect;

public class ClientModel extends DBConnect {
	
	private String userid, fname, lname, password,mobile;
	
	public ClientModel(String userid,String password, String firstname, String lastname, String mobile) {
		super();
		this.userid = userid;
		this.password = password;
		this.fname = firstname;
		this.lname = lastname;
		this.mobile = mobile;
		
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getmobile() {
		return mobile;
	}

	public void setmobile(String mobile) {
		this.mobile = mobile;
	}


		// Declare DB objects
		DBConnect conn = null;
		Statement stmt = null;
		
		public ClientModel()
		{
			conn = new DBConnect();
			
		}
		
		public void user_Registration() {

			// INSERT INTO BANK TABLE
			try {
				// Execute a query
				System.out.println("Inserting records into the table...");
				stmt = DBConnect.connect().createStatement();
				String sql = null;

				// Include all object data to the database table

				sql = "insert into customer_login(userid,password,firstname,lastname,mobile) values ('"+ userid +"','"+password+"','"+fname+"','"+lname+"','"+mobile+"')";
				stmt.executeUpdate(sql);
				System.out.println("User Record created");

				DBConnect.connect().close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
}