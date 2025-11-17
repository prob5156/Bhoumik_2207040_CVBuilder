package com.example.cvbuilder1.Utility;

import javafx.stage.Stage;

public class scenemanager {

    private static Stage primaryStage;

    public static void setStage(Stage stage) {
        primaryStage = stage;
    }

    public static Stage getStage() {
        return primaryStage;
    }
}
