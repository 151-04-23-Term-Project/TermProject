/*1. Login for the first time
2. User launches the app, and it shows the login page.
3. User provides the default password, and the app senses it's the first-
time login, redirects the user to the change password page.
4. Logout
The app returns to the login page
*/
package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;
    private TextField usernameField;
    private PasswordField passwordField;
    private boolean isFirstTimeLogin = true;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        GridPane gridPane = createLoginForm();
        Scene scene = new Scene(gridPane, 450, 450);
        primaryStage.setTitle("Insert some title");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createLoginForm() {
        GridPane gridPane = new GridPane();       // use GridPane to display
        gridPane.setPadding(new Insets(10));      // format
        gridPane.setVgap(20);
        
        // create and position labels/buttons
        Label welcomeLabel = new Label("Welcome user! Enter your password:");
        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Button logoutButton = new Button("Logout");

        // assign positions to labels/button
        gridPane.add(welcomeLabel, 0, 0);		// Welcome Label		
        gridPane.add(passwordLabel, 0, 1);		// Password Label	
        gridPane.add(passwordField, 1, 1);       
        gridPane.add(loginButton, 0, 2);		// Login button
        gridPane.add(logoutButton, 2, 2);		// Logout button
        
        // assign button actions
        loginButton.setOnAction(e -> handleLogin());
        logoutButton.setOnAction(e -> createLoginForm());

        return gridPane;
    }

    private void handleLogin() {
        String password = passwordField.getText();

        if (isFirstTimeLogin && password.equals("p")) {
            showChangePasswordPage();
        } else {
            // Perform login validation logic here
        if  (password.equals("something")) {
                showMainPage();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid password!");
                alert.showAndWait();
            }
        }
    }

    private void showChangePasswordPage() {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(5);

        Label newPasswordLabel = new Label("New Password:");
        PasswordField newPasswordField = new PasswordField();
        Button changePasswordButton = new Button("Change Password");

        gridPane.add(newPasswordLabel, 0, 0);
        gridPane.add(newPasswordField, 1, 0);
        gridPane.add(changePasswordButton, 1, 1);

        changePasswordButton.setOnAction(e -> {
            String newPassword = newPasswordField.getText();
            // Save the new password logic here

            isFirstTimeLogin = false;
            showMainPage();
        });

        Scene scene = new Scene(gridPane, 450, 500);
        primaryStage.setScene(scene);
    }

    private void showMainPage() {
        // Logic to show the main page after successful login

        GridPane gridPane = createLoginForm();
        Scene scene = new Scene(gridPane, 450, 500);
        primaryStage.setScene(scene);
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
