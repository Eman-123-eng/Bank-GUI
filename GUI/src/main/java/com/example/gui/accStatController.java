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
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class accStatController implements Initializable {

    @FXML
    private TableView<MiniStatement> table;

    @FXML
    private TableColumn<MiniStatement, String> opCol, amtCol, dateCol;

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
            String first = s.split("--")[0];
            String sec = s.split("--")[1];

            //System.out.println("first: " + first + "  "+sec.split("at:")[1]);
            String[] ft = first.split(":");

            statesModel.add(new MiniStatement(ft[0].trim(), ft[1].trim(), sec.split("at:")[1]));
        }

        return statesModel;
    }

    private void loadState() {
        opCol.setCellValueFactory(new PropertyValueFactory<>("operation"));
        amtCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        table.setItems(states());
    }


}

