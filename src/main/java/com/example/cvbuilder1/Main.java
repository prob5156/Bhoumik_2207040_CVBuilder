package com.example.cvbuilder1;

import com.example.cvbuilder1.JUtil.B; // Updated import
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        B.f(); // Database initialization

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/example/cvbuilder1/home.fxml"));

        Scene scene = new Scene(loader.load());
        stage.setTitle("CV Builder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}