package com.example.gui.adding;

import com.example.gui.MngController;
import customer.BankCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class addAdminController {

    @FXML
    private TextField StreetField;

    @FXML
    private TextField accID_Field;

    @FXML
    private Button add;

    @FXML
    private Label addLabel;

    @FXML
    private TextField cityField;

    @FXML
    private TextField custID_Field1;

    @FXML
    private TextField firstname_field;

    @FXML
    private TextField lastName_field;

    @FXML
    private TextField mobileField;

    @FXML
    private TextField post_field;

    private MngController pCont;
    Stage stage;
    Scene scene;
    Parent root;


    public void setParent(MngController controller) {
        pCont = controller;
    }

    public addAdminController getThis() {
        return this;
    }

    public void initialize() {
        System.out.println("child ");
    }

    @FXML
    void add(ActionEvent event) throws IOException {
        BankCustomer usr = new BankCustomer(custID_Field1.getText(),firstname_field.getText(),lastName_field.getText(),post_field.getText(),accID_Field.getText(),mobileField.getText());
        BankCustomer.getAdminArrayFile().add(usr);
        BankCustomer.writeToAdminFile();
        FXMLLoader loader = new FXMLLoader(MngController.class.getResource("ManagerDisplay.fxml"));
        Parent root = loader.load();
        pCont = loader.getController();

        FXMLLoader loadAcc = new FXMLLoader(MngController.class.getResource("addAcc.fxml"));
        Parent rootAcc = loadAcc.load();

        StackPane sp = new StackPane();

        sp.getChildren().add(rootAcc);

        sp.setId("stack");

        pCont.back.setText("go  "); //to be removed

        pCont.borderP.setCenter(sp);

        stage = (Stage) ( (Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

}
