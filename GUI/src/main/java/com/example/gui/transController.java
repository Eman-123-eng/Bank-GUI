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

public class transController {

    @FXML
    private TextField transAmt_field, transTo_field;

    @FXML
    private Label transLabel;

    @FXML
    private Button transfer;

    @FXML
    void onTransfer(ActionEvent event) {
        MainController m = new MainController();

        System.out.println("ID in transfer: " + MainController.ID);
        BankAccount myAcc = BankAccount.getAccount(MainController.ID);
        Label l = new Label("");

        if (myAcc == null) {
            l.setText("Cannot transfer with this acc ");
            m.popupWindow(l, transfer);
            return;
        }

        if (transAmt_field.getText().length() == 0) {
            l.setText("Enter the amount to be transfer");
            m.popupWindow(l, transfer);
            return;
        }
        if (transTo_field.getText().length() == 0) {
            l.setText("Enter the other's account number");
            m.popupWindow(l, transfer);
            return;
        }

        double amt = Double.parseDouble(transAmt_field.getText());
        if (amt <= 0) {
            l.setText("Amounts less than 0 not allowed");
            m.popupWindow(l, transfer);
            return;
        }

        BankAccount toAcc = BankAccount.transToAcc(transTo_field.getText());
        if (toAcc == null) {
            l.setText("No account with this number");
            m.popupWindow(l, transfer);
            return;
        }

        double myBal = myAcc.getBalance();
        if (amt > myBal) {
            l.setText("Do not have enough money");
            m.popupWindow(l, transfer);
            return;
        }

        myAcc.setBalance(myAcc.getBalance() - amt);
        toAcc.setBalance(toAcc.getBalance() + amt);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        if(Objects.equals(myAcc.getOperations().get(0), "---")) myAcc.getOperations().remove(0);
        myAcc.getOperations().add(myAcc.getOperations().size(), "Transfer:" + amt + "-- to " + toAcc.getAcctNo() + "-- at:" + dtf.format(now));

        transLabel.setText("New Balance: " + myAcc.getBalance());
        transAmt_field.setText("");
        transTo_field.setText("");

        BankAccount.writeToFile(); //should be deleted and used once

    }

}
