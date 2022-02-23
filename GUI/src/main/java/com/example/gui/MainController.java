package com.example.gui;


import BankManagement.BankAccount;
import customer.BankCustomer;

import static javafx.geometry.Pos.CENTER;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


import java.io.IOException;
import java.util.Objects;

public class MainController {
    private Stage stage, stage2;

    private Scene scene, scene2;

    private Parent root, root2;

    @FXML
    private TextField id_field, StreetField, cityField, fn_field, id_register, mobileField, ln_field;
    public static String ID;

    @FXML
    private Label exit;

    @FXML
    private Button signin, createAcc, register_exit;

    @FXML
    private Hyperlink signup_link;

    @FXML
    void exit(MouseEvent event) {
        System.out.println("Sign out5");
        System.exit(0);
    }

    @FXML
    void register_exit(ActionEvent event) {
        try {// this code to switch to another frame.
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            root = fxml.load();
            stage = new Stage();
            scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.print("this scene can't load");
        }

    }

    @FXML
    void buttonPressed(ActionEvent event) throws IOException {
        try {// this code to switch to another frame.

            String checked = checkID(id_field.getText());

            if (Objects.equals(checked, "Customer")) {
                showStage("custAccDisplay.fxml");
                signin.getScene().getWindow().hide();

            } else if (Objects.equals(checked, "Admin")) {
                showStage("AdminDisplay.fxml");
                signin.getScene().getWindow().hide();

            } else {
                System.out.print("The checked is null");
                Label l = new Label("The id is incorrect");
                popupWindow(l, signin);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("this scene can't load with error: " + e);
        }
    }

    public void popupWindow(Label l, Button btn) {
        l.setStyle("-fx-background-color: white;");
        l.setMinWidth(200);
        l.setFont(new Font("System Bold Italic", 16));
        l.setMinHeight(100);
        l.setAlignment(CENTER);

        //scene2.getStylesheets().add("src/main/java/css/styles.css");
        //l.getStyleClass().add("popup");

        Popup pp = new Popup();
        pp.getContent().add(l);

        pp.setAutoHide(true);

        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(e -> pp.hide());

        if (!pp.isShowing()) {
            pp.show(btn.getScene().getWindow());
            delay.play();
        }
    }

    //this method to show the stage instead of writing it so much
    public void showStage(String loadFile) throws IOException {
        FXMLLoader fxml2 = new FXMLLoader(getClass().getResource(loadFile));
        root2 = fxml2.load();
        stage2 = new Stage();
        //scene2 = new Scene(root2);
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setScene(new Scene(root2));
        stage2.show();
    }

    public static String checkID(String id) {
        System.out.println(BankAccount.isValidAcc(id));
        MainController m = new MainController();
        if (BankAccount.isValidAcc(id)) { // Thus, it is an existing account
            MainController.ID = m.id_field.getText();
            if (BankAccount.getAccount(id) != null && BankCustomer.isValidCust(BankAccount.getAccount(id).getCustID())) { //thus, you are a customer
                //if (BankCustomer.isValidPass(String.valueOf(pass))) {
                m.id_field.setText("");
                System.out.println("You are a customer");
                return "Customer";
                /*} else {
                    System.out.println("Wrong password");
                    JOptionPane.showMessageDialog(null, "This is an invalid account");
                }*/
            } else {
                m.id_field.setText("");
                //psw.setText("");
                System.out.println("You are an admin");
                return "Admin";
            }
        }
        return null;
    }

    @FXML
    void createAcc(MouseEvent event) {
        System.out.print("0");
//        if (BankCustomer.customerArrayFile != null) {
//            BankCustomer newRow;
//            newRow = new BankCustomer(id_register.getText(), firstname_field.getText(), secondName_field.getText(), cityField.getText(), null, StreetField.getText(), mobileField.getText());
//            BankCustomer.customerArrayFile.add(newRow);
//            try {
//                customersCSVWriter = new BufferedWriter(new FileWriter("C:\\Users\\WIN 10\\Desktop\\Java-Bank-Project\\src\\CUSTOMER\\customers.csv"));
//
//                customersCSVWriter.write("Customer id");
//                customersCSVWriter.append(','); //to add new column
//                customersCSVWriter.write("customer FirstName");
//                customersCSVWriter.append(',');
//                customersCSVWriter.write("customer LastName");
//                customersCSVWriter.append(',');
//                customersCSVWriter.write("customer City");
//                customersCSVWriter.append(',');
//                customersCSVWriter.write("customer Street");
//                customersCSVWriter.append(',');
//                customersCSVWriter.write("customer Mobile");
//                for (BankCustomer customer : BankCustomer.customerArrayFile) {
//                    customersCSVWriter.append('\n'); //to add new row
//                    customersCSVWriter.write(customer.getCustId());
//                    customersCSVWriter.append(',');
//                    customersCSVWriter.write(customer.getCustFirstName());
//                    customersCSVWriter.append(',');
//                    customersCSVWriter.write(customer.getCustLastName());
//                    customersCSVWriter.append(',');
//                    customersCSVWriter.write(customer.getCustCity());
//                    customersCSVWriter.append(',');
//                    customersCSVWriter.write(customer.getCustStreet());
//                    customersCSVWriter.append(',');
//                    customersCSVWriter.write(customer.getCustMobile());
//
//                }
//                customersCSVWriter.flush();
//                customersCSVWriter.close();
//
//            } catch (Exception ex) {
//                System.out.println("There is error in writing: " + ex);
//            }
//        }

    }

    @FXML
    void Signup(ActionEvent event) throws IOException {
        System.out.print("sign up is clicket\n");
        Label l = new Label("Please visit our Bank to open your account!");
        l.setStyle("-fx-background-color: white;");
        l.setFont(new Font("System Bold Italic", 16));
        l.setMinWidth(200);
        l.setMinHeight(100);
        l.setAlignment(CENTER);

        //scene2.getStylesheets().add("src/main/java/css/styles.css");
        //l.getStyleClass().add("popup");

        Popup pp = new Popup();
        pp.getContent().add(l);

        pp.setAutoHide(true);

        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(e -> pp.hide());

        if (!pp.isShowing()) {
            pp.show(signup_link.getScene().getWindow());
            delay.play();
        }


    }


}
