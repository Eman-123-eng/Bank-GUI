package com.example.gui.editing;

import BankManagement.BankAccount;
import customer.BankCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class editRequestController {
    @FXML
    private TextField ID,ID_user,ID_admin;

    @FXML
    private Button okBtn,okBtn_user,okBtn_admin;

    private String id;

    public void show1(String loadFile) throws IOException {
        FXMLLoader fxml2 = new FXMLLoader(getClass().getResource(loadFile));
        Parent root2 = fxml2.load();
        Stage stage2 = new Stage();
        //Scene scene2 = new Scene(root2);
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setScene(new Scene(root2));
        stage2.show();
    }

    @FXML
    void okBtn(ActionEvent event) throws IOException{
        id=ID.getText();
        if(BankAccount.isValidAcc(id)){
            show1("com/example/gui/editAcc.fxml");
        }
        else{
            System.out.print("can't find account");
        }

    }
    @FXML
    void okBtn_user(ActionEvent event) throws IOException{
        id=ID_user.getText();
        if(BankCustomer.isValidCust(id)){
            show1("com/example/gui/editCust.fxml");
        }
        else{
            System.out.print("can't find account");
        }

    }
    @FXML
    void okBtn_admin(ActionEvent event) throws IOException{
        id=ID_admin.getText();
        if(BankCustomer.getAccbyAdminID(id)!=null){
            show1("com/example/gui/editCust_Admin.fxml");
        }
        else{
            System.out.print("can't find account");
        }

    }
}
