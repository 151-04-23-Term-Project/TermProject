package controller;

import java.sql.SQLException;
import java.util.List;

import database.Journal;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CreateJournalController {

    @FXML
    private Button Save;

    @FXML
    private Button Cancel;
    
    
    @FXML
    private TextField titleField;

    @FXML
    private TextField dateField;
    
    Stage stage;
	
    @FXML
    private BorderPane root;
    

    
	
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
        String titleText = titleField.getText();
        String dateText = dateField.getText();
        Journal.createNewJournal(titleText, dateText);
    }
    
    
 

}