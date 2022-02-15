package com.example.gui;

import BankManagement.BankAccount;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class accStatController implements Initializable {

    @FXML
    private TableView<extractState> table;

    @FXML
    private TableColumn<extractState, ?> opCol, dateCol, balCol;

    private BankAccount myAcc = BankAccount.getAccount(MainController.ID);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (myAcc == null) return;
        loadState();
    }

    private ObservableList<extractState> states() {

        ObservableList<extractState> statesModel = FXCollections.observableArrayList();

        for (String s : myAcc.getOperations()) {
            System.out.println("op: " + s);
            String first = s.split("--")[0];
            System.out.println("first: " + first);
            String[] ft = first.split(":");
            String op = ft[0];
            statesModel.add(new extractState(ft[0], "date", "balanceee"));
        }

        return statesModel;
    }

    private void loadState() {
        opCol.setCellValueFactory(new PropertyValueFactory<>("operations"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        balCol.setCellValueFactory(new PropertyValueFactory<>("balance"));

        table.setItems(states());
        table.getColumns().addAll(opCol, dateCol, balCol);
    }


}

class extractState {
    String operation;
    String date;
    String balance;

    extractState(String operations, String date, String balance) {
        this.operation = operations;
        this.date = date;
        this.balance = balance;
    }
}