package com.example.gui.editing;

import customer.BankCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static customer.BankCustomer.writeToAdminFile;

public class editAdminController {

    @FXML
    private TextField accID_admin;

    @FXML
    private TextField adminID;

    @FXML
    private Label admin_lbl;

    @FXML
    private Button editBtn_admin;

    @FXML
    private TextField firstname_admin;

    @FXML
    private TextField lastName_admin;

    @FXML
    private TextField mobile_admin;

    @FXML
    private TextField post_field;

    public void initialize(){
        String id = editRequestController.getIDtxt();
        BankCustomer admn = BankCustomer.getAccbyAdminID(id);
        firstname_admin.setText(admn.getFirstName());
        lastName_admin.setText(admn.getLastName());
        accID_admin.setText(admn.getAcctID());
        adminID.setText(admn.getCustID());
        mobile_admin.setText(admn.getMobile());
        post_field.setText(admn.getPost());
    }

    @FXML
    void editBtn_admin(ActionEvent event) {
        BankCustomer usr = BankCustomer.getAccbyAdminID(adminID.getText());
        usr.setFirstName(firstname_admin.getText());
        usr.setLastName(lastName_admin.getText());
        usr.setMobile(mobile_admin.getText());
        usr.setPost(post_field.getText());
        writeToAdminFile();
        admin_lbl.setText("Account is edited successfully!");

    }

}
