package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

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
import javafx.scene.text.Text;
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
    
    @FXML
    private TextField passEntry;
    
    @FXML
    private Text invalidResult;
    
    //invalidResult.setDisable(true);

    /**
     * TODO: Move variable to PreLoginController, which is the updated main page when application is launched.
     * @param event occurs when user enters default password and clicks login button
     * @throws Exception
     */
    @FXML
    void LoginDirect(MouseEvent event) throws Exception{
    	invalidResult.setVisible(false);
    	boolean res = verifydefault();
    	if (res == true) {
	    	Stage stage = (Stage) LoginButton.getScene().getWindow();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/ChangePassword.fxml"));
	    	stage.setTitle("Change Password Page");
	    	stage.setScene(new Scene(root));
			stage.show();
    	}
    	else {
    		invalidResult.setVisible(true);
    		
    	}

    }
    
    
    public boolean verifydefault(){
    	//enter path to default password file to authenticate
	    //File file = new File("C:\\Users\\Owner\\eclipse-workspace\\Term_Project_07_22_23\\src\\controller\\Default_Password.txt");
    	Path path = Paths.get("src\\controller\\Default_Password.txt");
    	String absPath = path.toAbsolutePath().toString();
    	absPath = absPath.replace("\\","\\\\");
    	//System.out.println(absPath);
	    File file = new File(absPath);
		
		//Scanner scanner;
		try {
			String entry = passEntry.getText();
			String password = null;
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				password = scanner.next();	
		    }
			scanner.close();
			if (password.equals(entry)) {
				return true;
			}
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			System.out.println("failed");
			return false;
    }
	

	
	
}
