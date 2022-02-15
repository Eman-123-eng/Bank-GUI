package com.example.gui;

import BankManagement.BankAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class depositController {

    @FXML
    private TextField depAmt_field;

    @FXML
    private Button deposit;

    @FXML
    private Label newBal_Label;

    @FXML
    void onDeposit(ActionEvent event) {
        MainController m = new MainController();
        System.out.println("ID in deposit: " + MainController.ID);
        BankAccount myAcc = BankAccount.getAccount(MainController.ID);
        Label l = new Label("");

        if (myAcc == null) {
            l.setText("Cannot deposit with this acc ");
            m.popupWindow(l, deposit);
            return;
        }

        if (depAmt_field.getText().length() == 0) {
            l.setText("Enter the amount to be deposited");
            m.popupWindow(l, deposit);
            return;
        }

        double amt = Double.parseDouble(depAmt_field.getText());
        if (amt <= 0) {
            l.setText("Amounts less than 0 not allowed");
            m.popupWindow(l, deposit);
            return;
        }

        myAcc.setBalance(myAcc.getBalance() + amt);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        if(Objects.equals(myAcc.getOperations().get(0), "---")) myAcc.getOperations().remove(0);
        myAcc.getOperations().add(myAcc.getOperations().size(), "Deposition:" + amt + "-- at:" + dtf.format(now));

        newBal_Label.setText("New Balance: " + myAcc.getBalance());
        depAmt_field.setText("");

        BankAccount.writeToFile();
    }

}

