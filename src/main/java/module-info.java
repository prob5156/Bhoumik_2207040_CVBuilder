module com.example.cvbuilder1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.cvbuilder1 to javafx.fxml;
    opens com.example.cvbuilder1.controller to javafx.fxml;

    exports com.example.cvbuilder1;
    exports com.example.cvbuilder1.controller;
}
