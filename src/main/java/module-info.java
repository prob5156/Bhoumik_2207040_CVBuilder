module com.example.cvbuilder1
{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.json;

    opens com.example.cvbuilder1 to javafx.fxml;
    opens com.example.cvbuilder1.controller to javafx.fxml;
    opens com.example.cvbuilder1.model to javafx.fxml;
    opens com.example.cvbuilder1.JUtil to javafx.fxml; // New JUtil package

    exports com.example.cvbuilder1;
    exports com.example.cvbuilder1.controller;
    exports com.example.cvbuilder1.model;
}