package com.uninorte.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.uninorte.Reto4;
import com.uninorte.models.CuerpoDeAgua;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class RetoController {

    private static final Logger logger = LogManager.getLogger(RetoController.class);
    private ObservableList<CuerpoDeAgua> cuerpos;
    CuerpodeAguaController controller;
    CuerpoDeAgua selectedItem = null;

    // #region fields
    @FXML
    private VBox appWindow;

    @FXML
    private MenuBar appMenu;

    @FXML
    private MenuItem refreshButton;

    @FXML
    private MenuItem clearMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private TextField nameField;

    @FXML
    private TextField stateField;

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
    private TableColumn<CuerpoDeAgua, String> editCol;

    @FXML
    private TextArea resultsArea;

    @FXML
    private Button analyzeButton;

    // #endregion

    // #region events
    @FXML
    void addCuerpoAgua(ActionEvent event) {
        if (validateFields()) {
            anadirCuerpo(nameField.getText(), stateField.getText(), geographyTypeField.getText(),
                    waterTypeSelector.getValue(), Float.parseFloat(ircaField.getText()));
            updatedataTable();
        }
    }

    @FXML
    void analizeTableData(ActionEvent event) {
        String resultados = ircaIndividual() + cuerposBajosSinRiesgo() + cuerposSinRiesgo() + "\n" + ircaPromedio();
        resultsArea.setText(resultados);
    }

    @FXML
    void clearFields(ActionEvent event) {
        cuerpos.clear();
        resultsArea.clear();
        nameField.clear();
        stateField.clear();
        geographyTypeField.clear();
        ircaField.clear();
        waterTypeSelector.setValue(waterTypeSelector.getItems().get(0));
        refereshData(event);
    }

    @FXML
    void closeApp(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void refereshData(ActionEvent event) {
        updatedataTable();
    }

    @FXML
    void initialize() {
        /**
         * Init Observable Collections and local controllers
         */
        cuerpos = FXCollections.observableArrayList();
        controller = new CuerpodeAguaController();

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

        // add cell of button edit
        Callback<TableColumn<CuerpoDeAgua, String>, TableCell<CuerpoDeAgua, String>> cellFactory = (
                TableColumn<CuerpoDeAgua, String> param) -> createOperationCell();
        editCol.setCellFactory(cellFactory);
        dataTable.setItems(cuerpos);
        updatedataTable();
    }

    private TableCell<CuerpoDeAgua, String> createOperationCell() {
        // make cell containing buttons
        return new TableCell<CuerpoDeAgua, String>() {

            Image imgEdit = new Image(Reto4.class.getResourceAsStream("img/edit.png"));
            Button btnEdit = new Button();
            Image imgDelete = new Image(Reto4.class.getResourceAsStream("img/delete.png"));
            Button btnDelete = new Button();

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                // that cell created only on non-empty rows
                if (empty) {
                    setGraphic(null);
                    setText(null);
                } else {
                    btnDelete.setStyle("-fx-background-color: transparent;");
                    ImageView iv = new ImageView();
                    iv.setImage(imgDelete);
                    iv.setFitWidth(20);
                    iv.setPreserveRatio(true);
                    iv.setSmooth(true);
                    iv.setCache(true);
                    btnDelete.setGraphic(iv);
                    setAlignment(Pos.CENTER);
                    btnDelete.setOnAction(e -> {
                        try {
                            selectedItem = getTableView().getItems().get(getIndex());
                            controller.deleteCuerpo(selectedItem.getId());
                            updatedataTable();
                        } catch (Exception ex) {
                            logger.error(ex.getLocalizedMessage());
                        }
                    });
                    btnEdit.setStyle("-fx-background-color: transparent;");
                    ImageView iv2 = new ImageView();
                    iv2.setImage(imgEdit);
                    iv2.setFitWidth(20);
                    iv2.setPreserveRatio(true);
                    iv2.setSmooth(true);
                    iv2.setCache(true);
                    btnEdit.setGraphic(iv2);
                    setAlignment(Pos.CENTER);
                    btnEdit.setOnAction(e -> {
                        selectedItem = getTableView().getItems().get(getIndex());
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(Reto4.class.getResource("views/cuerpolayout.fxml"));
                        try {
                            loader.load();
                        } catch (IOException ex) {
                            logger.error(ex.getLocalizedMessage());
                        }

                        CuerpoController secondController = loader.getController();
                        secondController.populateData(selectedItem.getId(), selectedItem.getNombre(),
                                selectedItem.getMunicipio(), selectedItem.getTipoCuerpo(), selectedItem.getTipoAgua(),
                                selectedItem.getIrca());
                        Parent parent = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(parent));
                        stage.initStyle(StageStyle.UTILITY);
                        stage.show();
                        updatedataTable();
                    });
                    HBox managebtn = new HBox(btnEdit, btnDelete);
                    managebtn.setStyle("-fx-alignment:center");
                    setGraphic(managebtn);
                }
            }
        };
    }

    public void updatedataTable() {
        cuerpos.clear();
        List<CuerpoDeAgua> list = controller.getAllCuerpos();
        for (CuerpoDeAgua cuerpoDeAgua : list) {
            cuerpos.add(cuerpoDeAgua);
        }
    }

    // #endregion

    // #region methods

    boolean validateFields() {
        try {
            Float.parseFloat(ircaField.getText());
        } catch (NumberFormatException e) {
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
     * @param nombre
     * @param municipio
     * @param tipoCuerpo
     * @param tipoAgua
     * @param irca
     */
    public void anadirCuerpo(String nombre, String municipio, String tipoCuerpo, String tipoAgua, Float irca) {
        controller.insertCuerpo(nombre, municipio, tipoCuerpo, tipoAgua, irca);
    }

    /**
     * 
     */
    public String ircaIndividual() {
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
        return String.format("%4.2f %n", sinriesgos);
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
    public String ircaPromedio() {
        float suma = 0;
        for (CuerpoDeAgua cuerpoDeAgua : cuerpos) {
            suma += cuerpoDeAgua.getIrca();
        }
        return String.format("%4.2f", (suma / cuerpos.size()));
    }
    // #endregion
}