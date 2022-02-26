package com.example.gui;

import BankManagement.BankAccount;
import customer.BankCustomer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DisplayingAcc {

    @FXML
    private Label accID;

    @FXML
    private Label accNo;

    @FXML
    private Label balance;

    @FXML
    private Label city;

    @FXML
    private Label custID;

    @FXML
    private Label firstN;

    @FXML
    private Label lastN;

    @FXML
    private Label mobile;

    @FXML
    private Label street;

    @FXML
    private Label usr_lbl;

    public void initialize(){
        BankCustomer usr = BankCustomer.getCustAccount(MainController.ID);
        BankAccount acc = BankAccount.getAccount(MainController.ID);
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
