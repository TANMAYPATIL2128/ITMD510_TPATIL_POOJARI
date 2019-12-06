package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.DBConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RegisterController implements Initializable{
	
	 Connection conn =null;
	 PreparedStatement stmt = null;
	
	@FXML
	private TextField txtFname;
	@FXML
	private TextField txtLname;
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private TextField txtMobile;
	@FXML
	private Button Register;
	@FXML
	private Label lblStatus1;
	@FXML
	private Button back;
	
	public void handleRegister(ActionEvent register) throws SQLException
	{
		String sql = "insert into customer_login(userid,password,firstname,lastname,mobile) values(?,?,?,?,?)";
		String firstname = txtFname.getText();
		String lastname = txtLname.getText();
		String userid = txtUsername.getText();
		String password = txtPassword.getText();
		String mobile = txtMobile.getText();
		
		try
		{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,userid);
			stmt.setString(2,password);
			stmt.setString(3,firstname);
			stmt.setString(4,lastname);
			stmt.setString(5,mobile);
			
			int i = stmt.executeUpdate();
			if(i==1)
			{
				lblStatus1.setText("Data inserted");
			}
			else
			{
				lblStatus1.setText("Data not inserted. Please check the connection.");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			stmt.close();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		conn = DBConnect.connect();
		
	}

	public void back(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();}
	

}