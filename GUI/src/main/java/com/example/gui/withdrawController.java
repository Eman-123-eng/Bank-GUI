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

public class withdrawController {

    @FXML
    private TextField drawAmt_field;

    @FXML
    private Label newBal_Label;

    @FXML
    private Button withdraw;

    @FXML
    void onDraw(ActionEvent event) {
        MainController m = new MainController();
        System.out.println("ID in withdraw: " + MainController.ID);
        BankAccount myAcc = BankAccount.getAccount(MainController.ID);
        Label l = new Label("");

        if (myAcc == null) {
            l.setText("Cannot withdraw with this acc ");
            m.popupWindow(l, withdraw);
            return;
        }

        if (drawAmt_field.getText().length() == 0) {
            l.setText("Enter the amount to be withdrawn");
            m.popupWindow(l, withdraw);
            return;
        }

        double amt = Double.parseDouble(drawAmt_field.getText());
        if (amt <= 0) {
            l.setText("Amounts less than 0 not allowed");
            m.popupWindow(l, withdraw);
            return;
        }

        double myBal = myAcc.getBalance();
        if (amt > myBal) {
            l.setText("Do not have enough money");
            m.popupWindow(l, withdraw);
            return;
        }

        myAcc.setBalance(myAcc.getBalance() - amt);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy   HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        if (Objects.equals(myAcc.getOperations().get(0), "---")) myAcc.getOperations().remove(0);
        myAcc.getOperations().add(myAcc.getOperations().size(), "Withdrawal:" + amt + "-- at:" + dtf.format(now));

        newBal_Label.setText("New Balance: " + myAcc.getBalance());
        drawAmt_field.setText("");

    }

}
