package org.example.jfxclass;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class ReverseView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        final Pane graph = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("reverse_view.fxml")));
        final Scene scene = new Scene(graph, 480, 100);
        stage.setScene(scene);
        stage.show();
    }
}
