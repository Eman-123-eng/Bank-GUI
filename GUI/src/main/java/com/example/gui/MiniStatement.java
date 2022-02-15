package com.example.gui;

import javafx.beans.property.SimpleStringProperty;

public class MiniStatement {

    public final SimpleStringProperty operation;
    public final SimpleStringProperty date;
    public final SimpleStringProperty amount;

    public MiniStatement(String op, String amount, String date) {
        this.operation = new SimpleStringProperty(op);
        this.amount = new SimpleStringProperty(amount);
        this.date = new SimpleStringProperty(date);
    }

    public String getOperation() {
        return operation.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getAmount() {
        return amount.get();
    }

    public void setOperation(String op) {
        operation.set(op);
    }

    public void setDate(String d) {
        date.set(d);
    }

    public void setAmount(String bal) {
        amount.set(bal);
    }


}
