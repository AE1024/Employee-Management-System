import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class EmployeeRegister implements Initializable {
    public String employeeJob;
    public String employeeName;
    public String employeeSurname;
    public String employeeMail;
    //choice box for jobs
    @FXML private ChoiceBox<String> jobChoices;
    //menu bar for skills
    @FXML private MenuBar mySkillMenuBar;
    //back button
    @FXML private Button completeBack;
    //add button
    @FXML private Button completeAdd;
    //clear button
    @FXML private Button completeClear;
    //menu for skills
    @FXML private Menu mySkillMenu;

    @FXML private TextField mailText;

    @FXML private TextField nameText;

    @FXML private TextField surnameText;

    @FXML private AnchorPane leftAnchor;

    public List<String>selectedSkills = new ArrayList<>();
    public List<Employee> employeeList = new ArrayList<>();
    private String[] jobs = {"Software","Mechanical","Electrical"};
//for every job , there are some skills
private String[] software = {"C/C++","Java","Python","Assembly","Linux","C#","UAVs","Go","R","Backend","AI","Frontend","Embedded System","Cyber Security","RTOS","Data Science","Data Engineer","Agile","Scrum"};

private String[] mehcanical = {"SolidWorks", "AutoCAD", "CATIA","ANSYS", "MATLAB", "Simulink","Robotics & Automation","CNC Machining"};

private String[] electrical = {"PCB", "VLSI", "FPGA","MATLAB", "SPICE", "Simulink","Power Systems", "High Voltage Engineering","Embedded Systems", "IoT", "Microcontrollers","Signal Processing & Communications","PCB Design"};

    @Override 
    public void initialize(URL location, ResourceBundle resources) {
        leftAnchor.setStyle("-fx-background-color:rgb(48, 146, 233);");
        jobChoices.getItems().addAll(jobs); 
        jobChoices.setVisible(true);
        //it will arrange the skills according to the job
        jobChoices.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null)
            updateSkillMenu(newValue);
        });
        jobChoices.getSelectionModel().getSelectedItem();
        
    }

    public void writeUpdatedSkillMenu(){
        selectedSkills.clear();
    for(MenuItem selectedSkillsFromMenu : mySkillMenu.getItems()){
        CheckMenuItem itemsSelected = (CheckMenuItem) selectedSkillsFromMenu;
        if(itemsSelected.isSelected()){
            selectedSkills.add(itemsSelected.getText());
        }
      }
      System.out.println("Selected Skills: " + selectedSkills);
    }

    public String[] skills;
    //setting skills based on which job is selected
    public void updateSkillMenu(String selectedJob) {
        mySkillMenu.getItems().clear(); // Clear previous skills before adding new ones 
        //for default
        skills = software;
        if (selectedJob.equals(jobs[0])) {
            skills = software;
        } else if (selectedJob.equals(jobs[1])) {
            skills = mehcanical;
        } else if(selectedJob.equals(jobs[2])){
            skills = electrical;
        }
    
        //making menu list for skills
        for (String skill : skills){
            CheckMenuItem checkMenuItem = new CheckMenuItem(skill);
            mySkillMenu.getItems().add(checkMenuItem);
        }
    }

    public void addEmpolyee(ActionEvent e){
        employeeJob = jobChoices.getValue();

        if (employeeJob == null || nameText.getText().isEmpty() || surnameText.getText().isEmpty() || mailText.getText().isEmpty()) {
            Alert nullAlert = new Alert(AlertType.ERROR);
            nullAlert.setHeaderText("Warning!");
            nullAlert.setContentText("Please fill all blanks.");
            nullAlert.showAndWait();
            return;
        } 

        //set values each of them
        employeeJob = jobChoices.getValue();
        employeeName = nameText.getText();
        employeeSurname = surnameText.getText();
        employeeMail = mailText.getText();

        //adding to list
        if(employeeJob.equals(jobs[0])){
            updateSkillMenu(employeeJob);
        }
        else if(employeeJob.equals(jobs[1])){
            updateSkillMenu(employeeJob);
        }
        else if(employeeJob.equals(jobs[2])){
            updateSkillMenu(employeeJob);
        }

        //clear after adding
        nameText.clear();
        surnameText.clear();
        mailText.clear();
        jobChoices.getSelectionModel().clearSelection();
    }

    @FXML
    public void workAddButton(ActionEvent event) {
        writeUpdatedSkillMenu();
        employeeName = nameText.getText();
        employeeSurname = surnameText.getText();
        employeeMail = mailText.getText();
        employeeJob = jobChoices.getValue();
        List<String> skills = new ArrayList<>(selectedSkills); // Create a new list 
        Employee newEmployee = new Employee(employeeName, employeeSurname, employeeMail, employeeJob, skills);
        EmployeeData.employeeList.add(newEmployee);  
    
        if (homePageControl.employeeListController != null) {
            homePageControl.employeeListController.myTableWiev.refresh();
        }
        Alert addedAlert = new Alert(AlertType.INFORMATION);
        addedAlert.setHeaderText("Employee Added!");
        addedAlert.setContentText("Employee has been added successfully.");
        addedAlert.showAndWait();
    

    }

    @FXML
    public void workBackButton(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("HomeScene.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) completeBack.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void workClearButton(ActionEvent event) {
            nameText.clear();
            surnameText.clear();
            mailText.clear();
            jobChoices.getSelectionModel().clearSelection();
            mySkillMenu.getItems().clear();
            selectedSkills.clear();
    }

    public HomePageControl homePageControl;
    public void setHomePageControl(HomePageControl homePageControl) {
        this.homePageControl = homePageControl;
    }



    
}
