package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import connection.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Curso;
import model.Horario;
import model.Personas;

public class CursosController implements Initializable {

    int identificacionInicial = 0;

    @FXML
    private TextField insIdentificacion;

    @FXML
    private TextField insNombre;

    @FXML
    private TextField insApellido;

    @FXML
    private TextField insEmail;

    @FXML
    private ComboBox<String> cboInsCurso;

    @FXML
    private Button btnCrear;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnBuscarInstructor;

    @FXML
    private TextField txtNombreCurso;

    @FXML
    private ComboBox<String> cboHorarios;

    @FXML
    private ComboBox<String> cbInstructor;

    @FXML
    private Button btnGuardarCurso;

    @FXML
    private TextField txtNombreCurso1;

    @FXML
    private Button btnGuardarCurso1;

    @FXML
    private TextArea textAreaCursos;

    @FXML
    private TextArea textAreaInstructores;

    @FXML
    private TextField triIdentificacion;

    @FXML
    private TextField triNombre;

    @FXML
    private TextField triApellido;

    @FXML
    private TextField triEmail;

    @FXML
    private Button btnCrearTri;

    @FXML
    private Button btnActualizarTri;

    @FXML
    private Button btnEliminarTri;

    @FXML
    private Button btnLimpiarTri;

    @FXML
    private TextArea textAreaTripulantes;

    @FXML
    private Button btnBuscarTripulante;

    @FXML
    private ComboBox<?> cbTriCurso;

