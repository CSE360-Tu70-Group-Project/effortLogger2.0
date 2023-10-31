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

public class SupervisorConsoleController {

	@FXML private Button proceed;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void onProceed(Event event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("EffortConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root, 960, 540);
		stage.setScene(scene);
		stage.show();
	}
	
}
