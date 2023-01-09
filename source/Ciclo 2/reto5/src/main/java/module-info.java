module com.uninorte {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.uninorte to javafx.fxml;
    opens com.uninorte.controllers to javafx.fxml;
    opens com.uninorte.models to javafx.base;

    exports com.uninorte.models;
    exports com.uninorte.controllers;
    exports com.uninorte;
}
