package com.example.cvbuilder1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private void openCvBuilder(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cvbuilder1/cv.fxml"));
            Scene cvScene = new Scene(loader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(cvScene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
