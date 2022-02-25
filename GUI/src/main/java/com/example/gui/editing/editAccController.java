package com.example.gui.editing;

import BankManagement.BankAccount;
import customer.BankCustomer;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.util.Duration;

import java.util.Objects;

import static customer.BankCustomer.writeToCustFile;
import static javafx.geometry.Pos.CENTER;


public class editAccController {

    @FXML
    private TextField Acc_ID;

    @FXML
    private Label editLabel;

    @FXML
    private TextField Acc_no;

    @FXML
    private TextField editID;
    @FXML
    private TextField adminID;

    @FXML
    private Button editBtn;
    public static String id,no,admin;


    @FXML
    private TextField No_Field;

    @FXML
    private TextField accID_Field;

    @FXML
    private Label addLabel;

    @FXML
    private Label add_Lbl;

    @FXML
    private TextField balance_field;

    @FXML
    private Button editAcc;

    @FXML
    private TextField typeField;

    @FXML
    void editAcc(ActionEvent event) {

    }

    @FXML
    void editBtn(ActionEvent event) {
        id = Acc_ID.getText();
        no = Acc_no.getText();
        admin = adminID.getText();

            if (BankAccount.isValidAcc(id)) {
                BankAccount acc = BankAccount.getAccount(id);
                BankCustomer ifAdmin = BankCustomer.getAdminAccount(id);
                BankCustomer me1 = BankCustomer.getAccbyAdminID(admin);
                BankCustomer ifCust = BankCustomer.getCustAccount(id);
                if (acc != null && Objects.equals(acc.getAcctID(), id)
                        && Objects.equals(acc.getAcctNo(), no)) {
                    if(!Objects.equals(me1.getPost(), "Manager")) {// if entered, it means he's an accountant not a manager
                        if (ifAdmin != null) {// if it entered it means that the account wanted to be edited is an admin acc.
                            if (Objects.equals(ifAdmin.getPost(), "Manager") || Objects.equals(ifAdmin.getPost(), "Accountant")) {// to check if it's an admin or Manager
                                Popup pp = new Popup();
                                Label l = new Label("you're not authorized to edit a Manager or an admin");
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
                                    pp.show(editBtn.getScene().getWindow());
                                    delay.play();
                                }
                            }
                        } else {

                            acc.setAcctID(editID.getText());
                            ifCust.setAcctID(editID.getText());
                            BankAccount.writeToFile();
                            BankCustomer.writeToCustFile();
                            System.out.println(acc.getAcctID());
                            editLabel.setText("The new account ID  is " + acc.getAcctID());
                        }
                    }// it's a manager
                    else{
                        if(ifAdmin!=null){
                            acc.setAcctID(editID.getText());
                            ifAdmin.setAcctID(editID.getText());
                            BankAccount.writeToFile();
                            BankCustomer.writeToAdminFile();
                            System.out.println(acc.getAcctID());
                            editLabel.setText("The new admin account ID  is " + acc.getAcctID());

                        }
                        else{
                            acc.setAcctID(editID.getText());
                            ifCust.setAcctID(editID.getText());
                            BankAccount.writeToFile();
                            BankCustomer.writeToCustFile();
                            System.out.println(acc.getAcctID());
                            editLabel.setText("The new customer account ID  is " + acc.getAcctID());
                        }
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



