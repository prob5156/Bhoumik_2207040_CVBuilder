package com.example.cvbuilder1.controller;

import com.example.cvbuilder1.JUtil.C; // Updated import
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class CvController
{
    private final C a = new C();

    @FXML private TextField tfName;
    @FXML private TextField tfEmail;
    @FXML private TextField tfPhone;
    @FXML private TextField tfAddress;

    @FXML private TextArea taSummary;
    @FXML private TextArea taEducation;
    @FXML private TextArea taExperience;
    @FXML private TextArea taSkills;

    private boolean b()
    {
        if (
                tfName.getText().isEmpty() ||
                        tfEmail.getText().isEmpty() ||
                        tfPhone.getText().isEmpty() ||
                        tfAddress.getText().isEmpty() ||
                        taSummary.getText().isEmpty() ||
                        taEducation.getText().isEmpty() ||
                        taExperience.getText().isEmpty() ||
                        taSkills.getText().isEmpty()
        )
        {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Missing Information");
            a.setContentText("Please fill out all the fields.");
            a.show();
            return false;
        }
        return true;
    }

    @FXML
    private void goBack(ActionEvent a)
    {
        try
        {
            FXMLLoader b = new FXMLLoader(getClass().getResource("/com/example/cvbuilder1/home.fxml"));
            Parent c = b.load();
            Stage d = (Stage)((javafx.scene.Node)a.getSource()).getScene().getWindow();
            d.setScene(new Scene(c));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void previewCv(ActionEvent a)
    {
        if (!b())
        {
            return;
        }

        try
        {
            FXMLLoader b = new FXMLLoader(getClass().getResource("/com/example/cvbuilder1/preview.fxml"));
            Parent c = b.load();

            PreviewController d = b.getController();
            d.setData(
                    tfName.getText(),
                    tfEmail.getText(),
                    tfPhone.getText(),
                    tfAddress.getText(),
                    taSummary.getText(),
                    taEducation.getText(),
                    taExperience.getText(),
                    taSkills.getText()
            );

            Stage e = (Stage)((javafx.scene.Node)a.getSource()).getScene().getWindow();
            e.setScene(new Scene(c));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @FXML
    private void saveCv(ActionEvent a)
    {
        if (!b())
        {
            return;
        }

        this.a.b(
                tfName.getText(),
                tfEmail.getText(),
                tfPhone.getText(),
                tfAddress.getText(),
                taSummary.getText(),
                taEducation.getText(),
                taExperience.getText(),
                taSkills.getText(),
                b ->
                {
                    Alert c = new Alert(Alert.AlertType.INFORMATION);
                    c.setHeaderText("Success");
                    c.setContentText("CV saved with ID: " + b.a());
                    c.show();
                },
                this::onError
        );
    }

    private void onError(Throwable a)
    {
        a.printStackTrace();
        Alert b = new Alert(Alert.AlertType.ERROR, a.getMessage());
        b.setHeaderText("Database Error");
        b.showAndWait();
    }
}