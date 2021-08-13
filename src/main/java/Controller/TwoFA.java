package Controller;

import Entity.*;
import DB.*;
import GUI.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TwoFA extends Application implements ControlledScreen {

    private ScreenController myController;

    @FXML private TextField passwordInput;
    @FXML private Label message;

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("../view/twoAuth.fxml"));

        Scene scene = new Scene(root, 400, 450);
        stage.setTitle("2FA Authentication");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void setScreenParent(ScreenController screenPage) {
        this.myController = screenPage;
    }

    @FXML
    public void goToLogin(ActionEvent event){
        this.myController.setScreen(Main.login);
    }
}

