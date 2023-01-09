module com.uninorte {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.sql;
    requires org.apache.logging.log4j;

    opens com.uninorte to javafx.fxml;
    opens com.uninorte.controllers to javafx.fxml, java.sql, org.apache.logging.log4j;
    opens com.uninorte.models to javafx.base;

    exports com.uninorte.models;
    exports com.uninorte.controllers;
    exports com.uninorte;
}