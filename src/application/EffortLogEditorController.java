/*
 * CSE 360 Tu 9:00-10:15, Session C
 * Prof Carter
 * 10/29/2023
 * Andrew Mitchell, Andrew Hu, Divineseed Olorunfemi
 */
package application;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import application.editConsoleInputMonitorHelper;

public class EffortLogEditorController {
	//initialize list of options for choice boxes
	ObservableList<String> lifeCycleStepList = 
			FXCollections.observableArrayList(
					"Problem Understanding", "Conceptual Design Plan", "Requirements", "Conceptual Design Overflow",
					"Conceptual Design", "Conceptual Design Review","Detailed Design Plan", "Detailed Design/Prototype",
					"Implementation Plan");
	ObservableList<String> effortCategoryList = 
			FXCollections.observableArrayList("PLans", "Deliverables", "Interruptions", "Defects", "Others");
	//initialize variables and FXML pieces
	private String stopIn, startIn, dateIn;
	private boolean wrongStopBool, wrongStartBool, wrongDateBool;
	@FXML
	private Button proceed;
	@FXML
	private TextField stopTimeInput;
	@FXML
	private TextField startTimeInput;
	@FXML
	private Button updateButton;
	@FXML
	private TextField dateInput;
	@FXML
	private ChoiceBox lifeCycleStep;
	@FXML
	private ChoiceBox effortCategory;
	@FXML
	private ChoiceBox project;
	@FXML
	private Label wrongStop;
	@FXML
	private Label wrongStart;
	@FXML
	private Label wrongDate;
	@FXML
	private Label updatedEntry;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private void initialize() {
		lifeCycleStep.setItems(lifeCycleStepList);
		effortCategory.setItems(lifeCycleStepList);
	}
	public void updateLogEvent(ActionEvent event) throws IOException {
		
		//init variables
		String in;
		stopIn = stopTimeInput.getText();
		startIn = startTimeInput.getText();
		dateIn = dateInput.getText();
		wrongStopBool = true;
		wrongStartBool = true;
		wrongDateBool = true;
		editConsoleInputMonitorHelper check = new editConsoleInputMonitorHelper();
		
		// check if input format of date is correct, yyyy-mm-dd
		wrongDateBool = check.checkInvalidDate(dateIn);
		
		
		// check if input format of start time is correct, hh:mm:ss
		wrongStartBool = check.checkInvalidStart(startIn);
		
		
		
		// check if input format of stop time is correct, hh:mm:ss
		wrongStopBool = check.checkInvalidEnd(stopIn);
		
		
		
		/*display incorrect text input warnings if needed
		 * If true, sets incorrect input warning to visible, otherwise removes input warning
		 */
		if(wrongDateBool) {
			wrongDate.setVisible(true);
		} else {
			wrongDate.setVisible(false);
		}
		if(wrongStartBool) {
			wrongStart.setVisible(true);
		} else {
			wrongStart.setVisible(false);
		}
		if(wrongStopBool) {
			wrongStop.setVisible(true);
		} else {
			wrongStop.setVisible(false);
		}
		//if all inputs are correct, display message telling user log is updated
		if(!wrongDateBool && !wrongStartBool && !wrongStopBool) {
			updatedEntry.setVisible(true);
		} else {
			updatedEntry.setVisible(false);
		}
	}
	
	//navigating back to main console page
	public void onProceed(Event event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("EffortConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root, 960, 540);
		stage.setScene(scene);
		stage.show();
	}
	
}