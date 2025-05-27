module org.example.jfxclass {
    requires javafx.controls;
    requires javafx.fxml;

    exports org.example.jfxclass;
    opens org.example.jfxclass;
    exports org.example.jfxexercise;
    opens org.example.jfxexercise;
}