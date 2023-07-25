package cntrllr;

import database.Journal;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This class is used to create a new journal within the application. After creating a new journal, the user will have the option to save the journal. 
 * If at any time the user wishes to leave the page, they can cancel the journal creation by the cancel button.
 */
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
	BorderPane root;
	
	/**
	 * This method cancels journal creation and redirects user to main journal screen.
	 * @param event occurs when return button is clicked
	 * @throws Exception
	 */
	
    @FXML
    void Return(MouseEvent event) throws Exception{
    	stage = (Stage) Save.getScene().getWindow();
    	root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/LoginSuccessPage.fxml"));
		stage.setTitle("Return to Main Page");
		stage.setScene(new Scene(root));
		stage.show();
    }
    /**
     * This method saves the user's journal progress so far and redirects to main journal screen.
     * @param event is created when save button is clicked
     * @throws Exception
     */

    @FXML
    void Save(MouseEvent event) throws Exception{
        String titleText = titleField.getText();
        String dateText = dateField.getText();
        Journal.createDatabase();
        Journal.createTable();
        Journal.createNewJournal(titleText, dateText);

    }
    
    
 

}