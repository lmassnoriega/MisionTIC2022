module com.uninorte {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.uninorte to javafx.fxml;
    opens com.uninorte.controllers to javafx.fxml;
    opens com.uninorte.models to javafx.base;

    exports com.uninorte.legacy;
    exports com.uninorte.models;
    exports com.uninorte.controllers;
    exports com.uninorte;
}