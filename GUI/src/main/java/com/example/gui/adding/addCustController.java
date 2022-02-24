package com.example.gui.adding;

import BankManagement.BankAccount;
import customer.BankCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;


import static BankManagement.BankAccount.isValidAcc;

public class addCustController {
    @FXML
    private TextField StreetField;

    @FXML
    private TextField accID_Field;

    @FXML
    private TextField accNo_Field1;

    @FXML
    private Button addAcc;

    @FXML
    private Label addLabel;

    @FXML
    private TextField cityField;

    @FXML
    private TextField custID_Field1;

    @FXML
    private TextField balanceField;

    @FXML
    private TextField firstname_field;

    @FXML
    private TextField lastName_field;

    @FXML
    private TextField mobileField;

    @FXML
    private TextField typeField1;




    @FXML
    void addAcc(ActionEvent event) {
        BankAccount acc = new BankAccount(accID_Field.getText(),accNo_Field1.getText(),LocalDate.now(),typeField1.getText()) ;
        BankCustomer cust = new BankCustomer(custID_Field1.getText(),firstname_field.getText(),lastName_field.getText(),accID_Field.getText(),cityField.getText(),StreetField.getText(),mobileField.getText());

        acc.setBalance(Double.parseDouble(balanceField.getText()));
        acc.setCustID(custID_Field1.getText());
        BankCustomer.getCustArrayFile().add(cust);
        BankAccount.getAccArrayFile().add(acc);
        BankCustomer.writeToCustFile();
        BankAccount.writeToFile();
        addLabel.setText("Account is added successfully!");
        System.out.println(isValidAcc(acc.getAcctID()));

    }



}
