package com.uninorte.controllers;

import javafx.fxml.FXML;

import com.uninorte.models.CuerpoDeAgua;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class retoController {

    private ObservableList<CuerpoDeAgua> cuerpos;

    // #region fields
    @FXML
    private VBox appWindow;

    @FXML
    private MenuBar appMenu;

    @FXML
    private MenuItem clearMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private TextField nameField;

    @FXML
    private TextField stateField;

    @FXML
    private TextField idField;

    @FXML
    private TextField geographyTypeField;

    @FXML
    private TextField ircaField;

    @FXML
    private Button addButton;

    @FXML
    private ComboBox<String> waterTypeSelector;

    @FXML
    private TableView<CuerpoDeAgua> dataTable;

    @FXML
    private TableColumn<CuerpoDeAgua, Integer> idColumn;

    @FXML
    private TableColumn<CuerpoDeAgua, String> nameColumn;

    @FXML
    private TableColumn<CuerpoDeAgua, String> stateColumn;

    @FXML
    private TableColumn<CuerpoDeAgua, String> geographyTypeColumn;

    @FXML
    private TableColumn<CuerpoDeAgua, String> waterTypeColumn;

    @FXML
    private TableColumn<CuerpoDeAgua, Float> ircaColumn;

    @FXML
    private TextArea resultsArea;

    @FXML
    private Button analyzeButton;

    // #endregion

    // #region events
    @FXML
    void addCuerpoAgua(ActionEvent event) {
        if (validateFields()) {
            if (!validateID(idField.getText())) {
                anadirCuerpo(nameField.getText(), Integer.parseInt(idField.getText()), stateField.getText(),
                        geographyTypeField.getText(), waterTypeSelector.getValue(),
                        Float.parseFloat(ircaField.getText()));
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setContentText("El ID ingresado ya existe, ingrese otro valor.");
                alert.show();
            }
        }
    }

    @FXML
    void analizeTableData(ActionEvent event) {
        String resultados = irca_individual() + cuerposBajosSinRiesgo() + cuerposSinRiesgo() + "\n" + irca_promedio();
        resultsArea.setText(resultados);
    }

    @FXML
    void clearFields(ActionEvent event) {
        cuerpos.clear();
        resultsArea.clear();
        idField.clear();
        nameField.clear();
        stateField.clear();
        geographyTypeField.clear();
        ircaField.clear();
        waterTypeSelector.setValue(waterTypeSelector.getItems().get(0));
    }

    @FXML
    void closeApp(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        /**
         * Init Observable Collections
         */
        cuerpos = FXCollections.observableArrayList();

        /**
         * Populate Water Type Options
         */
        ObservableList<String> waterTypes = FXCollections.observableArrayList("Dulce", "Salada");
        waterTypeSelector.setItems(waterTypes);
        waterTypeSelector.setValue(waterTypeSelector.getItems().get(0));

        /**
         * Establish column bindings within datatable
         */
        idColumn.setCellValueFactory(new PropertyValueFactory<CuerpoDeAgua, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<CuerpoDeAgua, String>("nombre"));
        waterTypeColumn.setCellValueFactory(new PropertyValueFactory<CuerpoDeAgua, String>("tipoAgua"));
        geographyTypeColumn.setCellValueFactory(new PropertyValueFactory<CuerpoDeAgua, String>("tipoCuerpo"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<CuerpoDeAgua, String>("municipio"));
        ircaColumn.setCellValueFactory(new PropertyValueFactory<CuerpoDeAgua, Float>("irca"));

        dataTable.setItems(cuerpos);
    }

    // #endregion

    // #region methods

    boolean validateFields() {
        try {
            int id = Integer.parseInt(idField.getText());
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("El campo de ID no debe ser vacio o poser otro valor distinto de numeros");
            alert.show();
            return false;
        }
        try {
            Float ircalevel = Float.parseFloat(ircaField.getText());
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("El campo de ID no debe ser vacio o poser otro valor distinto de numeros decimales");
            alert.show();
            return false;
        }
        if (nameField.getText().isBlank()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("El campo de nombre no puede ser vacio");
            alert.show();
            return false;
        }
        if (stateField.getText().isBlank()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("El campo de municipio no puede ser vacio");
            alert.show();
            return false;
        }
        if (geographyTypeField.getText().isBlank()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("El campo de tipo de cuerpo de agua no puede ser vacio");
            alert.show();
            return false;
        }
        return true;
    }

    /**
     * 
     * @param value
     * @return
     */
    boolean validateID(String value) {
        for (CuerpoDeAgua cuerpoDeAgua : cuerpos) {
            if (cuerpoDeAgua.getId() == Integer.parseInt(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param nombre
     * @param id
     * @param municipio
     * @param tipoCuerpo
     * @param tipoAgua
     * @param irca
     */
    public void anadirCuerpo(String nombre, int id, String municipio, String tipoCuerpo, String tipoAgua, Float irca) {
        CuerpoDeAgua cuerpo = new CuerpoDeAgua(nombre, id, municipio, tipoCuerpo, tipoAgua, irca);
        cuerpos.add(cuerpo);
    }

    /**
     * 
     */
    public String irca_individual() {
        StringBuilder builder = new StringBuilder("");
        for (CuerpoDeAgua cuerpo : cuerpos) {
            builder.append(String.format("%4.2f \n", cuerpo.getIrca()));
        }
        return builder.toString();
    }

    /**
     * 
     */
    public String cuerposBajosSinRiesgo() {
        float sinriesgos = 0;
        for (CuerpoDeAgua cuerpo : cuerpos) {
            if (CuerpoDeAgua.index(cuerpo.nivel()) < 2) {
                sinriesgos++;
            }
        }
        return String.format("%4.2f \n", sinriesgos);
    }

    /**
     * 
     */
    public String cuerposSinRiesgo() {
        String sinriesgos = "";
        for (CuerpoDeAgua cuerpo : cuerpos) {
            if (CuerpoDeAgua.index(cuerpo.nivel()) == 0) {
                sinriesgos += cuerpo.getNombre() + " ";
            }
        }
        sinriesgos = sinriesgos.trim();

        if (sinriesgos.isEmpty()) {
            return "NA";
        } else {
            return sinriesgos;
        }
    }

    /**
     * 
     */
    public String irca_promedio() {
        float suma = 0;
        for (CuerpoDeAgua cuerpoDeAgua : cuerpos) {
            suma += cuerpoDeAgua.getIrca();
        }
        return String.format("%4.2f", (suma / cuerpos.size()));
    }
    // #endregion
}
