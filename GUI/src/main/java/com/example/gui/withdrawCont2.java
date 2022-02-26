package com.example.gui;

import BankManagement.BankAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class withdrawCont2 {

    public Scene scene;
    public Parent root;
    public Stage stage;

    @FXML
    public Button M50, M100, M200, M500, M1000, M2000, M3000, anotherAmt;

    @FXML
    void onDraw(ActionEvent event) {
        Button source = (Button) event.getSource();
        System.out.println(source.equals(M50));
        if(source.equals(M50)){
            checkBal(50, source);
        }
        else if(source.equals(M100)) {
            checkBal(100, source);
        }
        else if(source.equals(M200)) {
            checkBal(200, source);
        }
        else if(source.equals(M500)) {
            checkBal(500, source);
        }
        else if(source.equals(M1000)) {
            checkBal(1000, source);
        }
        else if(source.equals(M2000)) {
            checkBal(2000, source);
        }
        else if(source.equals(M3000)) {
            checkBal(3000, source);
        }
        else{
            try {
                FXMLLoader fxml = new FXMLLoader(getClass().getResource("adminIDRequest.fxml"));
                root = fxml.load();
                stage = new Stage();
                stage.hide();
                scene = new Scene(root);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);
                stage.show();
               // Mng.getScene().getWindow().hide();
            } catch (Exception e) {
                System.out.println("can't load the page");
            }
        }
    }
    public void checkBal(double amt, Button btn){
        MainController m = new MainController();

        BankAccount myAcc = BankAccount.getAccount(MainController.ID);

        Label l = new Label("");

        if (myAcc == null) {
            l.setText("Cannot withdraw with this acc ");
            m.popupWindow(l, btn);
            return;
        }

        double myBal = myAcc.getBalance();
        if (amt > myBal) {
            l.setText("Do not have enough money");
            m.popupWindow(l, btn);
            return;
        }

        myAcc.setBalance(myAcc.getBalance() - amt);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy   HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        if (Objects.equals(myAcc.getOperations().get(0), "---")) myAcc.getOperations().remove(0);
        myAcc.getOperations().add(myAcc.getOperations().size(), "Withdrawal:" + amt + "-- at:" + dtf.format(now));

        l.setText("Successful operation");
        m.popupWindow(l, btn);
    }

}
