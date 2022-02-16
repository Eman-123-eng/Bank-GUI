package com.example.gui;

import BankManagement.BankAccount;
import customer.BankCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.util.Duration;

import java.util.Objects;

import static customer.BankCustomer.writeToCustFile;

public class EDITController {

    @FXML
    private TextField Acc_ID;

    @FXML
    private Label editLabel;

    @FXML
    private TextField Acc_no;

    @FXML
    private TextField editID;

    @FXML
    private Button editBtn;
    public static String id,no,you;

    @FXML
    void editBtn(ActionEvent event) {
        id = Acc_ID.getText();
        no = Acc_no.getText();

            if (BankAccount.isValidAcc(id)) {
                BankAccount acc = BankAccount.getAccount(id);
                BankCustomer me = BankCustomer.getAdminAccount(id);
                BankCustomer cust = BankCustomer.getCustAccount(id);
                if (acc != null && Objects.equals(acc.getAcctID(), id)
                        && Objects.equals(acc.getAcctNo(), no)) {
                    if (me !=null) {
                        if (Objects.equals(me.getPost(), "Manager") || Objects.equals(me.getPost(), "Accountant")) {// to check if it's an admin or Manager
                            Popup pp = new Popup();
                            Label l = new Label("you're not authorized to delete a Manager or an admin");
                            pp.getContent().add(l);
                            pp.setOpacity(1.0);

                            pp.setAutoHide(true);

                            PauseTransition delay = new PauseTransition(Duration.seconds(3));
                            delay.setOnFinished(e -> pp.hide());

                            if (!pp.isShowing()) {
                                pp.show(editBtn.getScene().getWindow());
                                delay.play();
                            }
                        }
                    }
                    else {

                        acc.setAcctID(editID.getText());
                        cust.setAcctID(editID.getText());
                        BankAccount.writeToFile();
                        BankCustomer.writeToCustFile();
                        System.out.println(acc.getAcctID());
                        editLabel.setText("The new account ID  is " + acc.getAcctID());
                    }


                }
                else{
                    editLabel.setText("Wrong Account Number!");
                }


            }else{
                editLabel.setText("This Account doesn't exist!");
            }

        }
    }



