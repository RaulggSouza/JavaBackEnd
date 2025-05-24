package org.example.jfxclass;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableController {
    @FXML private TableView<Product> table;
    @FXML private TableColumn<Product, String> cId;
    @FXML private TableColumn<Product, String> cName;
    @FXML private TableColumn<Product, Double> cPrice;
    @FXML private TableColumn<Product, Integer> cQuantity;
    @FXML private TableColumn<Product, Double> cTotal;
}
