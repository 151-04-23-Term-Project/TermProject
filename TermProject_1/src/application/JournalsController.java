package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JournalsController {
	
//	ObservableList<String> questionsList = FXCollections.observableArrayList("Who is your favorite author?","What is your favorite book?","What is your first pet's name?");
	
//	@FXML private TextField securityQuestionField;
	
//	@FXML private ComboBox<String> questionOptionsBox;
	
	/*@FXML private void initialize() {
		questionOptionsBox.setValue("Who is your favorite author?");
		questionOptionsBox.setItems(questionsList);
	}*/
	
    @FXML
    private Button NewJournalFormButton;

    @FXML
    void goNext(MouseEvent event) throws Exception{
    	Stage stage = (Stage)  NewJournalFormButton.getScene().getWindow();
    	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("CreateJournal.fxml"));
    	stage.setTitle("Create New Journal");
    	stage.setScene(new Scene(root));
		stage.show();
    	//Stage stage = ChangePWButton.getScene().getWindow();
    }

}
	