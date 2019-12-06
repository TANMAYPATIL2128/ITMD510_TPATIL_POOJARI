package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MovieModel;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.DBConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class DeleteMovieController implements Initializable {
	Connection conn =null;
	 PreparedStatement stmt = null;
	@FXML
	private Button delete;
	@FXML
	private Button back;
	@FXML
	private TextField Title;
	@FXML
	private Label isConnected1;
	
	//DBConnect conn=null;

	// Event Listener on Button[#delete].onAction
	@FXML
	public void delete(ActionEvent delete) throws IOException {
		
		String sql = "update movie set title='bec' where title=?";
		String title = Title.getText();
		
		try
		{
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,title);
						
			
			int i = stmt.executeUpdate();
			if(i==1)
			{
				isConnected1.setText("Movie Updated");
			}
			else
			{
				isConnected1.setText("Movie not deleted. Please check the connection.");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		conn = DBConnect.connect();
	}
	
	public void back(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/admin.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();}
	}
	
