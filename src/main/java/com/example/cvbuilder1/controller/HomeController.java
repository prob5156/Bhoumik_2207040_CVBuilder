package com.example.cvbuilder1.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class HomeController
{

    @FXML
    private void openCvBuilder(ActionEvent a)
    {
        try
        {
            FXMLLoader b = new FXMLLoader(getClass().getResource("/com/example/cvbuilder1/cv.fxml"));
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
    private void openCvList(ActionEvent a)
    {
        try
        {
            FXMLLoader b = new FXMLLoader(getClass().getResource("/com/example/cvbuilder1/list.fxml"));
            Parent c = b.load();
            Stage d = (Stage)((javafx.scene.Node)a.getSource()).getScene().getWindow();
            d.setScene(new Scene(c));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}