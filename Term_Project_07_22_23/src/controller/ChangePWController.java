package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
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
import javafx.stage.Stage;

/**
 * This class is used to control the change password page for an initial login from the user. The user will automatically be redirected to this page after entering the default password.
 */
public class ChangePWController {
	
	//ObservableList<String> questionsList = FXCollections.observableArrayList("Who is your favorite author?","What is your favorite book?","What is your first pet's name?");
	
	@FXML
    private TextField NewPass;

    @FXML
    private TextField ConfirmPass;

    @FXML
    private TextField SecQ;

    @FXML
    private TextField SecQAnswer;
	
	@FXML
    private TextField passEntry;
	
    @FXML
    private Button ChangePWButton;
    
    /**
     * This method is used to redirect the application after successfully filling out the required fields to change the password. 
     * The required fields include a custom security question, security question answer, default password, new password, confirm new password.
     * @param event is a mouse click on the change password button confirming changes
     * @throws Exception
     */

  //need more rigorous way to verify that fields are not blank, null does not work
    @FXML
    void goNext(MouseEvent event) throws Exception{
    	if(setSecQ() && verifyDefault() && confirmPass() == true) {
	    	Stage stage = (Stage) ChangePWButton.getScene().getWindow();
	    	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("/application/LoginSuccessPage.fxml"));
	    	stage.setTitle("Stage 2");
	    	stage.setScene(new Scene(root));
			stage.show();
    	}
		else {
			System.out.println("Please double check fields.");
			System.out.println("Sec Q: " + setSecQ());
			System.out.println("Verify Default: " + verifyDefault());
			System.out.println("Confirm Pass: " + confirmPass());
			//invalidResult.setVisible(true);
		}
    }

    public boolean verifyDefault(){
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
		
			return false;
    }

    public boolean confirmPass() {
    	String pass = NewPass.getText();
    	String cpass = ConfirmPass.getText();
    	Path path = Paths.get("src\\controller\\User_Password.txt");
    	String absPath = path.toAbsolutePath().toString();
    	absPath = absPath.replace("\\","\\\\");
    	if(pass.equals(cpass)) {
    		try {
    			PrintStream toFile = new PrintStream(new FileOutputStream(absPath));
        		toFile.print(pass);
        		toFile.close();
				
				if(pass != null && cpass != null && pass.equals(cpass) == true) {
					return true;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}	
    	
		return false;
    }
	
    
	public boolean setSecQ() {
		String question = SecQ.getText();
		String answer = SecQAnswer.getText();
		
    	Path pathQ = Paths.get("src\\controller\\SecQuestion.txt");
    	String absPathQ = pathQ.toAbsolutePath().toString();
    	absPathQ = absPathQ.replace("\\","\\\\");
    	
    	Path pathA = Paths.get("src\\controller\\SecAnswer.txt");
    	String absPathA = pathA.toAbsolutePath().toString();
    	absPathA = absPathA.replace("\\","\\\\");
    	try {
    		PrintStream toFileQ = new PrintStream(new FileOutputStream(absPathQ));
    		toFileQ.print(question);
    		toFileQ.close();
    		PrintStream toFileA = new PrintStream(new FileOutputStream(absPathA));
			toFileA.print(answer);
			toFileA.close();
			if (question != null && answer != null) {
				return true;
			}
    	}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return false;
		
	}
}
