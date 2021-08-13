package Controller;

import Entity.PwGenerator;
import DB.UserDAO;
import Entity.SmsAuth;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateUser extends Application implements Initializable, ControlledScreen {

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
    public void generatePassword(ActionEvent event){
        PwGenerator pw = new PwGenerator();
        String randomPassword = pw.generateRandomPassword();
        password.setText(randomPassword);
    }
    @FXML
    public void generateGooglePassword(ActionEvent event){
        SmsAuth authSms = new SmsAuth();
        String tfaPassword = authSms.generateSecretKey();
        googlePassword.setText(tfaPassword);
    }

    @FXML
    public void setBack(ActionEvent event){
        //INVULLEN
    }

    @FXML
    public void updateUser(ActionEvent event){
        UserDAO personDAO = new UserDAO();
        String hashedPassword = org.mindrot.jbcrypt.BCrypt.hashpw(password.getText(), org.mindrot.jbcrypt.BCrypt.gensalt());
        String hashedTfa = org.mindrot.jbcrypt.BCrypt.hashpw(googlePassword.getText(), org.mindrot.jbcrypt.BCrypt.gensalt());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //List for combobox Gender
        ObservableList<String> genderList = FXCollections.observableArrayList("M", "F");
        gender.setItems(genderList);
        //List for combobox role
        ObservableList<String> roleList =  FXCollections.observableArrayList("Tutor","Tutee");
        role.setItems(roleList);
    }


    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("../view/updateUser.fxml"));
        Scene scene = new Scene(root, 1316, 627);
        stage.setTitle("Update user");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void setScreenParent(ScreenController screenPage) {
        this.myController = screenPage;
    }

    //@FXML
    //public void goBack(ActionEvent event) {
        //this.myController.setScreen(GUI.Main.Home);
   // }
}