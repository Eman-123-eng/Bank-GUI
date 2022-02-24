package com.example.gui;

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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

import java.io.IOException;
import java.util.Objects;

public class MngController {
    private Stage stage2,stage;
    private Parent root2,root;
    private static String id;

    @FXML
    private Button Mng;

    @FXML
    private Button Trans;
    @FXML
    private TextField ID;

    @FXML
    private Button okBtn;

    @FXML
    private StackPane contentArea;

    @FXML
    private Button Manage,back, accStat, addBtn, deleteBtn, deposit, editBtn, transfer, transaction_Button, withdraw;
    @FXML
    private MenuItem addAdmin;

    @FXML
    private MenuItem addUser;

    @FXML
    private Label adminName;
    @FXML
    private MenuItem deleteAcc;
    @FXML
    private Label exit;



    @FXML
    private MenuItem deleteAdmin;

    @FXML
    private MenuItem deleteUser;
    @FXML
    private MenuItem editAcc;
    @FXML
    private MenuItem editAdmin;

    @FXML
    private MenuItem editUser;

    @FXML
    void addAdmin(ActionEvent event) throws IOException{
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("addCust_Admin.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);
    }

    @FXML
    void addUser(ActionEvent event) throws IOException{
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("addCust.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }

    @FXML
    void deleteAdmin(ActionEvent event) throws IOException{
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("adminDELETE.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }

    @FXML
    void deleteUser(ActionEvent event) throws IOException{
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("userDELETE.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }

    @FXML
    void editAdmin(ActionEvent event) throws IOException{
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("editCust_Admin.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }

    @FXML
    void editUser(ActionEvent event) throws IOException{
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("editCust.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }
    @FXML
    void editAcc(ActionEvent event) throws IOException{
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("editAcc.fxml"));
        Parent root1 = fxml1.load();

        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }
    @FXML
    void exit(MouseEvent event) {
        try {// this code to switch to another frame.
            show("exit.fxml");
        } catch (Exception e) {
            System.out.print("this scene can't load");
        }
    }





    public void show(String loadFile) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource(loadFile));
        root2 = fxml.load();
        stage2 = new Stage();
        //scene2 = new Scene(root2);
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setScene(new Scene(root2));
        stage2.show();
    }


    @FXML
    void back(ActionEvent event) {
        try {
            show("adminCheck.fxml");
            back.getScene().getWindow().hide();
        }
        catch(Exception e){
            System.out.println("can't load the page");
        }

    }

    @FXML
    void okBtn(ActionEvent event) {
        id=ID.getText();
        adminDisplay(id);
        adminName.setText("Welcome "+ Objects.requireNonNull(BankCustomer.getAccbyAdminID(id)).getFirstName());
        adminName.setVisible(true);
    }
    public void adminDisplay(String id) {
        if(Objects.equals(Objects.requireNonNull(BankCustomer.getAccbyAdminID(id)).getPost(),"Manager")){
            try {
                show("ManagerDisplay.fxml");
                okBtn.getScene().getWindow().hide();

            }
            catch(Exception e){
                System.out.println("can't load the page");
            }
        }
        else{
            try {
                show("AdminDisplay.fxml");
                okBtn.getScene().getWindow().hide();
                //adminName.setText("Welcome "+ Objects.requireNonNull(BankCustomer.getAccbyAdminID(id)).getFirstName());

            }
            catch(Exception e){
                System.out.println("can't load the page");
            }


        }

    }


    @FXML
    void Mng(ActionEvent event) {
        try {
            show("adminIDRequest.fxml");
            Mng.getScene().getWindow().hide();
        }
        catch(Exception e){
            System.out.println("can't load the page");
        }
    }

    @FXML
    void Trans(ActionEvent event) {
        try {
            show("custAccDisplay.fxml");
            Mng.getScene().getWindow().hide();
        }
        catch(Exception e){
            System.out.println("can't load the page");
        }

    }

}
