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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class addAccController {

    @FXML
    private TextField No_Field;

    @FXML
    private TextField accID_Field;

    @FXML
    private Button addAcc;

    @FXML
    private Label addLabel;

    @FXML
    private Label add_Lbl;

    @FXML
    private TextField balance_field,accPsswrd_Field1;

    @FXML
    private TextField typeField;
    private MngController parentCont;
    Stage stage;
    Scene scene;
    Parent root;


    public void setParent(MngController controller) {
        parentCont = controller;
    }

    public addAccController getThis() {
        return this;
    }

    public void initialize() throws IOException {
        System.out.println("child ");
        FXMLLoader loader = new FXMLLoader(MngController.class.getResource("ManagerDisplay.fxml"));
        Parent root = loader.load();
        parentCont = loader.getController();
        System.out.print(MngController.isManager);
        if(MngController.isManager==1){


            parentCont.item4 = new MenuItem("             Edit Admin            ");
            parentCont.item4.setOnAction(event ->{
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
            parentCont.addMenu.getItems().add( parentCont.addMenuItems("             Delete Admin            ","adminDELETE.fxml"));
            parentCont.deleteMenu.getItems().add( parentCont.addMenuItems("             Add Admin            ","addCust_Admin.fxml"));
            parentCont.editMenu.getItems().add(parentCont.item4);
            System.out.print("not loading");
            System.out.println(parentCont.addMenu.getItems().size());
            stage = (Stage)  parentCont.addMenu.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }


    @FXML
    void addAcc(ActionEvent event) {
        try {
            BankAccount acc = new BankAccount(accID_Field.getText(),accPsswrd_Field1.getText(), No_Field.getText(), LocalDate.now(), typeField.getText());
            acc.setBalance(Double.parseDouble(balance_field.getText()));
            acc.setCustID(Objects.requireNonNull(BankCustomer.getCustAccount(acc.getAcctID())).getCustID());
            acc.getOperations().add(String.valueOf(acc.getDateOpened()));
            BankAccount.getAccArrayFile().add(acc);
            BankAccount.writeToFile();
            add_Lbl.setText("Account is added successfully!");
        }
        catch(Exception e){
            System.out.println("can't add the account");
        }
    }

}
