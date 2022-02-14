package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class custAccDisplay_Controller {
    @FXML
    private StackPane contentArea;

    @FXML
    private Button Trans, accStat, deposit, withdraw, back;

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
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("accSStat.fxml"));
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

}

