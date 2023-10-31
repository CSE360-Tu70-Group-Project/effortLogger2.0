/*
 * CSE 360 Tu 9:00-10:15, Session C
 * Prof Carter
 * 10/29/2023
 * Andrew Mitchell, Andrew Hu, Divineseed Olorunfemi
 */
package application;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EffortConsole {
	//Initialize FXML interactives & related variables
	@FXML private Button proceed;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//Nagivate back to main console
	public void onProceed(Event event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("EffortConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root, 960, 540);
		stage.setScene(scene);
		stage.show();
	}
	
}
