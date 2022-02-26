package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class OtherDrawController {

    public Stage  stage;
    public Parent  root;
    public Scene  scene;

    public TextField amount;
    public Button backReq;
    public Button okBtn;

    public double amt;

    public void onBack(ActionEvent actionEvent) {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("adminCheck.fxml"));
        try {
            root= fxml.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = new Stage();
        stage.hide();
        scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        backReq.getScene().getWindow().hide();
    }

    public void onOk(ActionEvent actionEvent) {
        if(amount.getText().length() == 0){
            return;
        }

        amt = Double.parseDouble(amount.getText());

        withdrawCont2 w = new withdrawCont2();
            w.checkBal(amt, okBtn);

        System.out.println(" ok n draw");
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("custAccDisplay.fxml"));
        try {
            root= fxml.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = new Stage();
        stage.hide();
        scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        okBtn.getScene().getWindow().hide();

    }
}
