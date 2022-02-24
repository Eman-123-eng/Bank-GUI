package com.example.gui.deleting;

import BankManagement.BankAccount;
import customer.BankCustomer;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.util.Duration;

import java.util.Objects;

import static javafx.geometry.Pos.CENTER;

public class adminDeleteController {

    @FXML
    private TextField Acc_ID;

    @FXML
    private TextField adminAccID;

    @FXML
    private Label deleteLabel;

    @FXML
    private Button deleteBtn,deleteUserBtn;
    public static String id,usr,admin;

    @FXML
    void deleteBtn(ActionEvent event) {
        id = Acc_ID.getText();
        admin = adminAccID.getText();


        if (BankAccount.isValidAcc(id)) {
            BankAccount acc = BankAccount.getAccount(id);
            BankCustomer admn = BankCustomer.getAccbyAdminID(admin);
            if (acc != null && Objects.equals(acc.getAcctID(), id)
                    && Objects.equals(Objects.requireNonNull(admn).getCustID(), admin)) {
                BankAccount.getAccArrayFile().remove(acc);
                BankCustomer.getAdminArrayFile().remove(admn);
                BankAccount.writeToFile();
                BankCustomer.writeToAdminFile();
                deleteLabel.setText("The account is deleted successfully!");

            } else {
                deleteLabel.setText("Wrong admin ID!");
            }

        }else {
            deleteLabel.setText("Wrong account ID!");
        }

    }

    }



