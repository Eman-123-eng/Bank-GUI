package com.example.gui.adding;

import BankManagement.BankAccount;
import com.example.gui.MngController;
import customer.BankCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.time.LocalDate;


import static BankManagement.BankAccount.isValidAcc;

public class addCustController {
    @FXML
    private TextField StreetField;

    @FXML
    private TextField accID_Field;


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
    void addAcc(ActionEvent event) throws IOException {
        MngController m = new MngController();
//        BankCustomer cust = new BankCustomer(custID_Field1.getText(),firstname_field.getText(),lastName_field.getText(),accID_Field.getText(),cityField.getText(),StreetField.getText(),mobileField.getText());
//        BankCustomer.getCustArrayFile().add(cust);
//        BankCustomer.writeToCustFile();

//        FXMLLoader fxml1 = new FXMLLoader(m.getClass().getResource("addAcc.fxml"));
//        Parent root1 = fxml1.load();
         //m.setStackPane(s);
         m.setStackPane("addAcc.fxml");
//        m.getContentArea().getChildren().removeAll();
//        m.getContentArea().getChildren().setAll(root1);
        //addLabel.setText("Account is added successfully!");


    }



}
