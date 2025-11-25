package com.example.cvbuilder1.controller;

import com.example.cvbuilder1.JUtil.C;
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
    // STATIC fields to hold the data across scene loads
    private static String name;
    private static String email;
    private static String phone;
    private static String address;
    private static String summary;
    private static String education;
    private static String experience;
    private static String skills;
    // END STATIC fields

    private final C a = new C();

    @FXML private TextField tfName;
    @FXML private TextField tfEmail;
    @FXML private TextField tfPhone;
    @FXML private TextField tfAddress;

    @FXML private TextArea taSummary;
    @FXML private TextArea taEducation;
    @FXML private TextArea taExperience;
    @FXML private TextArea taSkills;

    @FXML
    public void initialize() {
        // Load data if available (e.g., after coming back from preview)
        if (name != null) {
            tfName.setText(name);
            tfEmail.setText(email);
            tfPhone.setText(phone);
            tfAddress.setText(address);
            taSummary.setText(summary);
            taEducation.setText(education);
            taExperience.setText(experience);
            taSkills.setText(skills);
        }
    }

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

    private void c()
    {
        name = tfName.getText();
        email = tfEmail.getText();
        phone = tfPhone.getText();
        address = tfAddress.getText();
        summary = taSummary.getText();
        education = taEducation.getText();
        experience = taExperience.getText();
        skills = taSkills.getText();
    }

    @FXML
    private void goBack(ActionEvent a)
    {
        c(); // Save data before leaving
        try
        {
            FXMLLoader b = new FXMLLoader(getClass().getResource("/com/example/cvbuilder1/home.fxml"));
            Parent d = b.load();
            Stage e = (Stage)((javafx.scene.Node)a.getSource()).getScene().getWindow();
            e.setScene(new Scene(d));
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

        c(); // Save data before switching scenes

        try
        {
            FXMLLoader b = new FXMLLoader(getClass().getResource("/com/example/cvbuilder1/preview.fxml"));
            Parent d = b.load();

            PreviewController e = b.getController();
            e.setData(
                    name, // Use static data
                    email,
                    phone,
                    address,
                    summary,
                    education,
                    experience,
                    skills
            );

            Stage f = (Stage)((javafx.scene.Node)a.getSource()).getScene().getWindow();
            f.setScene(new Scene(d));

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

        c(); // Save data locally before saving to DB

        this.a.b(
                name,
                email,
                phone,
                address,
                summary,
                education,
                experience,
                skills,
                b ->
                {
                    Alert c = new Alert(Alert.AlertType.INFORMATION);
                    c.setHeaderText("#90A4AE Success #1ABC9C");
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
        b.setHeaderText("#C0392B Database Error #ECF0F1");
        b.showAndWait();
    }
}