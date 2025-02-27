import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomePageControl implements Initializable{

    @FXML private Button addButton;

    @FXML private Button homeButton;

    @FXML private Button listButton;

    @FXML private AnchorPane myBorderCenter;

    @FXML private AnchorPane myBorderLeft;

    @FXML private AnchorPane myBorderUp;

    @FXML private Label myUser;
    @FXML private AnchorPane innerAnchorCenter1;

    @FXML private AnchorPane innerAnchorCenter2;

    @FXML private AnchorPane innerAnchorCenter3;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Stage employeeRegisterStage; // Keep a reference to the Stage
    private EmployeeRegister employeeRegisterController ;
    @FXML
    public void addAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeAdd.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            employeeRegisterController = loader.getController();
            employeeRegisterController.setHomePageControl(this);
            employeeRegisterStage = new Stage(); // Initialize the Stage
            employeeRegisterStage.setScene(scene);
            employeeRegisterStage.setTitle("Employee Add Section");

            employeeRegisterStage.show();
    
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void homeAction(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
            scene  = new Scene(root);
            stage =(Stage) ((Node) homeButton).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Stage listStage;
    EmployeeList employeeListController;
    @FXML
    void listAction(ActionEvent event) {
      
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeList.fxml"));
            try {
                Parent root = loader.load();
                listStage = new Stage();
                listStage.setScene(new Scene(root));
                listStage.setTitle("Employee List");
    
                employeeListController = loader.getController();
                employeeListController.setEmployeeDatas(EmployeeData.employeeList); // Set the data
    
                listStage.setOnCloseRequest(e -> listStage = null); 
    
                listStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
          

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myBorderLeft.setStyle("-fx-background-color: #2e86c1");
        myBorderUp.setStyle("-fx-background-color: #b3b6b7");

        innerAnchorCenter1.setStyle("-fx-background-color: #2e86c1");
        innerAnchorCenter2.setStyle("-fx-background-color: #2e86c1");
        innerAnchorCenter3.setStyle("-fx-background-color: #2e86c1");
    }

}
