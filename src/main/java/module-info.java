module com.example.cvbuilder1
{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.cvbuilder1 to javafx.fxml;
    opens com.example.cvbuilder1.controller to javafx.fxml;
    opens com.example.cvbuilder1.model to javafx.fxml;
    opens com.example.cvbuilder1.JUtil to javafx.fxml;

    exports com.example.cvbuilder1;
    exports com.example.cvbuilder1.controller;
    exports com.example.cvbuilder1.model;
}