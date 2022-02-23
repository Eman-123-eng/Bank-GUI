package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import java.io.IOException;

public class AdminController {
    private Stage stage;
    private Parent root;
    private Scene scene;
    boolean isOn = false;

    @FXML
    private StackPane contentArea;

    @FXML
    private Button Manage, accStat, addBtn, deleteBtn, deposit, editBtn, transfer, transaction_Button, withdraw, exit;
    @FXML
    private MenuItem addAdmin;

    @FXML
    private MenuItem addUser;

    @FXML
    private Label adminName;


    @FXML
    private MenuItem deleteAdmin;

    @FXML
    private MenuItem deleteUser;

    @FXML
    private MenuItem editAdmin;

    @FXML
    private MenuItem editUser;

    @FXML
    void addAdmin(ActionEvent event) {

    }

    @FXML
    void addUser(ActionEvent event) {

    }

    @FXML
    void deleteAdmin(ActionEvent event) {

    }

    @FXML
    void deleteUser(ActionEvent event) {

    }

    @FXML
    void editAdmin(ActionEvent event) {

    }

    @FXML
    void editUser(ActionEvent event) {

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
        } catch (Exception e) {
            System.out.print("this scene can't load");
        }
    }


    @FXML
    void addBtn(ActionEvent event) throws IOException {
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("addAcc.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }

    @FXML
    void deleteBtn(ActionEvent event) throws IOException {
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("adminDELETE.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }

    @FXML
    void editBtn(ActionEvent event) throws IOException {
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("adminEDIT.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);
    }


    @FXML
    void deposit(ActionEvent event) throws IOException {
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("deposit.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

        //deposit.getStyleClass().add("deposit");

        deposit.setStyle("-fx-background-color: #c7b4b4;");
        withdraw.setStyle("-fx-background-color: NONE;");
        transfer.setStyle("-fx-background-color: NONE;");
        accStat.setStyle("-fx-background-color: NONE;");

    }

    @FXML
    void withdraw(ActionEvent event) throws IOException {
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("withdraw.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);


        withdraw.setStyle("-fx-background-color: #c7b4b4;");
        deposit.setStyle("-fx-background-color: NONE;");
        transfer.setStyle("-fx-background-color: NONE;");
        accStat.setStyle("-fx-background-color: NONE;");
    }

    @FXML
    void accStat(ActionEvent event) throws IOException {
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("accStat.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

        accStat.setStyle("-fx-background-color: #c7b4b4;");
        deposit.setStyle("-fx-background-color: NONE;");
        transfer.setStyle("-fx-background-color: NONE;");
        withdraw.setStyle("-fx-background-color: NONE;");

    }

    @FXML
    void transfer(ActionEvent event) throws IOException {
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("transfer.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

        transfer.setStyle("-fx-background-color: #c7b4b4;");
        withdraw.setStyle("-fx-background-color: NONE;");
        deposit.setStyle("-fx-background-color: NONE;");
        accStat.setStyle("-fx-background-color: NONE;");

    }

}
