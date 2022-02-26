package com.example.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class OtherDrawController {


    public TextField amount;
    public Button backReq;
    public Button okBtn;

    public double amt;

    public void onBack(ActionEvent actionEvent) {
    }

    public void onOk(ActionEvent actionEvent) {
        if(amount.getText().length() == 0){
            return;
        }

        amt = Double.parseDouble(amount.getText());

        withdrawCont2 w = new withdrawCont2();
            w.checkBal(amt, okBtn);

    }
}
