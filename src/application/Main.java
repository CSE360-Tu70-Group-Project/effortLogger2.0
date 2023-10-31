/*
 * CSE 360 Tu 9:00-10:15, Session C
 * Prof Carter
 * 10/29/2023
 * Andrew Mitchell, Andrew Hu, Divineseed Olorunfemi
 */
package application;
	
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene loginScene = new Scene(root, 960, 540);
			//loginScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("EffortLogger 2.0 prototype");
			primaryStage.setScene(loginScene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}