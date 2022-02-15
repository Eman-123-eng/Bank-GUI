package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AdminController {
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private StackPane contentArea;

    @FXML
    private Button Manage,accStat,addBtn,deleteBtn,deposit,editBtn,transfer,transaction_Button,withdraw,exit;

    @FXML
    void exit(ActionEvent event) {
        try {// this code to switch to another frame.
            //((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("exit.fxml"));
            root = fxml.load();
            stage = new Stage();
            scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.print("this scene can't load");
        }
    }


    @FXML
    void accStat(ActionEvent event) throws IOException{
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("accStat.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }

    @FXML
    void addBtn(ActionEvent event) throws IOException{
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("adminADD.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }

    @FXML
    void deleteBtn(ActionEvent event) throws IOException{
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("adminDELETE.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }

    @FXML
    void deposit(ActionEvent event) throws IOException{
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("deposit.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }

    @FXML
    void editBtn(ActionEvent event) throws IOException{
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("adminEDIT.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);


    }



    @FXML
    void transfer(ActionEvent event) throws IOException{
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("transfer.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }

    @FXML
    void withdraw(ActionEvent event) throws IOException {
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("withdraw.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }

}
