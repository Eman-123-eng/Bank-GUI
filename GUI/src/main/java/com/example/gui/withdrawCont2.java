package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class withdrawCont2 {
    @FXML
    public Button M50, M100, M200, M500, M1000, M2000, M3000, anotherAmt;

    @FXML
    void onDraw(ActionEvent event) {
        System.out.println(event.getSource().equals(M50));
        if(event.getSource().equals(M50))
            checkBal(50);
        else if(event.getSource().equals(M100))
            checkBal(100);
        else if(event.getSource().equals(M200))
            checkBal(200);
        else if(event.getSource().equals(M500))
            checkBal(500);
        else if(event.getSource().equals(M1000))
            checkBal(1000);
        else if(event.getSource().equals(M2000))
            checkBal(2000);
        else if(event.getSource().equals(M3000))
            checkBal(3000);
        else{
            //open another window
        }
    }
    void checkBal(double amt){

    }

}
