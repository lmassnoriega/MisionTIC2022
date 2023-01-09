package com.uninorte.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CuerpoController {

    CuerpodeAguaController controller;

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField stateField;

    @FXML
    private TextField geographyType;

    @FXML
    private ComboBox<String> waterTypeSelector;

    @FXML
    private TextField ircaField;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    void dismiss(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void saveData(ActionEvent event) {
        updateCuerpo();
        dismiss(event);
    }

    @FXML
    void initialize(){

        controller = new CuerpodeAguaController();

        ObservableList<String> waterTypes = FXCollections.observableArrayList("Dulce", "Salada");
        waterTypeSelector.setItems(waterTypes);
        waterTypeSelector.setValue(waterTypeSelector.getItems().get(0));
    }

    boolean validateFields(){
        try {
            Float.parseFloat(ircaField.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("El campo de ID no debe ser vacío o poseer otro valor distinto de numeros decimales");
            alert.show();
            return false;
        }
        if (nameField.getText().isBlank()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("El campo de nombre no puede ser vacío");
            alert.show();
            return false;
        }
        if (stateField.getText().isBlank()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("El campo de municipio no puede ser vacío");
            alert.show();
            return false;
        }
        if (geographyType.getText().isBlank()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("El campo de tipo de cuerpo de agua no puede ser vacío");
            alert.show();
            return false;
        }
        return true;
    }

    public void updateCuerpo(){
        if (validateFields()) {
            controller.updateCuerpo(Integer.parseInt(idField.getText()), nameField.getText(), stateField.getText(), geographyType.getText(), waterTypeSelector.getValue(), Float.parseFloat(ircaField.getText()));
        }
    }

    public void populateData(int id, String nombre, String municipio, String tipoCuerpo, String tipoAgua, Float irca){
        idField.setText(String.valueOf(id));
        nameField.setText(nombre);
        stateField.setText(municipio);
        geographyType.setText(tipoCuerpo);
        waterTypeSelector.setValue(tipoAgua);
        ircaField.setText(String.valueOf(irca));
    }
}
