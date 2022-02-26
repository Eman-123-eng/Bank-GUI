package com.example.gui;

import BankManagement.BankAccount;
import customer.BankCustomer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DisplayingAcc {

    @FXML
    private Label accID,  accNo, balance,city, custID, firstN,lastN, mobile, street, usr_lbl;

    public void initialize(){
        BankCustomer usr = BankCustomer.getCustAccount(MainController.ID);
        BankAccount acc = BankAccount.getAccount(MainController.ID);
        System.out.println(firstN);
        firstN.setText(usr.getFirstName());
        lastN.setText(usr.getLastName());
        accID.setText(acc.getAcctID());
        custID.setText(acc.getCustID());
        mobile.setText(usr.getMobile());
        street.setText(usr.getStreet());
        city.setText(usr.getCity());
        accNo.setText(acc.getAcctNo());
        balance.setText(String.valueOf(acc.getBalance()));
    }

}
