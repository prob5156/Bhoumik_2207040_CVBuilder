package com.example.cvbuilder1.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class CvController {

    @FXML private TextField tfName;
    @FXML private TextField tfEmail;
    @FXML private TextField tfPhone;
    @FXML private TextField tfAddress;

    @FXML private TextArea taSummary;
    @FXML private TextArea taEducation;
    @FXML private TextArea taExperience;
    @FXML private TextArea taSkills;

    @FXML
    private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cvbuilder1/home.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void previewCv(ActionEvent event) {


        if (
                tfName.getText().isEmpty() ||
                        tfEmail.getText().isEmpty() ||
                        tfPhone.getText().isEmpty() ||
                        tfAddress.getText().isEmpty() ||
                        taSummary.getText().isEmpty() ||
                        taEducation.getText().isEmpty() ||
                        taExperience.getText().isEmpty() ||
                        taSkills.getText().isEmpty()
        ) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Missing Information");
            a.setContentText("Please fill out all the fields before previewing.");
            a.show();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cvbuilder1/preview.fxml"));
            Parent root = loader.load();

            PreviewController controller = loader.getController();
            controller.setData(
                    tfName.getText(),
                    tfEmail.getText(),
                    tfPhone.getText(),
                    tfAddress.getText(),
                    taSummary.getText(),
                    taEducation.getText(),
                    taExperience.getText(),
                    taSkills.getText()
            );

            Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void saveCv(ActionEvent event) {

    }
}
