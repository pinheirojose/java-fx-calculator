package controller;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		mainWindow();
		//primaryStage.show();
	}
	
	public void mainWindow() {
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MainWindowView.fxml"));
			AnchorPane pane = loader.load();
			
			MainWindowController mainWindowController = loader.getController();
			mainWindowController.setMain(this);
			
			Scene scene = new Scene(pane);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} 

		catch (IOException e) {
			// TODO: handle exception
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}