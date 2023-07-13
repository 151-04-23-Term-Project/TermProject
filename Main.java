import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private String user;

    @Override
    public void start(Stage mainStage) {
        mainStage.setTitle("Sign-In");

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button signInButton = new Button("Sign In");


        VBox signInLayout = new VBox(10); // create a layout for the signin page
        signInLayout.setPadding(new Insets(10)); // add some padding for a layout
        // add components to our layout 
        signInLayout.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, signInButton); 

        // create a new scene with out sign in layput
        Scene scene = new Scene(signInLayout, 300, 300);
        mainStage.setScene(scene);
       
        mainStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
