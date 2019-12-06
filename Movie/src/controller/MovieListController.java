package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dao.DBConnect;
import model.MovieModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;
public class MovieListController implements Initializable{
	DBConnect conn=null;
	public MovieListController(){
		DBConnect conn=null;	}
	@FXML
	private Button back;
	
	@FXML
	private TableView movieTable;
	@FXML
	private TableColumn<MovieModel,String> movieName;
	ObservableList<MovieModel> oblist= FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		movieName.setCellValueFactory(new PropertyValueFactory<>("movieName"));
		// TODO Auto-generated method stub
		ResultSet res=null;
		String show = "select * from movie";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=conn.connect().prepareStatement(show);
			res=preparedStatement.executeQuery();
			while(res.next()) {
				MovieModel m=new MovieModel(res.getString("title"));
				oblist.add(m);
				movieTable.setItems(oblist);
				//combolist.setValue(oblist)
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	public void back(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();}
	
	
}
