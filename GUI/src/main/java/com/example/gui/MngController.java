package com.example.gui;

import BankManagement.BankAccount;
import com.example.gui.adding.addAdminController;
import com.example.gui.adding.addCustController;
import customer.BankCustomer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
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

import java.io.IOException;
import java.util.Objects;

public class MngController {

    private static String id;
    public MenuButton addMenu,deleteMenu,editMenu;
    public Button backReq;
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
    private Button Manage, accStat, addBtn, deleteBtn, deposit, transfer, transaction_Button, withdraw;
    @FXML
    public Button  editBtn = new Button();
    @FXML
    public MenuItem item2,item3,item4;

    @FXML
    public MenuItem addUser;

    @FXML
    public Label adminName;

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

    public Scene scene2,scene;

    private addCustController cont;
    private MngController parentCont;
    public static int isManager=0;



    public void initialize() throws IOException {
        System.out.println("initial in mngCont");

    }

//    @FXML
//    void addAdmin(ActionEvent event) throws IOException {
//        addPane("addCust_Admin.fxml");
//    }

    @FXML
    void addUser(ActionEvent event) throws IOException {
        addPane("addCust.fxml");
        //setStackPane("addCust.fxml");
    }


    /*static void addAccount(ActionEvent event) throws IOException{
            setStackPane("addAcc.fxml");
        }*/

//    @FXML
//    void deleteAdmin(ActionEvent event) throws IOException {
//        addPane("adminDELETE.fxml");
//    }

    @FXML
    void deleteUser(ActionEvent event) throws IOException {
        addPane("userDELETE.fxml");
    }

//    @FXML
//    void editAdmin(ActionEvent event) throws IOException {
//        FXMLLoader fxml = new FXMLLoader(getClass().getResource("editRequestAdmin.fxml"));
//        root2 = fxml.load();
//        stage2 = new Stage();
//        stage2.hide();
//        scene2 = new Scene(root2);
//        stage2.initModality(Modality.APPLICATION_MODAL);
//        stage2.initStyle(StageStyle.UNDECORATED);
//        stage2.setScene(scene2);
//        stage2.show();
//        editBtn.getScene().getWindow().hide();
//    }

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

        cont = fxml.getController();
        cont.setParent(this);
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
        System.out.println("ID is: " + ID.getText());

           try {
            adminDisplay(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //   adminName.setText("Welcome "+ Objects.requireNonNull(BankCustomer.getAccbyAdminID(id)).getFirstName());
        //   adminName.setVisible(true);
    }

    @FXML
    void onBack(ActionEvent event) {
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
            backReq.getScene().getWindow().hide();
        } catch (Exception e) {
            System.out.println("can't load the page for back");
        }


    }

    public void adminDisplay(String id) throws IOException {
        BankCustomer admin = BankCustomer.getAccbyAdminID(id);
        if (admin == null) {
            System.out.println("Incorrect id");
            return;
        }

        FXMLLoader loader = new FXMLLoader(MngController.class.getResource("ManagerDisplay.fxml"));
        Parent root = loader.load();
        parentCont = loader.getController();
        FXMLLoader fxml = null;
        parentCont.adminName.setText("  Welcome "+ admin.getFirstName());
        if (Objects.equals(admin.getPost(), "Manager")) {
            isManager=1;

            System.out.println("Manager in adminDisplay");
            System.out.println(parentCont.addMenu.getItems().get(0) + " menu");
           // System.out.println(parentCont.addMenu.getItems().get(1) + " menu");

            //MenuItem item1 = new MenuItem("addUser");

            item2 = new MenuItem("             Add Admin            ");
            item2.setOnAction(event -> {
                try {
                    System.out.println(" adminnnn");
                    parentCont.addPane("addCust_Admin.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            item3 = new MenuItem("             Delete Admin            ");
            item3.setOnAction(event ->{
                try {
                    System.out.println(" deleteeeee");

                    parentCont.addPane("adminDELETE.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            item4 = new MenuItem("             Edit Admin            ");
            item4.setOnAction(event ->{
                try {
                    System.out.println(" ediiiiit");
                    FXMLLoader fxml4 = new FXMLLoader(getClass().getResource("editRequestAdmin.fxml"));
                     root2 = fxml4.load();
                    stage2 = new Stage();
                    stage2.hide();
                     scene2= new Scene(root2);
                    stage2.initModality(Modality.APPLICATION_MODAL);
                    stage2.initStyle(StageStyle.UNDECORATED);
                    stage2.setScene(scene2);
                    stage2.show();
                   editBtn.getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


            parentCont.addMenu.getItems().add(item2);
            parentCont.deleteMenu.getItems().add(item3);
            parentCont.editMenu.getItems().add(item4);

            stage2 = new Stage();
            stage2.hide();
            scene2 = new Scene(root);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.setScene(scene2);
            stage2.show();
            
        } else {
            try {
                fxml = new FXMLLoader(getClass().getResource("ManagerDisplay.fxml"));
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
    public MenuItem addMenuItems(String name,String path){
        MenuItem item = new MenuItem(name);
        item.setOnAction(event ->{
            try {
                System.out.println(" adminnnn");
                FXMLLoader loader = new FXMLLoader(MngController.class.getResource("ManagerDisplay.fxml"));
                Parent root = loader.load();
                parentCont = loader.getController();
                parentCont.addPane(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return item;

    }


}
