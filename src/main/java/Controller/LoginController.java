package Controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;


public class LoginController extends Application implements ControlledScreen {

    private ScreenController myController;


    //Login attributes
    @FXML public TextField inputEmail;
    @FXML public PasswordField inputPassword;
    @FXML public Label loginError;

    private static String loggedInUser = null;

    public static String getLoggedInUser() {
        return loggedInUser;
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("../../resources/Login.fxml"));

        Scene scene = new Scene(root, 400, 425);
        stage.setTitle("Log in");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void login(ActionEvent event) throws IOException {
        System.out.println("Test");
    }

    @Override
    public void setScreenParent(ScreenController screenPage) {
        this.myController = screenPage;
    }

}