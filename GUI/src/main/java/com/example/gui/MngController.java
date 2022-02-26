package com.example.gui;

import com.example.gui.adding.addCustController;
import customer.BankCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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
    public StackPane contentArea;

    @FXML
    public BorderPane borderP = new BorderPane();

    @FXML
    public Button back;

    @FXML
    private Button Manage, accStat, addBtn, deleteBtn, deposit, editBtn, transfer, transaction_Button, withdraw;
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

    public Stage stage2, stage;
    public Parent root2, root;

    public Scene scene2;

    private addCustController cont;

    public void initialize() throws IOException {
        System.out.println("initial in mngCont");

    }

    @FXML
    void addAdmin(ActionEvent event) throws IOException {
        addPane("addCust_Admin.fxml");
    }

    @FXML
    void addUser(ActionEvent event) throws IOException {
        addPane("addCust.fxml");
        //setStackPane("addCust.fxml");
    }


    /*static void addAccount(ActionEvent event) throws IOException{
            setStackPane("addAcc.fxml");
        }*/

    @FXML
    void deleteAdmin(ActionEvent event) throws IOException {
        addPane("adminDELETE.fxml");
    }

    @FXML
    void deleteUser(ActionEvent event) throws IOException {
        addPane("userDELETE.fxml");
    }

    @FXML
    void editAdmin(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("editRequestAdmin.fxml"));
        root2 = fxml.load();
        stage2 = new Stage();
        stage2.hide();
        scene2 = new Scene(root2);
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setScene(scene2);
        stage2.show();
        editBtn.getScene().getWindow().hide();
    }

    @FXML
    void editUser(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("editRequestUSER.fxml"));
        root2 = fxml.load();
        stage2 = new Stage();
        stage2.hide();
        scene2 = new Scene(root2);
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setScene(scene2);
        stage2.show();
        editBtn.getScene().getWindow().hide();
    }

    @FXML
    void editAcc(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("editRequest.fxml"));
        root2 = fxml.load();
        stage2 = new Stage();
        stage2.hide();
        scene2 = new Scene(root2);
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setScene(scene2);
        stage2.show();
        editBtn.getScene().getWindow().hide();
    }

    @FXML
    void exit(MouseEvent event) {
        try {// this code to switch to another frame.
            show("exit.fxml");
        } catch (Exception e) {
            System.out.print("this scene can't load");
        }
    }


    public void addPane(String fileName) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource(fileName));
        Parent root2 = fxml.load();

        StackPane sp = new StackPane();

        sp.getChildren().add(root2);

        borderP.setCenter(sp);
        System.out.println(borderP.getCenter().getId());
    }

    public void addPane2() throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("addCust.fxml"));
        Parent root2 = fxml.load();
        StackPane sp = new StackPane();
        System.out.println(this.borderP.getCenter().getId());
        Button b = new Button("Hello");
        sp.getChildren().add(b);

        borderP.setCenter(sp);

        System.out.println(borderP.getCenter().getId());
    }


    public void show(String loadFile) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource(loadFile));
        root2 = fxml.load();
        stage2 = new Stage();
        scene2 = new Scene(root2);
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setScene(scene2);
        stage2.show();

       /* cont = fxml.getController();
        cont.setParent(this);*/
    }


    @FXML
    void back(ActionEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("adminCheck.fxml"));
            root2 = fxml.load();
            stage2 = new Stage();
            stage2.hide();
            scene2 = new Scene(root2);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.setScene(scene2);
            stage2.show();
            back.getScene().getWindow().hide();
        } catch (Exception e) {
            System.out.println("can't load the page for back");
        }

    }

    @FXML
    void okBtn(ActionEvent event) {
        id = ID.getText();
        adminDisplay(id);
        //   adminName.setText("Welcome "+ Objects.requireNonNull(BankCustomer.getAccbyAdminID(id)).getFirstName());
        //   adminName.setVisible(true);
    }

    public void adminDisplay(String id) {
        BankCustomer admin = BankCustomer.getAccbyAdminID(id);
        if (admin == null) {
            System.out.println("Incorrect id");
            return;
        }
        FXMLLoader fxml = null;
        if (Objects.equals(admin.getPost(), "Manager")) {
            try {
                fxml = new FXMLLoader(getClass().getResource("ManagerDisplay.fxml"));
                root2 = fxml.load();

            } catch (Exception e) {
                System.out.println("can't load the page manager");
            }
        } else {
            try {
                fxml = new FXMLLoader(getClass().getResource("AdminDisplay.fxml"));
                root2 = fxml.load();
                //adminName.setText("Welcome "+ Objects.requireNonNull(BankCustomer.getAccbyAdminID(id)).getFirstName());

            } catch (Exception e) {
                System.out.println("can't load the page admin");
            }
        }
        if (fxml != null) {
            stage2 = new Stage();
            stage2.hide();
            scene2 = new Scene(root2);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.setScene(scene2);
            stage2.show();
            okBtn.getScene().getWindow().hide();
        }

    }


    @FXML
    void Mng(ActionEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("adminIDRequest.fxml"));
            root2 = fxml.load();
            stage2 = new Stage();
            stage2.hide();
            scene2 = new Scene(root2);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.setScene(scene2);
            stage2.show();
            Mng.getScene().getWindow().hide();
        } catch (Exception e) {
            System.out.println("can't load the page");
        }
    }

    @FXML
    void Trans(ActionEvent event) {
        try {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("custAccDisplay.fxml"));
            root2 = fxml.load();
            stage2 = new Stage();
            stage2.hide();
            scene2 = new Scene(root2);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.setScene(scene2);
            stage2.show();
            Trans.getScene().getWindow().hide();
        } catch (Exception e) {
            System.out.println("can't load the page");
        }

    }

    public StackPane getContentArea() {
        return contentArea;
    }

    public void setStackPane(String file) throws IOException {
        FXMLLoader fxml1 = new FXMLLoader(getClass().getResource(file));
        Parent root1 = fxml1.load();
        System.out.println(root1.getChildrenUnmodifiable().size());
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root1);

    }


}
