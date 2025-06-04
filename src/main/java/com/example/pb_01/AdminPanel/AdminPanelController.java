package com.example.pb_01.AdminPanel;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class AdminPanelController {
    @FXML
    private BorderPane borderpane_adminpanel_mainPane;
    @FXML
    private AnchorPane root_adminpanel;
    @FXML
    private HBox hbox_adminpanel_bahisDuzenle;
    @FXML
    private AnchorPane anchorpane_adminPanel_centerPane;
    @FXML
    private HBox hbox_adminpanel_kullaniciAra;
    @FXML
    private HBox hbox_adminpanel_bakiyeIslemleri;
    @FXML
    private HBox hbox_adminpanel_yasakla;
    @FXML
    private HBox hbox_adminpanel_bildirimGonder;
    @FXML
    private HBox hbox_adminpanel_mesajGonder;
    @FXML
    private HBox hbox_adminpanel_canliDestek;
    @FXML
    private HBox hbox_adminpanel_maliye;
    @FXML
    private Button button_adminpanel_close;
    @FXML
    private Button button_adminpanel_minimize;
    @FXML
    private HBox hbox_adminpanel_cikis;

    @FXML
    private void initialize(){
        try {
            hbox_adminpanel_bahisDuzenle.setOnMouseClicked(event -> loadpane_bahisDuzenle());
            hbox_adminpanel_cikis.setOnMouseClicked(event -> load_MainMenu());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    protected void onMinimizeButtonClicked(ActionEvent event) {
        Stage stage = (Stage) borderpane_adminpanel_mainPane.getScene().getWindow();

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(300), borderpane_adminpanel_mainPane);
        fadeTransition.setToValue(0.0);
        fadeTransition.setOnFinished(e -> {
            stage.setIconified(true);
            stage.iconifiedProperty().addListener((ov, t, t1) -> {
                if (!stage.isIconified()) {
                    borderpane_adminpanel_mainPane.setOpacity(1.0);
                }
            });
        });
        fadeTransition.play();
    }

    @FXML
    protected void onCloseButtonClicked(ActionEvent event){
        Platform.exit();
    }


    private void loadpane_bahisDuzenle(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pb_01/pane_adminpanel_bahisDuzenle.fxml"));
            AnchorPane pane_bahisDuzenle = loader.load();
            anchorpane_adminPanel_centerPane.getChildren().setAll(pane_bahisDuzenle);

        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
    private void load_MainMenu(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pb_01/usersMainMenu.fxml"));
            AnchorPane mainMenu = loader.load();
            root_adminpanel.getChildren().setAll(mainMenu);
        }catch (IOException exception){
            exception.printStackTrace();;
        }
    }

}
