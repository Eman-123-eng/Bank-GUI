package com.example.gui.adding;

import BankManagement.BankAccount;
import com.example.gui.MngController;
import customer.BankCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;


import static BankManagement.BankAccount.isValidAcc;

public class addCustController {
    @FXML
    private TextField StreetField;

    @FXML
    private TextField accID_Field;


    @FXML
    private Button addAcc;

    @FXML
    private Label addLabel;

    @FXML
    private TextField cityField;

    @FXML
    private TextField custID_Field1;

    @FXML
    private TextField balanceField;

    @FXML
    private TextField firstname_field;

    @FXML
    private TextField lastName_field;

    @FXML
    private TextField mobileField;

    private MngController parentCont;
    Stage window;

    public void setParent(MngController controller) {
        parentCont = controller;
    }

    public addCustController getThis() {
        return this;
    }

    public void initialize() {
        System.out.println("child ");
    }

    @FXML
    void addAcc(ActionEvent event) throws IOException {
        StackPane sp = new StackPane();
        Button b = new Button("Hellooooooooooooooo");
        FXMLLoader loader2 = new FXMLLoader(MngController.class.getResource("addAcc.fxml"));
        Parent root2 = loader2.load();

        sp.getChildren().add(b);
        sp.getChildren().add(root2);
        FXMLLoader loader = new FXMLLoader(MngController.class.getResource("ManagerDisplay.fxml"));
        Parent root = loader.load();
        parentCont = loader.getController();
        sp.setId("stack");
        parentCont.back.setText("go  ");
        System.out.println(parentCont.back.getText());

        parentCont.borderP.setCenter(sp);
        System.out.println(parentCont.borderP.getCenter().getId());
        System.out.println(parentCont.borderP.getTop().getId());
        Scene scene = new Scene(root);
        window = new Stage();
        window.setScene(scene);
        window.show();

    }



}