    ObservableList<String> lstCbHorario = FXCollections.observableArrayList();
    ObservableList<String> lstCbInstructores = FXCollections.observableArrayList();
    ObservableList<String> lstCbCursos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // limpiarCampos(event);
        // Al cargar la interfaz, llenar los ComboBox de los forms desde la BD.
        llenarCbos();
        llenarCursoEnInstructores();
        llenarTextAreaInstructores();
        llenarTextAreaCursos();
    }

    /**** TAB DE CURSOS ****/
    // Método del controlador para crear cursos desde el formulario de Cursos (TAB
    // Cursos)
    @FXML
    void guardarCurso(ActionEvent event) {

        // Validación de campos no en blanco, incluyendo el ComboBox
        String msg = "";
        if (!txtNombreCurso.getText().isEmpty()) {
            if (cboHorarios.getSelectionModel().getSelectedItem() != null) {
                if (cbInstructor.getSelectionModel().getSelectedItem() != null) {
                    String horario_[] = cboHorarios.getSelectionModel().getSelectedItem().toString().split(" - ");
                    String instructor_[] = cbInstructor.getSelectionModel().getSelectedItem().toString().split(" - ");

                    Curso curso = new Curso(0, txtNombreCurso.getText(), Integer.parseInt(horario_[0]),
                            Integer.parseInt(instructor_[0]));

                    curso.save();
                    txtNombreCurso.clear();
                    cboHorarios.getSelectionModel().selectFirst();
                    cbInstructor.getSelectionModel().selectFirst();
                    textAreaCursos.clear();
                    txtNombreCurso.requestFocus();
                    llenarTextAreaCursos();
                    llenarCursoEnInstructores();
                } else {
                    msg = "INSTRUCTORES";
                    validadorCampos(msg, null, cbInstructor);
                }
            } else {
                msg = "HORARIOS";
                validadorCampos(msg, null, cboHorarios);
            }
        } else {
            msg = "Campo NOMBRE ";
            validadorCampos(msg, txtNombreCurso, null);
        }
    }

    // Método para actualizar ComboBox de horarios e instructores en el formulario
    // de Cursos (TAB Cursos).
    @FXML
    public void llenarCbos() {
        Horario horario = new Horario();
        ResultSet rsHorario = horario.allHorarios();

        Personas instructor = new Personas();
        ResultSet rsInstructor = instructor.allInstructores();

        try {
            // Limpiar la lista de horarios para agregar los datos y evitar duplicados
            if (lstCbHorario.size() > 0) {
                lstCbHorario.clear();
            }
            while (rsHorario.next()) {
                // System.out.println(rsHorario.getString("id"));
                lstCbHorario.addAll(rsHorario.getInt("id") + " - " + rsHorario.getString("dia") + " - "
                        + rsHorario.getShort("hora"));
                cboHorarios.getItems().setAll(lstCbHorario);
            }

            // Limpiar la lista de Isntructores para agregar los datos y evitar duplicados
            if (lstCbInstructores.size() > 0) {
                lstCbInstructores.clear();
            }
            while (rsInstructor.next()) {
                System.out.println(rsInstructor.getString("id"));
                lstCbInstructores.addAll(rsInstructor.getInt("id") + " - " + rsInstructor.getString("nombre"));
                cbInstructor.getItems().setAll(lstCbInstructores);
            }
        } catch (SQLException e) {
            System.out.println("Error en la carga de instructores: " + e.getMessage());
        }

    }

    /**** FIN TAB DE CURSOS ****/

    /**** TAB DE INSTRUCTORES ****/

    // Método para llenar el ComboBox de cursos en el formulario de Instructores
    public void llenarCursoEnInstructores() {
        Curso curso = new Curso();
        ResultSet rsCursos = curso.allCursos();

        try {
            // Limpiar la lista para agregar los datos y evitar duplicados
            if (lstCbCursos.size() > 0) {
                lstCbCursos.clear();
            }
            while (rsCursos.next()) {
                lstCbCursos.addAll(rsCursos.getInt("codigo") + " - " + rsCursos.getString("nombre"));
                cboInsCurso.getItems().setAll(lstCbCursos);
            }
        } catch (SQLException e) {
            System.out.println("Error en la carga de cursos: " + e.getMessage());
        }

    }

    // Método para llenar el TextArea del formulario de Instructores con datos de la
    // tabla de Instructores
    @FXML
    public void llenarTextAreaInstructores() {
        String cursos = "";
        try {
            textAreaInstructores.setEditable(false);
            Personas instructor = new Personas();

            // LLenar el TextArea de instructores extrayendo los columnNames
            // desde el ResultSet
            ResultSet res = instructor.allInstructores();
            ResultSetMetaData rsmd = res.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (res.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = res.getString(i);
                    cursos = cursos + rsmd.getColumnName(i) + ":" + " " + columnValue + "\n";
                }
                cursos = cursos + "\n";
                textAreaInstructores.setText(cursos);
            }

        } catch (Exception e) {
            textAreaInstructores.setText("Error en la carga de datos de los instructores. " + e.getMessage());
            System.out.println("Error en la carga de datos de los instructores." + e.getMessage());
        }
    }

    // Método para llenar el TextArea del formulario de cursos con datos de la
    // tabla Cursos
    @FXML
    public void llenarTextAreaCursos() {
        String contenido = "";
        try {
            textAreaCursos.setEditable(false);
            Curso curso = new Curso();

            // Llenado del TextArea usando concatenación simple
            ResultSet res = curso.allCursos();
            while (res.next()) {
                contenido += "código: " + res.getInt("codigo") + "\n" + "curso: " + res.getString("nombre") + "\n"
                        + "código horario: " + res.getInt("id_horario") + "\n" + "código instructor: "
                        + res.getInt("id_instructor") + "\n\n";
            }
            textAreaCursos.setText(contenido);

        } catch (Exception e) {
            textAreaCursos.setText("Error en la carga de datos del curso " + e.getMessage());
            System.out.println("Error en la carga de datos del curso " + e.getMessage());
        }
    }

    // Método para limpiar campos del formulario de Instructores
    @FXML
    void limpiarCampos(ActionEvent event) {
        insIdentificacion.clear();
        insNombre.clear();
        insApellido.clear();
        insEmail.clear();
        textAreaInstructores.clear();
        cboInsCurso.getSelectionModel().selectFirst();
        insIdentificacion.requestFocus();
        llenarTextAreaInstructores();
    }

    // Método para crear instructores en la BD, desde el formulario de Instructores
    @FXML
    void crearInstructor(ActionEvent event) {
        // Validación de campos no en blanco, incluyendo el ComboBox
        String msg = "";
        if (!insIdentificacion.getText().isEmpty()) {
            if (!insNombre.getText().isEmpty()) {
                if (!insApellido.getText().isEmpty()) {
                    if (!insEmail.getText().isEmpty()) {
                        if (cboInsCurso.getSelectionModel().getSelectedItem() != null) {
                            int identificacion = Integer.parseInt(insIdentificacion.getText());
                            String nombre = insNombre.getText();
                            String apellido = insApellido.getText();
                            String email = insEmail.getText();
                            /*
                             * Extraer sólo el código del curso desde el ComboBox de cursos ubicado en el
                             * formulario de instructores y setear el modelo de instructores para poder
                             * crear el registr en la tabla de Instructores
                             */
                            String opcion[] = cboInsCurso.getSelectionModel().getSelectedItem().split(" - ");
                            int curso = Integer.parseInt(opcion[0]);
                            ///
                            Personas instructor = new Personas(0, identificacion, nombre, apellido, email, 0, curso, 1);
                            instructor.save();
                            limpiarCampos(event);
                            textAreaInstructores.clear();
                            llenarTextAreaInstructores();

                        } else {
                            msg = "Lista desplegavle de cursos";
                            validadorCampos(msg, null, cboInsCurso);
                        }

                    } else {
                        msg = "Email";
                        validadorCampos(msg, insEmail, null);
                    }
                } else {
                    msg = "Apellido";
                    validadorCampos(msg, insApellido, null);
                }

            } else {
                msg = "Nombre";
                validadorCampos(msg, insNombre, null);
            }
        } else {
            msg = "Identificación";
            validadorCampos(msg, insIdentificacion, null);
        }

    }

    // Método para consultar por la identificación, los datos de un instructor
    // y mostrarlos en el formulario de instructores (TAB Instructores)
    @FXML
    void consultarInstructor(ActionEvent event) {
        int codigoPersona = 0;
        Personas instructor = new Personas();

        if (insIdentificacion.getText().isEmpty()) {
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setContentText("Campo 'Identificación' no puede estar vacío. ");
            alerta.showAndWait();
            insIdentificacion.clear();
            insIdentificacion.requestFocus();
        } else {
            ResultSet rs = instructor.buscarInstructor(Integer.parseInt(insIdentificacion.getText()));
            int i = 0, pos = 0, encontrado = 0, indice = -1;
            try {
                while (rs.next()) {
                    identificacionInicial = rs.getInt("id");
                    insNombre.setText(rs.getString("nombre"));
                    insApellido.setText(rs.getString("apellido"));
                    insEmail.setText(rs.getString("email"));
                    String cod_curso = Integer.toString(rs.getInt("curso_asig"));
                    // Al traer de la BD el código del curso, recorrer la lista observable
                    // para luego seleccionar el item respectivo del ComboBox.
                    while (pos < lstCbCursos.size() && encontrado == 0) {
                        String codlista[] = lstCbCursos.get(pos).split(" - ");
                        if (codlista[0].equals(cod_curso)) {
                            // System.out.println("Existe");
                            indice = pos;
                            encontrado = 1;
                            cboInsCurso.getSelectionModel().select(indice);
                        } else {
                            pos++;
                        }
                    }
                }
                if (encontrado == 0) {
                    Alert alerta = new Alert(AlertType.ERROR, "No existe instructor con esa identificación");
                    alerta.showAndWait();
                    insIdentificacion.requestFocus();
                }
            } catch (Exception e) {
                Alert alerta = new Alert(AlertType.ERROR, "No existe instructor con esa identificación");
                alerta.showAndWait();
                insIdentificacion.requestFocus();
                System.out.println("Error en la consulta de datos." + e.getMessage());
            }
        }
    }

    // Método para actualizar la información del formulario de instructores
    @FXML
    void actualizarInstructor(ActionEvent event) throws SQLException {
        // Capturar los datos de los campos del formulario de instructor
        Personas instructor = null;
        int identificacion = Integer.parseInt(insIdentificacion.getText());
        String nombre = insNombre.getText();
        String apellido = insApellido.getText();
        String email = insEmail.getText();
        // Extraer sólo el código del texto de la lista desplegable
        String item[] = cboInsCurso.getSelectionModel().getSelectedItem().split(" - ");
        // Setear el modelo Personas para invocar el método update y guardar cambios en
        // la BD.
        instructor = new Personas(0, identificacion, nombre, apellido, email, 0, Integer.parseInt(item[0]), 1);
        // Recueprar el id desde ña tabla Personas por medio del campo de identificación
        // porque el formulario no da acceso al mismo por ser autoincrement
        // int idInstructor = instructor.buscarId(identificacion);
        instructor.update(identificacionInicial);
        limpiarCampos(event);
        textAreaInstructores.clear();
        llenarTextAreaInstructores();
    }

    // Método de apoyo en validación de campos vacíos en formularios
    @FXML
    public void validadorCampos(String msg, TextField textfield, ComboBox<String> comboBox) {
        Alert alerta = new Alert(AlertType.ERROR);
        if (textfield != null) {
            alerta.setContentText(msg + "no puede estar vacío. Intente de nuevo.");
            alerta.showAndWait();
            textfield.requestFocus();
        }
        if (comboBox.getSelectionModel().getSelectedItem() == null) {
            alerta.setContentText("Debe seleccionar un elemento de la lista " + msg);
            alerta.showAndWait();
            comboBox.requestFocus();
        }
    }

    // Método para capturar datos del formulario de instructores y proceder a
    // eliminar
    // invocando el método delete del modelo Personas
    @FXML
    void borrarInsrtructor(ActionEvent event) {
        // Validar que el campo identificación no este vacío para eliminar
        if (!insIdentificacion.getText().isEmpty()) {
            Personas instructor = new Personas();
            int identificacion = Integer.parseInt(insIdentificacion.getText());
            int idInstructor = instructor.buscarId(identificacion);
            // Si existe el valor digitado en el campo de identificación,
            // se procede a elminar
            if (idInstructor != -1) {
                instructor.delete(idInstructor);
                // Creating a dialog
                Dialog<String> dialog_elimina = new Dialog<String>();
                // Setting the title
                dialog_elimina.setTitle("Eliminaciòn");
                ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
                // Setting the content of the dialog
                dialog_elimina.setContentText("Registro eliminado satisfactoriamente. ");
                // Adding buttons to the dialog pane
                dialog_elimina.getDialogPane().getButtonTypes().add(type);
                dialog_elimina.showAndWait();
                
                limpiarCampos(event);
                textAreaInstructores.clear();
                llenarTextAreaInstructores();
                insIdentificacion.requestFocus();
            } else {
                // Si la consulta del valor digitado como identificación no esta en la BD
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.setContentText("Código de instructor NO existe. Intente de nuevo.");
                alerta.showAndWait();
                insIdentificacion.requestFocus();
            }
        } else {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setContentText("Campo de identificación NO puede ser vacío. Intente de nuevo.");
            alerta.showAndWait();
            insIdentificacion.requestFocus();

        }
    }

    /**** FIN TAB DE INSTRUCTORES ****/

    /**** TAB DE TRIPULANTES ****/

    @FXML
    void crearTripulante(ActionEvent event) {

    }

    @FXML
    void consultarTripulante(ActionEvent event) {

    }

    @FXML
    void actualizarTripulante(ActionEvent event) {

    }

    @FXML
    void borrarTripulante(ActionEvent event) {

    }

    @FXML
    void limpiarCamposTri(ActionEvent event) {

    }

}