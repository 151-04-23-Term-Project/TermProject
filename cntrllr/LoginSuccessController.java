package cntrllr;


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
 * This class handles the main journal entry page for users. It has the option to direct users to logout (returning user login page) or have users start a new journal entry.
 */

public class LoginSuccessController {
		
	@FXML private TextField securityQuestionField;
	
	@FXML private ComboBox<String> questionOptionsBox;
	
	/*@FXML private void initialize() {
		questionOptionsBox.setValue("Who is your favorite author?");
		questionOptionsBox.setItems(questionsList);
	}*/
	
    @FXML
    private Button Logout;
    
    @FXML
    private Button NewEntry;
    
    
    Stage stage;
    BorderPane root;
    /**
     * This method directs user to a new journal creation page.
     * @param event occurs when user clicks button "New Entry" to create a new journal. Redirects user to journal creation page.
     * @throws Exception
     */
    
    @FXML
    void newJournal(MouseEvent event) throws Exception{
    	stage = (Stage) NewEntry.getScene().getWindow();
    	root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/CreateJournal.fxml"));
    	stage.setTitle("Create New Journal");
    	stage.setScene(new Scene(root));
		stage.show();
    }    
    /**
     * This method returns user to returning user login page.
     * @param event occurs when user clicks "Logout" button
     * @throws Exception
     */
    @FXML
    void goNext(MouseEvent event) throws Exception{
    	stage = (Stage) Logout.getScene().getWindow();
    	root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/ReturnLoginPage.fxml"));
    	stage.setTitle("Logout");
		stage.setScene(new Scene(root));
		stage.show();
    	
    }
  
	

	
	
}
