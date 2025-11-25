package com.example.cvbuilder1.controller;

import com.example.cvbuilder1.JUtil.C; // Updated import
import com.example.cvbuilder1.model.CVRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class ListController
{
    private final C d = new C();
    private final ObservableList<CVRecord> e = FXCollections.observableArrayList();

    @FXML
    private ListView<CVRecord> cvList;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfEmail;

    @FXML
    private Label status;

    @FXML
    public void initialize()
    {
        cvList.setItems(e);

        cvList.getSelectionModel().selectedItemProperty().addListener((a, b, c) ->
        {
            if (c != null)
            {
                tfName.setText(c.b());
                tfEmail.setText(c.c());
                g("Selected CV #" + c.a());
            }
            else
            {
                tfName.clear();
                tfEmail.clear();
            }
        });

        f();
    }

    private void f()
    {
        g("Loading CVs...");
        d.a(this::h, this::i);
    }

    private void h(List<CVRecord> a)
    {
        e.setAll(a);
        g("Loaded " + a.size() + " CVs.");
    }

    private void i(Throwable a)
    {
        a.printStackTrace();
        g("Error: " + a.getMessage());
        Alert b = new Alert(Alert.AlertType.ERROR, a.getMessage());
        b.setHeaderText("Database Error");
        b.showAndWait();
    }

    private void g(String a)
    {
        status.setText(a);
    }

    @FXML
    private void a(ActionEvent a)
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
    private void b(ActionEvent a)
    {
        CVRecord b = cvList.getSelectionModel().getSelectedItem();
        if (b == null)
        {
            g("Please select a CV to update.");
            return;
        }

        String c = tfName.getText().trim();
        String d = tfEmail.getText().trim();

        if (c.isEmpty() || d.isEmpty())
        {
            g("Name and email cannot be empty.");
            return;
        }

        CVRecord f = new CVRecord(b.a(), c, d, b.d(), b.e(), b.f(), b.g(), b.h(), b.i());
        g("Updating CV #" + f.a() + "...");

        this.d.c(f, () ->
        {
            int g = e.indexOf(b);
            if (g >= 0)
            {
                e.set(g, f);
                cvList.getSelectionModel().select(f);
            }
            g("CV #" + f.a() + " updated.");
        }, this::i);
    }

    @FXML
    private void c(ActionEvent a)
    {
        CVRecord b = cvList.getSelectionModel().getSelectedItem();
        if (b == null)
        {
            g("Please select a CV to delete.");
            return;
        }

        Alert c = new Alert(Alert.AlertType.CONFIRMATION,
                "Delete CV #" + b.a() + " (" + b.b() + ")?",
                ButtonType.YES, ButtonType.NO);
        c.setHeaderText("Confirm Delete");

        c.showAndWait().ifPresent(d ->
        {
            if (d == ButtonType.YES)
            {
                g("Deleting CV #" + b.a() + "...");
                this.d.d(b.a(), () ->
                {
                    e.remove(b);
                    g("CV deleted.");
                }, this::i);
            }
        });
    }
}