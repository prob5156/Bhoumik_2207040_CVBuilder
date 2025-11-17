package com.example.cvbuilder1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

public class PreviewController {

    @FXML private Label lblName;
    @FXML private Label lblEmail;
    @FXML private Label lblPhone;
    @FXML private Label lblAddress;
    @FXML private Label lblSummary;
    @FXML private Label lblEducation;
    @FXML private Label lblExperience;
    @FXML private Label lblSkills;

    // Method to receive data from CvController
    public void setData(String name, String email, String phone, String address,
                        String summary, String education, String experience, String skills) {
        lblName.setText(name);
        lblEmail.setText(email);
        lblPhone.setText(phone);
        lblAddress.setText(address);
        lblSummary.setText(summary);
        lblEducation.setText(education);
        lblExperience.setText(experience);
        lblSkills.setText(skills);
    }

    // Go back to form screen
    @FXML
    private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cvbuilder1/cv.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
