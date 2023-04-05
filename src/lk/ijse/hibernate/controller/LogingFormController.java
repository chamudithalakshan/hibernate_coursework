package lk.ijse.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LogingFormController {
    public void logingOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = (Parent) FXMLLoader.load(this.getClass().getResource("../view/functionForm.fxml"));
      Stage  stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(load));
        // primaryStage.initStyle(StageStyle.UNDECORATED);
        stage.show();


    }
}
