package com.example.gui.adding;

import BankManagement.BankAccount;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    Stage stage;
    Scene scene;
    Parent root;


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
        BankCustomer usr = new BankCustomer(custID_Field1.getText(),firstname_field.getText(),lastName_field.getText(),accID_Field.getText(),cityField.getText(),StreetField.getText(),mobileField.getText());
        BankCustomer.getCustArrayFile().add(usr);
        BankCustomer.writeToCustFile();
        FXMLLoader loader = new FXMLLoader(MngController.class.getResource("ManagerDisplay.fxml"));
        Parent root = loader.load();
        parentCont = loader.getController();

        FXMLLoader loadAcc1 = new FXMLLoader(MngController.class.getResource("addAcc.fxml"));
        Parent rootAcc1 = loadAcc1.load();

        StackPane sp = new StackPane();

        sp.getChildren().add(rootAcc1);

        sp.setId("stack");

        parentCont.borderP.setCenter(sp);
        if(MngController.isManager==1){
            parentCont.item4 = new MenuItem("             Edit Admin            ");
            parentCont.item4.setOnAction(eventt ->{
                try {
                    System.out.println(" ediiiiit");
                    FXMLLoader fxml4 = new FXMLLoader(getClass().getResource("editRequestAdmin.fxml"));
                    parentCont.root2 = fxml4.load();
                    parentCont.stage2 = new Stage();
                    parentCont.stage2.hide();
                    parentCont.scene2 = new Scene(parentCont.root2);
                    parentCont.stage2.initModality(Modality.APPLICATION_MODAL);
                    parentCont.stage2.initStyle(StageStyle.UNDECORATED);
                    parentCont.stage2.setScene(parentCont.scene2);
                    parentCont.stage2.show();
                    parentCont.editBtn.getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            parentCont.deleteMenu.getItems().add( parentCont.addMenuItems("             Delete Admin            ","adminDELETE.fxml"));
            parentCont.addMenu.getItems().add( parentCont.addMenuItems("             Add Admin            ","addCust_Admin.fxml"));
            parentCont.editMenu.getItems().add(parentCont.item4);}
        
        stage = (Stage) ( (Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }



}
