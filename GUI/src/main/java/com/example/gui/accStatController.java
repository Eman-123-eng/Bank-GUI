package com.example.gui;

import BankManagement.BankAccount;
import customer.BankCustomer;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class accStatController implements Initializable {

    @FXML
    private TableView<MiniStatement> table;

    @FXML
    private TableColumn<MiniStatement, String> opCol, amtCol, dateCol;
    @FXML
    private Label B_Label;

    private BankAccount myAcc = BankAccount.getAccount(MainController.ID);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (myAcc == null) return;

        table.setEditable(false);
        opCol.setResizable(false);
        amtCol.setResizable(false);
        dateCol.setResizable(false);
        loadState();  //To be updated so that if there is no previous transactions what will happen
    }

    private ObservableList<MiniStatement> states() {
        ObservableList<MiniStatement> statesModel = FXCollections.observableArrayList();

        for (String s : myAcc.getOperations()) {
            //System.out.println("op: " + s);
            if (Objects.equals(s, " ")) continue;
            String[] list = s.split("--");
            String op_amt = list[0];

            if (list.length > 1) {
                String[] tmp = list[1].split("at:");
                //System.out.println(tmp.length + " len");
                //System.out.println(tmp[0] + " len2");
                System.out.println(tmp[1] + " len2");
                String d = tmp[1].trim();
                String[] first = op_amt.split(":");


                statesModel.add(new MiniStatement(first[0].trim(), first[1].trim(), d));
            }
        }

        return statesModel;
    }

    private void loadState() {
        opCol.setCellValueFactory(new PropertyValueFactory<>("operation"));
        amtCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        table.setItems(states());
        B_Label.setText(String.valueOf(myAcc.getBalance()));
    }


}

