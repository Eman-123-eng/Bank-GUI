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

public class userDeleteController {

    @FXML
    private TextField Acc_ID;

    @FXML
    private TextField userID;

    @FXML
    private Label deleteLabel;

    @FXML
    private Button deleteUserBtn;
    public static String id,usr;

    @FXML
    void deleteUserBtn(ActionEvent event){
        id = Acc_ID.getText();
        usr = userID.getText();

        if (BankAccount.isValidAcc(id)) {
            BankAccount acc = BankAccount.getAccount(id);
            BankCustomer person = BankCustomer.getCustAccount(id);
            if (acc != null && Objects.equals(acc.getAcctID(), id)
                    && Objects.equals(Objects.requireNonNull(person).getCustID(), usr)) {
                BankAccount.getAccArrayFile().remove(acc);
                BankCustomer.getCustArrayFile().remove(person);
                BankAccount.writeToFile();
                BankCustomer.writeToCustFile();
                deleteLabel.setText("The account is deleted successfully!");

            } else {
                deleteLabel.setText("Wrong User ID!");
            }

        }else {
            deleteLabel.setText("Wrong account ID!");
        }
    }


}



