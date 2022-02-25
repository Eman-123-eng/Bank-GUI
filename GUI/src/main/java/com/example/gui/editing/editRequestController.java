package com.example.gui.editing;

import BankManagement.BankAccount;
import com.example.gui.MngController;
import com.example.gui.adding.addCustController;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static customer.BankCustomer.isValidCust;

public class editRequestController {
    @FXML
    private TextField ID,ID_user,ID_admin;

    @FXML
    private Button okBtn,okBtn_user,okBtn_admin;

    private static String id;

    private MngController parentCont;
    Stage stage;
    Scene scene;
    Parent root;


    public void setParent(MngController controller) {
        parentCont = controller;
    }

    public editRequestController getThis() {
        return this;
    }

    public void initialize() {
        System.out.println("child ");
    }

    public static String getIDtxt(){
        return id;
    }

    @FXML
    void okBtn(ActionEvent event) throws IOException{
        id=ID.getText();
        if(BankAccount.isValidAcc(id)){
            okBtn.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(MngController.class.getResource("ManagerDisplay.fxml"));
            Parent root = loader.load();
            parentCont = loader.getController();

            FXMLLoader loadAcc = new FXMLLoader(MngController.class.getResource("editAcc.fxml"));
            Parent rootAcc = loadAcc.load();

            StackPane sp = new StackPane();

            sp.getChildren().add(rootAcc);

            sp.setId("stack");

            parentCont.back.setText("go  "); //to be removed

            parentCont.borderP.setCenter(sp);

            stage = (Stage) ( (Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();




        }
        else{
            System.out.print("can't find account");
        }

    }
    @FXML
    void okBtn_user(ActionEvent event) throws IOException{
        id=ID_user.getText();
        System.out.print(isValidCust(id));
        if(isValidCust(id)){

            okBtn_user.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(MngController.class.getResource("ManagerDisplay.fxml"));
            Parent root = loader.load();
            parentCont = loader.getController();

            FXMLLoader loadAcc = new FXMLLoader(MngController.class.getResource("editCust.fxml"));
            Parent rootAcc = loadAcc.load();

            StackPane sp = new StackPane();

            sp.getChildren().add(rootAcc);


            sp.setId("stack");

            parentCont.back.setText("go  "); //to be removed

            parentCont.borderP.setCenter(sp);

            stage = (Stage) ( (Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);


            stage.show();
        }
        else{
            System.out.print("can't find account");
        }

    }
    @FXML
    void okBtn_admin(ActionEvent event) throws IOException{
        id=ID_admin.getText();
        if(BankCustomer.getAccbyAdminID(id)!=null){

            okBtn_admin.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(MngController.class.getResource("ManagerDisplay.fxml"));
            Parent root = loader.load();
            parentCont = loader.getController();

            FXMLLoader loadAcc = new FXMLLoader(MngController.class.getResource("editCust_Admin.fxml"));
            Parent rootAcc = loadAcc.load();

            StackPane sp = new StackPane();

            sp.getChildren().add(rootAcc);

            sp.setId("stack");

            parentCont.back.setText("go  "); //to be removed

            parentCont.borderP.setCenter(sp);

            stage = (Stage) ( (Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        }
        else{
            System.out.print("can't find account");
        }

    }
}
