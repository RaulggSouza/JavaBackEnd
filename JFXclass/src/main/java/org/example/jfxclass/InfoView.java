package org.example.jfxclass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class InfoView{

    public void show(int charCount){
        try {
            FXMLLoader loader = new FXMLLoader();
            final Pane pane = loader.load(Objects.requireNonNull(getClass().getResource("info_view.fxml")).openStream());
            InfoController controller = loader.getController();
            controller.setCharCount(charCount);
            final Scene scene = new Scene(pane, 400, 100);
            final Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
