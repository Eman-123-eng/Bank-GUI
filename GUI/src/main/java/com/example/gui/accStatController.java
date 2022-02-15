package com.example.gui;

import BankManagement.BankAccount;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
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
    private TableView<MiniStatement> table;

    @FXML
    private TableColumn<MiniStatement, String> opCol, dateCol, balCol;

    private BankAccount myAcc = BankAccount.getAccount(MainController.ID);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (myAcc == null) return;
        table.setEditable(true);
        loadState();
    }

    private ObservableList<MiniStatement> states() {

        ObservableList<MiniStatement> statesModel = FXCollections.observableArrayList(
                new MiniStatement("opopop", "date", "balanceee"),
                new MiniStatement("op2", "date", "balanceee")
        );

        for (String s : myAcc.getOperations()) {
            System.out.println("op: " + s);
            String first = s.split("--")[0];
            System.out.println("first: " + first);
            String[] ft = first.split(":");
            String op = ft[0];
            statesModel.add(new MiniStatement(ft[0], "date", "balanceee"));
        }

        return statesModel;
    }

    private void loadState() {
        opCol.setCellValueFactory(new PropertyValueFactory<MiniStatement, String>("operation"));
        dateCol.setCellValueFactory(new PropertyValueFactory<MiniStatement, String>("date"));
        balCol.setCellValueFactory(new PropertyValueFactory<MiniStatement, String>("balance"));

        table.setItems(states());
        table.getItems().addAll(states());
    }


}

