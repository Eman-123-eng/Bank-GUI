package com.example.gui;

import javafx.beans.property.SimpleStringProperty;

public class MiniStatement {

    public final SimpleStringProperty operation ;
    public final SimpleStringProperty date;
    public final SimpleStringProperty balance;

    public MiniStatement(String op, String date, String balance) {
        this.operation = new SimpleStringProperty(op);
        this.date = new SimpleStringProperty(date);
        this.balance = new SimpleStringProperty(balance);
    }

}
