package com.example.gui;
import static customer.BankCustomer.isValidCust;
import static BankManagement.BankAccount.isValidAcc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;

public class MainController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Stage stage2;
    private Scene scene2;
    private Parent root2;
    
    @FXML
    private TextField StreetField;

    @FXML
    private Label exit;

    @FXML
    private TextField cityField;

    @FXML
    private Button createAcc;

    @FXML
    private TextField firstname_field;

    @FXML
    private TextField id_register;

    @FXML
    private TextField mobileField;

    @FXML
    private TextField secondName_field;


    @FXML
    private TextField id_field;

    @FXML
    private Button signin;

    @FXML
    private Hyperlink signup_link;

    @FXML
    void exit(MouseEvent event) {
        System.exit(0);

    }

    @FXML
    void buttonPressed(ActionEvent event) throws IOException {

//            System.out.println(isValidAcc(id_field.getText()));
//            if(isValidAcc(id_field.getText())){
//
//            }
//            System.out.println(isValidCust(id_field.getText()));

            try {// this code to switch to another frame.
                FXMLLoader fxml2 = new FXMLLoader(getClass().getResource("custAccDisplay.fxml"));
                root2= fxml2.load();
                stage2 = new Stage();
                scene2 = new Scene(root2);
                stage2.initStyle(StageStyle.UNDECORATED);
                stage2.setScene(scene2);
                stage2.show();
            }
            catch(Exception e){
                System.out.print("this scene can't load");
            }

    }

    @FXML
    void createAcc(MouseEvent event) {
        System.out.print("0");

    }
    @FXML
    void Signup(ActionEvent event) throws IOException {
        System.out.print("sign up is clicket\n");
        try {// this code to switch to another frame.
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("Register.fxml"));
            root= fxml.load();
            stage = new Stage();
            scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            System.out.print("this scene can't load");
        }
    }


}
