package com.example.cvbuilder1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CvController {

    @FXML private TextField tfName;
    @FXML private TextField tfEmail;
    @FXML private TextField tfPhone;
    @FXML private TextField tfAddress;

    @FXML private TextArea taSummary;
    @FXML private TextArea taEducation;
    @FXML private TextArea taExperience;
    @FXML private TextArea taSkills;

    // GO BACK TO HOME SCREEN
    @FXML
    private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cvbuilder1/home.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // OPEN PREVIEW SCREEN
    @FXML
    private void previewCv(ActionEvent event) {
        try {
            // Load preview screen FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cvbuilder1/preview.fxml"));
            Scene previewScene = new Scene(loader.load());

            // Get Preview Controller
            PreviewController pc = loader.getController();

            // Send data to preview
            pc.setData(
                    tfName.getText(),
                    tfEmail.getText(),
                    tfPhone.getText(),
                    tfAddress.getText(),
                    taSummary.getText(),
                    taEducation.getText(),
                    taExperience.getText(),
                    taSkills.getText()
            );

            // Switch to preview window
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(previewScene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SAVE CV (you can change this later)
    @FXML
    private void saveCv() {
        System.out.println("CV Saved!");
        System.out.println("Name: " + tfName.getText());
    }
}
