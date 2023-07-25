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
 * This class is used to control the change password page for an initial login from the user. The user will automatically be redirected to this page after entering the default password.
 */
public class ChangePWController {
	
	//ObservableList<String> questionsList = FXCollections.observableArrayList("Who is your favorite author?","What is your favorite book?","What is your first pet's name?");
	
	@FXML private TextField securityQuestionField;
	
	@FXML private ComboBox<String> questionOptionsBox;
	
	/*@FXML private void initialize() {
		questionOptionsBox.setValue("Who is your favorite author?");
		questionOptionsBox.setItems(questionsList);
	}*/
	
    @FXML
    private Button ChangePWButton;
    
    /**
     * This method is used to redirect the application after successfully filling out the required fields to change the password. 
     * The required fields include a custom security question, security question answer, default password, new password, confirm new password.
     * @param event is a mouse click on the change password button confirming changes
     * @throws Exception
     */

    @FXML
    void goNext(MouseEvent event) throws Exception{
    	Stage stage = (Stage) ChangePWButton.getScene().getWindow();
    	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/LoginSuccessPage.fxml"));
    	stage.setTitle("Stage 2");
    	stage.setScene(new Scene(root));
		stage.show();
    }

	

	
	
}
