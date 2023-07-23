package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PreLoginController {

    @FXML
    private Button FirstTime;

    @FXML
    private Button Return;
    
    
    Stage stage;
	BorderPane root;
    @FXML
    void DefaultLogin(MouseEvent event) throws Exception{
    	stage = (Stage) FirstTime.getScene().getWindow();
    	root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/LoginPage.fxml"));
    	stage.setTitle("Initial Login");
    	stage.setScene(new Scene(root));
		stage.show();
    }

    @FXML
    void ReturnLogin(MouseEvent event) throws Exception{
    	stage = (Stage) Return.getScene().getWindow();
    	root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/ReturnLoginPage.fxml"));
    	stage.setTitle("Returning Login");
    	stage.setScene(new Scene(root));
		stage.show();

    }

}