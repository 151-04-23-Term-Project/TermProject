package controller;

import javafx.collections.FXCollections;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ReturnLoginController {

    @FXML
    private Button LoginButton;
    
    @FXML
    private Button ResetPass;
    
    Stage stage;
	BorderPane root;
    
    @FXML
    void GoReset(MouseEvent event) throws Exception{
    	stage = (Stage) ResetPass.getScene().getWindow();
    	root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/ResetPassword.fxml"));
		stage.setTitle("Reset Password");
		stage.setScene(new Scene(root));
		stage.show();
    }

    @FXML
    void handleLogin(MouseEvent event) throws Exception{
    	stage = (Stage) LoginButton.getScene().getWindow();
    	root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/LoginSuccessPage.fxml"));
		stage.setTitle("Main Page");
		stage.setScene(new Scene(root));
		stage.show();

    }

}