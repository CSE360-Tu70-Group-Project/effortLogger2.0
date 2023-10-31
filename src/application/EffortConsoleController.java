/*
 * CSE 360 Tu 9:00-10:15, Session C
 * Prof Carter
 * 10/29/2023
 * Andrew Mitchell, Andrew Hu, Divineseed Olorunfemi
 */
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class EffortConsoleController {

	//initialize  FXML objects/interactables
	@FXML private Rectangle clockRectangle;
	@FXML private Label clockLabel;
	@FXML private Button startActivity, stopActivity, editor, defectConsole, definitions, logs, supervisor;
	@FXML private ChoiceBox project, lifeCycleStep, effortCategory, deliverable;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//when the "start activity" button is clicked
	public void onStartActivity(ActionEvent event) {
		clockRectangle.setFill(Color.GREEN);
		clockLabel.setText("Clock is running");
	}
	//when the "stop activity" button is clicked
	public void onStopActivity(ActionEvent event) {
		clockRectangle.setFill(Color.web("#ff491f"));
		clockLabel.setText("Clock is stopped");
	}
	//helper function, opens a specified FXML page
	public void goToScene (ActionEvent event, String fxmlScene) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(fxmlScene));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root, 960, 540);
		stage.setScene(scene);
		stage.show();
	}
	//opens Effort Log Editor
	public void onEditor(ActionEvent event) throws IOException {
		goToScene(event, "EffortLogEditor.fxml");
	}
	//opens Defect Console
	public void onDefectConsole(ActionEvent event) throws IOException {
		goToScene(event, "DefectConsole.fxml");
	}
	//opens Definitions page
	public void onDefinitions(ActionEvent event) throws IOException {
		goToScene(event, "Definitions.fxml");
	}
	//opens Logs page
	public void onLogs(ActionEvent event) throws IOException {
		goToScene(event, "Logs.fxml");
	}
	//opens Supervisor console
	public void onSupervisor(ActionEvent event) throws IOException {
		goToScene(event, "SupervisorConsole.fxml");
	}
	
}
