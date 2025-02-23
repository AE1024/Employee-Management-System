import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    private double xOffset = 0;
    private double yOffset = 0;
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
        Scene scene = new Scene(root);
        root.setOnMousePressed(event -> {
            xOffset =event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged( event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    
        stage.setScene(scene);
        stage.setTitle("Employee Entry Page");
        stage.show();   
    }
}
