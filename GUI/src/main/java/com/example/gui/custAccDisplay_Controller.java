package com.example.gui;

import BankManagement.BankAccount;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import static javafx.geometry.Pos.CENTER;

public class custAccDisplay_Controller {
    private Stage stage;
    private Parent root;
    private Scene scene;
    @FXML
    private StackPane contentArea;

    @FXML
    private Button Trans, accStat, deposit, withdraw, back, signout, exit;

    @FXML
    void signout(ActionEvent event) {
        System.exit(0);
    }

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
            BankAccount.writeToFile();
        } catch (Exception e) {
            System.out.print("this scene can't load");
        }
    }


    @FXML
    void deposit(ActionEvent event) throws IOException {
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("deposit.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);
    }

    @FXML
    void Trans(ActionEvent event) throws IOException {
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("transfer.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);
    }

    @FXML
    void accStat(ActionEvent event) throws IOException {
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("accStat.fxml"));
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

    @FXML
    void onBack(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) back.getScene().getWindow();

            MainController m = new MainController();

            m.showStage("hello-view.fxml"); //to be updated to go to the account mng

            stage.hide();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in back btn: " + e);
        }
    }

    @FXML
    void display(ActionEvent event) throws IOException{
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("accDetails.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);
    }

}

