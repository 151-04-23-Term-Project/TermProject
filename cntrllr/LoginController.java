package cntrllr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * This class handles the default password page that logs a user into the system for the first time. This class points the user to the change password page before going to the main journal page.
 */
public class LoginController {
	
	ObservableList<String> questionsList = FXCollections.observableArrayList("Who is your favorite author?","What is your favorite book?","What is your first pet's name?");
	
	@FXML private TextField securityQuestionField;
	
	@FXML private ComboBox<String> questionOptionsBox;
	
    @FXML
    private Button LoginButton;

    /**
     * TODO: Move variable to PreLoginController, which is the updated main page when application is launched.
     * @param event occurs when user enters default password and clicks login button
     * @throws Exception
     */
    @FXML
    void LoginDirect(MouseEvent event) throws Exception{
    	Stage stage = (Stage) LoginButton.getScene().getWindow();
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/ChangePassword.fxml"));
    	stage.setTitle("Change Password Page");
    	stage.setScene(new Scene(root));
		stage.show();

    }
/*
    void handleLogin(MouseEvent event) throws Exception {
//    	handle the logic for a new or not new log in
//    	TODO: add a variable to tell if its first time or not
    	boolean FirstLogIn = false;
		Stage stage = (Stage) LoginButton.getScene().getWindow();
		BorderPane root;
		//Changed to true
    	if (FirstLogIn == true) {
        	//root = (BorderPane)FXMLLoader.load(getClass().getResource("Journals.fxml"));
        	//stage.setTitle("Log In");
    		root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/ChangePassword.fxml"));
        	stage.setTitle("Change Password Page");
    	}
    	else {
    		root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/LoginSuccessPage.fxml"));
        	//root = (BorderPane)FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
        	//stage.setTitle("Change Password Page");
    		FirstLogIn = false;
    		stage.setTitle("Main Page");
    	}
    	stage.setScene(new Scene(root));
		stage.show();
    }
    */
	

	
	
}
