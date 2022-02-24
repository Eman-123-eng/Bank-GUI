package com.example.gui.adding;

import BankManagement.BankAccount;
import customer.BankCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.Objects;

public class addAccController {

    @FXML
    private TextField No_Field;

    @FXML
    private TextField accID_Field;

    @FXML
    private Button addAcc;

    @FXML
    private Label addLabel;

    @FXML
    private Label add_Lbl;

    @FXML
    private TextField balance_field;

    @FXML
    private TextField typeField;

    @FXML
    void addAcc(ActionEvent event) {
        try {
            BankAccount acc = new BankAccount(accID_Field.getText(), No_Field.getText(), LocalDate.now(), typeField.getText());
            acc.setBalance(Double.parseDouble(balance_field.getText()));
            acc.setCustID(Objects.requireNonNull(BankCustomer.getCustAccount(acc.getAcctID())).getCustID());
            acc.getOperations().add(String.valueOf(acc.getDateOpened()));
            BankAccount.getAccArrayFile().add(acc);
            BankAccount.writeToFile();
            add_Lbl.setText("Account is added successfully!");
        }
        catch(Exception e){
            System.out.println("can't add the account");
        }
    }

}
