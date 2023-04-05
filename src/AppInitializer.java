import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent load = (Parent) FXMLLoader.load(this.getClass().getResource("lk/ijse/hibernate/view/LogingForm.fxml"));
        primaryStage.setScene(new Scene(load));
       // primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
}
