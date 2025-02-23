import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class EmployeeList implements Initializable {

    @FXML public TableView<Employee> myTableWiev;
    @FXML public TableColumn<Employee, String> tJob;
    @FXML public TableColumn<Employee, String> tMail;
    @FXML public TableColumn<Employee, String> tName;
    @FXML public TableColumn<Employee, String> tSkills;
    @FXML public TableColumn<Employee, String> tSurname;
    @FXML public AnchorPane upAnchor;
    
    private ObservableList<Employee> employeeData = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        upAnchor.setStyle("-fx-background-color:rgb(179, 181, 183)");

        tName.setCellValueFactory(new PropertyValueFactory<Employee, String>("Name"));
        tSurname.setCellValueFactory(new PropertyValueFactory<Employee, String>("Surname"));
        tMail.setCellValueFactory(new PropertyValueFactory<Employee, String>("Email"));
        tJob.setCellValueFactory(new PropertyValueFactory<Employee, String>("Job"));
        tSkills.setCellValueFactory(new PropertyValueFactory<Employee, String>("Skills"));
        setEmployeeDatas(employeeData);

    }

    public void setEmployeeDatas(ObservableList<Employee> employeeData) {
        myTableWiev.setItems(employeeData);

    }
 
}
