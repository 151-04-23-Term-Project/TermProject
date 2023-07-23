package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CreateJournalController {

    @FXML
    private Button Save;

    @FXML
    private Button Cancel;
    
    
    Stage stage;
	BorderPane root;
	
    @FXML
    void Return(MouseEvent event) throws Exception{
    	stage = (Stage) Save.getScene().getWindow();
    	root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/LoginSuccessPage.fxml"));
		stage.setTitle("Return to Main Page");
		stage.setScene(new Scene(root));
		stage.show();
    }

    @FXML
    void Save(MouseEvent event) throws Exception{
    	stage = (Stage) Cancel.getScene().getWindow();
    	root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/LoginSuccessPage.fxml"));
		stage.setTitle("Save Journal and Return to Main Page");
		//insert some saving action here
		stage.setScene(new Scene(root));
		stage.show();

    }
    
    
 

}