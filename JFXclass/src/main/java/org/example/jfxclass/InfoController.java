package org.example.jfxclass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

public class InfoController {

    @FXML private Label lbResult;

    public void setCharCount(int charCount){
        lbResult.setText(String.valueOf(charCount));
    }

    public void close(ActionEvent actionEvent) {
        final Stage stage = (Stage) lbResult.getScene().getWindow();
        stage.close();
    }
}
