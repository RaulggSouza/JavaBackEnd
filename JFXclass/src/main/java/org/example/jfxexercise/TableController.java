package org.example.jfxexercise;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TableController {
    @FXML private TableView<Product> table;
    @FXML private TableColumn<Product, String> cId;
    @FXML private TableColumn<Product, String> cName;
    @FXML private TableColumn<Product, Double> cPrice;
    @FXML private TableColumn<Product, Integer> cQuantity;
    @FXML private TableColumn<Product, Double> cTotal;

    private ObservableList<Product> observableList;
    private ProductRepository repository;

    @FXML
    public void initialize(){
        bindTableColumnsToProperties();
        bindDataSourceToTable();
        loadDataIntoTable();
    }

    private void bindTableColumnsToProperties() {
        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        cQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        cTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    private void bindDataSourceToTable() {
        observableList = FXCollections.observableArrayList();
        table.setItems(observableList);
    }

    private void loadDataIntoTable() {
        repository = new FakeRepository();
        final List<Product> products = repository.findAll();
        observableList.clear();
        observableList.addAll(products);
    }

    public void insertProduct() {
    }

    public void updateProduct() {

    }

    public void deleteProduct() {
    }

    public void detailProduct() {
    }
}
