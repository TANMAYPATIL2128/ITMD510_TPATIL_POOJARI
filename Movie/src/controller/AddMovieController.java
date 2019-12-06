package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.DBConnect;
import javafx.event.ActionEvent;

public class AddMovieController implements Initializable {
	Connection conn =null;
	 PreparedStatement stmt = null;
	@FXML
	private Button add;
	@FXML
	private Button back;
	@FXML
	private Label isConnected1;
	@FXML
	private TextField Movieid;
	@FXML
	private TextField Title;
	

	
	// Event Listener on Button[#add].onAction
		@FXML
		public void add(ActionEvent add) throws SQLException{
			
			String sql = "insert into movie(movieid,title) values(?,?)";
			String movieid = Movieid.getText();
			String title = Title.getText();
			
			try
			{
				stmt = conn.prepareStatement(sql);
				stmt.setString(1,movieid);
				stmt.setString(2,title);
							
				
				int i = stmt.executeUpdate();
				if(i==1)
				{
					isConnected1.setText("Movie Added");
				}
				else
				{
					isConnected1.setText("Movie not added. Please check the connection.");
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
		

	// Event Listener on Button[#back].onAction
	public void back(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/admin.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		conn = DBConnect.connect();
		
	}
}
