/*
 * CSE 360 Tu 9:00-10:15, Session C
 * Prof Carter
 * 10/29/2023
 * Andrew Mitchell, Andrew Hu, Divineseed Olorunfemi
 */
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import application.Credential;
public class LoginController {
	
	//set list of valid login credentials
	private Credential[] credentials = {new Credential("johndoe", "password1", false), 
										new Credential("bigboss", "password2", true)};
	//initialize variables and FXML interactives
	String usernameIn, passwordIn;
	
	@FXML private TextField user;
	@FXML private PasswordField pass;
	@FXML private Label incorrect;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//On press of login button, checks if input from "user" and "pass" match a credential.
	public void login(ActionEvent event) throws IOException {
		usernameIn = user.getText();
		passwordIn = pass.getText();
		
		boolean match = false;
		
		for (int i = 0; i < credentials.length; i++) {
			if (usernameIn.equals(credentials[i].getUsername())) {
				if (passwordIn.equals(credentials[i].getPassword())) {
					match = true;
				}
			}
		}
		
		//If credentials match, moves to main console page. Otherwise, sets notification about incorrect login information.
		if(match) {
			Parent root = FXMLLoader.load(getClass().getResource("EffortConsole.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root, 960, 540);
			stage.setScene(scene);
			stage.show();
		} else {
			incorrect.setVisible(true);
		}
	}
}
