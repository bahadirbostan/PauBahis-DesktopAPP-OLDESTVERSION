package com.example.pb_01;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.io.PipedReader;
import java.sql.DatabaseMetaData;


public class mainMenuController {
    @FXML
    private AnchorPane anchorpane_rightpane;
    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane anchorpane_centerPane;
    @FXML
    private BorderPane borderpane_anamenu_mainPane;
    @FXML
    private Button button_close;
    @FXML
    private AnchorPane anchorpane_main;
    @FXML
    private HBox hbox_anamenu_canliDestek;
    @FXML
    private HBox hbox_anamenu_anamenubuton;
    @FXML
    private VBox vbox_anamenu_bahisler;
    @FXML
    private ScrollPane scrollpane_anamenu_bahisler;
    @FXML
    private Label label_anamenu_isim;
    @FXML
    private Label label_anamenu_bakiye;
    @FXML
    private Label label_anamenu_id;
    @FXML
    private Label label_anamenu_adminpanel;
    @FXML
    private HBox hbox_anamenu_adminpanel;
    @FXML
    private HBox hbox_anamenu_bildirimler;
    @FXML
    private ImageView imageView_anamenu_bakiyeYenile;


    FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
    com.example.pb_01.HelloController loginController = loader.getController();

    FXMLLoader maclarLoader = new FXMLLoader(getClass().getResource("/com/example/pb_01/pane_AnaMenu.fxml"));
    com.example.pb_01.PaneControllers.pane_maclar pane_maclar = loader.getController();

    private User user;


    @FXML
    protected void onCloseButtonClikced(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    protected void onMinimizeButtonClick(ActionEvent event) {
        Stage stage = (Stage) borderpane_anamenu_mainPane.getScene().getWindow();

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(300), borderpane_anamenu_mainPane);
        fadeTransition.setToValue(0.0);
        fadeTransition.setOnFinished(e -> {
            stage.setIconified(true);
            stage.iconifiedProperty().addListener((ov, t, t1) -> {
                if (!stage.isIconified()) {
                    borderpane_anamenu_mainPane.setOpacity(1.0);
                }
            });
        });
        fadeTransition.play();
    }

    public void handleGoBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }

    private void fadeAnim(Node object) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.1), object);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }


    @FXML
    private void initialize() {

        String u_email = HelloController.getLoggedUserMail();
        try {
            user = DatabaseConnection.getUserDetails(u_email);
            Client.setLoggedInUser(user);
            setMainMenuCredentials();

            hbox_anamenu_adminpanel.setOnMouseClicked(event -> load_AdminPanel());
            hbox_anamenu_anamenubuton.setOnMouseClicked(event -> {
                loadpane_Anamenu();
                load_betsPane();
            });
            hbox_anamenu_canliDestek.setOnMouseClicked(event -> loadpane_LiveSupport());
            hbox_anamenu_bildirimler.setOnMouseClicked(event -> loadpane_Notifications());
            if (user.isAdmin()) {
                //EGER KULLANICI ADMİNSE ADMİN PANEL BURADA AÇILACAK.
            }
            imageView_anamenu_bakiyeYenile.setOnMouseClicked(event -> {
                updateUserBalance();
                fadeAnim(imageView_anamenu_bakiyeYenile);
            });

            if (user.isAdmin()) {
                hbox_anamenu_adminpanel.setVisible(true);
                label_anamenu_adminpanel.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (user.isAdmin()) {
            hbox_anamenu_adminpanel.setVisible(true);
            label_anamenu_adminpanel.setVisible(true);

        }

    }
    private void load_betsPane() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pb_01/pane_betspane.fxml"));
            AnchorPane betspane = loader.load();
            // Sağ pane olarak belirlenen bölgeyi güncelle
            borderpane_anamenu_mainPane.setRight(betspane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadpane_Anamenu() { //anamenu = maclar menüsü amk (Anamenü değil maçlarım pencersii yükler)
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pb_01/pane_AnaMenu.fxml"));
            AnchorPane anamenu = loader.load();
            anchorpane_centerPane.getChildren().setAll(anamenu);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void loadpane_LiveSupport() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pane_CanliDestek.fxml"));
            AnchorPane canliDestek = loader.load();
            anchorpane_centerPane.getChildren().setAll(canliDestek);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    private void loadpane_Notifications() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pane_bildirimler.fxml"));
            AnchorPane bildirimler = loader.load();
            anchorpane_centerPane.getChildren().setAll(bildirimler);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setMainMenuCredentials() {
        label_anamenu_isim.setText(user.getName().toUpperCase());
        label_anamenu_id.setText(String.valueOf(user.getId()));
        label_anamenu_bakiye.setText(String.valueOf(user.getBalance()));
    }

    public void updateUserBalance() {
        try {
            User updatedUser = DatabaseConnection.getUserDetails(user.getEmail());
            if (updatedUser != null) {
                user.setBalance(updatedUser.getBalance());
                Platform.runLater(() -> label_anamenu_bakiye.setText(String.valueOf(user.getBalance())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void load_AdminPanel() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminPanel.fxml"));
            AnchorPane adminPanel = loader.load();
            root.getChildren().setAll(adminPanel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

