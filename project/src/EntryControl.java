import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EntryControl  implements Initializable{
    private String name = "admin"; 
    @FXML
    private AnchorPane myAnchor1;

    @FXML
    private AnchorPane myAnchor2;

    @FXML
    private Label myLabel;

    @FXML
    private Button myLogin;

    @FXML
    private PasswordField myPassword;

    @FXML
    private TextField myName;
    @FXML
    private AnchorPane main_anchor;
    @FXML
    //control the login button
    void Login(ActionEvent event) {
        if(myName.getText() == null || myName.getText().isEmpty()){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("You cant leave the fields empty.");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in the fields.");
            alert.showAndWait();
        }
        if(myPassword.getText() == null || myPassword.getText().isEmpty()){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("You cant leave the fields empty.");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in the fields.");
            alert.showAndWait();
        }

        else if(myName.getText().equals(name)){
            if(myPassword.getText() != null || !myPassword.getText().isEmpty()){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("Login Successful");
                alert.setContentText("You have successfully logged in.");
                alert.showAndWait();
                try{
                // Load the home page
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScene.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Home Page");
                stage.show();

                // Close the current window
                Stage current = (Stage) myLogin.getScene().getWindow();
                current.close();

                // Get the current date and time
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                String entryDate = now.format(dateFormatter);
                String entryTime = now.format(timeFormatter);

                // Show the date and time in an alert
                Alert alertInfo = new Alert(AlertType.INFORMATION);
                alertInfo.setHeaderText("Entry Date and Time");
                alertInfo.setContentText("Date: " + entryDate + "\nTime: " + entryTime);
                alertInfo.setX(50);
                alertInfo.setY(50);
                alertInfo.showAndWait();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         myAnchor1.setStyle("-fx-background-color: #00FFFF");
         myAnchor2.setStyle("-fx-background-color:rgb(255, 255, 255)");
    }
}
