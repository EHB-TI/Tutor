package Controller;
import DB.UserDAO;
import Entity.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import java.net.URL;
import java.util.ResourceBundle;


public class Register extends Application implements ControlledScreen, Initializable {

    private ScreenController myController;

    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField email;
    @FXML private DatePicker birthdate;
    @FXML private TextField password;
    @FXML private ComboBox<String> gender;
    @FXML private ComboBox<String> role;
    @FXML private TextField googlePassword;

    @FXML
    public void generateGooglePassword(ActionEvent event){
        SmsAuth smsAuth = new SmsAuth();
        String tfaPassword = smsAuth.generateSecretKey();
        googlePassword.setText(tfaPassword);
    }

    @FXML
    public void generatePassword(ActionEvent event){
        PwGenerator pw = new PwGenerator();
        String randomPassword = pw.generateRandomPassword();
        password.setText(randomPassword);
    }

    @FXML // CREATE USER LOGICA MET DB

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> roleList =  FXCollections.observableArrayList("Tutor","Tutee");
        role.setItems(roleList);

        ObservableList<String> genderList = FXCollections.observableArrayList("M", "F");
        gender.setItems(genderList);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("../../resources/Register.fxml"));
        Scene scene = new Scene(root, 700, 700);
        stage.setTitle("Create User");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void setScreenParent(ScreenController screenPage) {
        this.myController = screenPage;
    }


    @FXML
    public void goToHome(ActionEvent event) {
        //this.myController.setScreen(Main.); NOG AANVULLEN HOME PAGE NOG MAKEN
    }
}