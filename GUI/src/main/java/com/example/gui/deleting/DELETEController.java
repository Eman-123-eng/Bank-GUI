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

public class DELETEController {

    @FXML
    private TextField Acc_ID;

    @FXML
    private TextField userID,adminAccID;

    @FXML
    private Label deleteLabel;

    @FXML
    private Button deleteBtn,deleteUserBtn;
    public static String id,no,admin;

    @FXML
    void deleteBtn(ActionEvent event) {
        id = Acc_ID.getText();


        if (BankAccount.isValidAcc(id)) {
            BankAccount acc = BankAccount.getAccount(id);
            BankCustomer ifAdmin = BankCustomer.getAdminAccount(id);
            BankCustomer me1 = BankCustomer.getAccbyAdminID(admin);
            BankCustomer ifCust = BankCustomer.getCustAccount(id);
            if (acc != null && Objects.equals(acc.getAcctID(), id)
                    ) {
                if(!Objects.equals(me1.getPost(), "Manager")) {// if entered, it means he's an accountant not a manager
                    if (ifAdmin != null) {// if it entered it means that the account wanted to be edited is an admin acc.
                        if (Objects.equals(ifAdmin.getPost(), "Manager") || Objects.equals(ifAdmin.getPost(), "Accountant")) {// to check if it's an admin or Manager
                            Popup pp = new Popup();
                            Label l = new Label("you're not authorized to delete a Manager or an admin");
                            l.setStyle("-fx-background-color: white;");
                            l.setFont(new Font("System Bold Italic", 16));
                            l.setMinWidth(200);
                            l.setMinHeight(100);
                            l.setAlignment(CENTER);
                            pp.getContent().add(l);
                            pp.setOpacity(1.0);

                            pp.setAutoHide(true);

                            PauseTransition delay = new PauseTransition(Duration.seconds(3));
                            delay.setOnFinished(e -> pp.hide());

                            if (!pp.isShowing()) {
                                pp.show(deleteBtn.getScene().getWindow());
                                delay.play();
                            }
                        }
                    } else {
                        BankAccount.getAccArrayFile().remove(acc);
                        BankCustomer.getCustArrayFile().remove(ifCust);
                        BankAccount.writeToFile();
                        BankCustomer.writeToCustFile();
                        deleteLabel.setText("The account is deleted successfully!");
                    }
                }// it's a manager
                else{
                    if(ifAdmin!=null){
                        BankAccount.getAccArrayFile().remove(acc);
                        BankCustomer.getAdminArrayFile().remove(ifAdmin);
                        BankAccount.writeToFile();
                        BankCustomer.writeToAdminFile();
                        System.out.println(acc.getAcctID());
                        deleteLabel.setText("The account is deleted successfully!");

                    }
                    else{
                        BankAccount.getAccArrayFile().remove(acc);
                        BankCustomer.getCustArrayFile().remove(ifCust);
                        BankAccount.writeToFile();
                        BankCustomer.writeToCustFile();
                        deleteLabel.setText("The account is deleted successfully!");
                    }
                }


            }
            else{
                deleteLabel.setText("Wrong Account Number!");
            }


        }else{
            deleteLabel.setText("This Account doesn't exist!");
        }

    }
    @FXML
    void deleteUserBtn(ActionEvent event){

    }

    }



