package com.example.gui.editing;

import customer.BankCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static customer.BankCustomer.writeToCustFile;

public class editCustController {

    @FXML
    private TextField StreetField;

    @FXML
    private TextField accID_user;

    @FXML
    private TextField cityField;

    @FXML
    private TextField custID_Field1;

    @FXML
    private Button editBtn_user;

    @FXML
    private TextField firstname_field;

    @FXML
    private TextField lastName_field;

    @FXML
    private TextField mobileField;

    @FXML
    private Label usr_lbl;

    public void initialize(){
        String id = editRequestController.getIDtxt();
        BankCustomer usr = BankCustomer.getAccbyCustID(id);
        firstname_field.setText(usr.getFirstName());
        lastName_field.setText(usr.getLastName());
        accID_user.setText(usr.getAcctID());
        custID_Field1.setText(usr.getCustID());
        cityField.setText(usr.getCity());
        StreetField.setText(usr.getStreet());
        mobileField.setText(usr.getMobile());
    }

    @FXML
    void editBtn_user(ActionEvent event) {
        BankCustomer usr = BankCustomer.getAccbyCustID(custID_Field1.getText());
        usr.setFirstName(firstname_field.getText());
        usr.setLastName(lastName_field.getText());
        usr.setCity(cityField.getText());
        usr.setMobile(mobileField.getText());
        usr.setStreet(StreetField.getText());
        writeToCustFile();
        usr_lbl.setText("Account is edited successfully!");

    }

}
