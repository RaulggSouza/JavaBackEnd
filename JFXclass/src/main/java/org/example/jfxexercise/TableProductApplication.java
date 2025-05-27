package org.example.jfxexercise;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class TableProductApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("table_example.fxml")));
        final Scene scene = new Scene(pane, 600, 600);
        stage.setScene(scene);
        stage.show();
    }
}
