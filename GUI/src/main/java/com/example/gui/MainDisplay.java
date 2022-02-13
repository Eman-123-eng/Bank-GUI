package com.example.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainDisplay extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(MainDisplay.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED); // to remove the title bar


        stage.setScene(scene);
        stage.show();
    }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}