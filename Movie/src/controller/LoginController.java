package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.LoginModel;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

public class LoginController implements Initializable {
	
	public LoginModel loginModel =new LoginModel();
	
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private Label lblStatus, lblStatus1;
	
	@FXML
	private Button btnRegister;
	@FXML
	private Button adminlogin;

	// Event Listener on Button.onAction
	@FXML
	public void Login(ActionEvent event) throws IOException
	{
		try
		{
			if(loginModel.isLogin(txtUsername.getText(),txtPassword.getText()))
			{
				lblStatus.setText("Login Successful");
				//((Node)event.getSource()).getScene().getWindow().hide();
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
				Scene scene = new Scene(root);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			}
			else
			{
				lblStatus.setText("Login Unsuccessful");
			}
		}
		catch(SQLException e)
		{
			lblStatus.setText("Login Unsuccessful");
			e.printStackTrace();
		}
	}

	public void Register(ActionEvent r_event) throws IOException
	{
		if(r_event.getSource()==btnRegister)
		{
			//lblStatus1.setText("Registration Successful");
			//((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/Register.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else
		{
			lblStatus1.setText("Registered unSuccessfully");
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		if (loginModel.isDBConnected())
		{
					lblStatus.setText("Connected");
		}
		else
		{
			lblStatus.setText("Not Connected");
		}
	}

	public void adminlogin(ActionEvent event) throws IOException {
		if(event.getSource()==adminlogin)
		{
			if((txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin")))
		
		{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/admin.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();}
		
	}
}
}