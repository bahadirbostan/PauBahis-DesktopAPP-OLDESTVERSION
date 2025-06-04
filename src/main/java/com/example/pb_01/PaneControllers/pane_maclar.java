package com.example.pb_01.PaneControllers;

import com.example.pb_01.*;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class pane_maclar {
    public AnchorPane anchorpane_centerpane_anamenu; // MAÇLAR PENCERESİNİ KONTROL EDİYOR. FXML DOSYASI OLARAK ADI pane_AnaMenu'dür.

    @FXML
    private Label macSira1_label_15ust; //oran
    @FXML
    private Label macSira1_label_15alt; //oran
    @FXML
    private Label macSira1_label_25ust; //oran
    @FXML
    private Label macSira1_label_ms1; //oran
    @FXML
    private Label macSira1_label_msX; //oran
    @FXML
    private Label macSira1_label_ms2; //oran
    @FXML
    private Label macSira2_label_15ust;
    @FXML
    private Label macSira2_label_15alt;
    @FXML
    private Label macSira2_label_25ust;
    @FXML
    private Label macSira2_label_ms1;
    @FXML
    private Label macSira2_label_msX;
    @FXML
    private Label macSira2_label_ms2;
    @FXML
    private Label macSira3_label_15ust;
    @FXML
    private Label macSira3_label_15alt;
    @FXML
    private Label macSira3_label_25ust;
    @FXML
    private Label macSira3_label_ms1;
    @FXML
    private Label macSira3_label_msX;
    @FXML
    private Label macSira3_label_ms2;
    @FXML
    private Label macSira4_label_15ust;
    @FXML
    private Label macSira4_label_15alt;
    @FXML
    private Label macSira4_label_25ust;
    @FXML
    private Label macSira4_label_ms1;
    @FXML
    private Label macSira4_label_msX;
    @FXML
    private Label macSira4_label_ms2;
    @FXML
    private Label macSira5_label_15ust;
    @FXML
    private Label macSira5_label_15alt;
    @FXML
    private Label macSira5_label_25ust;
    @FXML
    private Label macSira5_label_ms1;
    @FXML
    private Label macSira5_label_msX;
    @FXML
    private Label macSira5_label_ms2;
    @FXML
    private Label macSira6_label_15ust;
    @FXML
    private Label macSira6_label_15alt;
    @FXML
    private Label macSira6_label_25ust;
    @FXML
    private Label macSira6_label_ms1;
    @FXML
    private Label macSira6_label_msX;
    @FXML
    private Label macSira6_label_ms2;
    @FXML
    private Label macSira7_label_15ust;
    @FXML
    private Label macSira7_label_15alt;
    @FXML
    private Label macSira7_label_25ust;
    @FXML
    private Label macSira7_label_ms1;
    @FXML
    private Label macSira7_label_msX;
    @FXML
    private Label macSira7_label_ms2;
    @FXML
    private Label macSira8_label_15ust;
    @FXML
    private Label macSira8_label_15alt;
    @FXML
    private Label macSira8_label_25ust;
    @FXML
    private Label macSira8_label_ms1;
    @FXML
    private Label macSira8_label_msX;
    @FXML
    private Label macSira8_label_ms2;
    @FXML
    private Label macSira9_label_15ust;
    @FXML
    private Label macSira9_label_15alt;
    @FXML
    private Label macSira9_label_25ust;
    @FXML
    private Label macSira9_label_ms1;
    @FXML
    private Label macSira9_label_msX;
    @FXML
    private Label macSira9_label_ms2;
    @FXML
    private Label macSira10_label_15ust;
    @FXML
    private Label macSira10_label_15alt;
    @FXML
    private Label macSira10_label_25ust;
    @FXML
    private Label macSira10_label_ms1;
    @FXML
    private Label macSira10_label_msX;
    @FXML
    private Label macSira10_label_ms2;
    @FXML
    private Label macSira1_label_takimAd1;
    @FXML
    private Label macSira1_label_takimAd2;
    @FXML
    private Label macSira2_label_takimAd1;
    @FXML
    private Label macSira2_label_takimAd2;
    @FXML
    private Label macSira3_label_takimAd1;
    @FXML
    private Label macSira3_label_takimAd2;
    @FXML
    private Label macSira4_label_takimAd1;
    @FXML
    private Label macSira4_label_takimAd2;
    @FXML
    private Label macSira5_label_takimAd1;
    @FXML
    private Label macSira5_label_takimAd2;
    @FXML
    private Label macSira6_label_takimAd1;
    @FXML
    private Label macSira6_label_takimAd2;
    @FXML
    private Label macSira7_label_takimAd1;
    @FXML
    private Label macSira7_label_takimAd2;
    @FXML
    private Label macSira8_label_takimAd1;
    @FXML
    private Label macSira8_label_takimAd2;
    @FXML
    private Label macSira9_label_takimAd1;
    @FXML
    private Label macSira9_label_takimAd2;
    @FXML
    private Label macSira10_label_takimAd1;
    @FXML
    private Label macSira10_label_takimAd2;

    //mac sırasına göre bahislerin butonları :

    @FXML
    private Button macSira1_button_15ust;
    @FXML
    private Button macSira1_button_25ust;
    @FXML
    private Button macSira1_button_15alt;
    @FXML
    private Button macSira1_button_ms1;
    @FXML
    private Button macSira1_button_msX;
    @FXML
    private Button macSira1_button_ms2;

    @FXML
    private Button macSira2_button_15ust;
    @FXML
    private Button macSira2_button_25ust;
    @FXML
    private Button macSira2_button_15alt;
    @FXML
    private Button macSira2_button_ms1;
    @FXML
    private Button macSira2_button_msX;
    @FXML
    private Button macSira2_button_ms2;

    @FXML
    private Button macSira3_button_15ust;
    @FXML
    private Button macSira3_button_25ust;
    @FXML
    private Button macSira3_button_15alt;
    @FXML
    private Button macSira3_button_ms1;
    @FXML
    private Button macSira3_button_msX;
    @FXML
    private Button macSira3_button_ms2;

    @FXML
    private Button macSira4_button_15ust;
    @FXML
    private Button macSira4_button_25ust;
    @FXML
    private Button macSira4_button_15alt;
    @FXML
    private Button macSira4_button_ms1;
    @FXML
    private Button macSira4_button_msX;
    @FXML
    private Button macSira4_button_ms2;

    @FXML
    private Button macSira5_button_15ust;
    @FXML
    private Button macSira5_button_25ust;
    @FXML
    private Button macSira5_button_15alt;
    @FXML
    private Button macSira5_button_ms1;
    @FXML
    private Button macSira5_button_msX;
    @FXML
    private Button macSira5_button_ms2;

    @FXML
    private Button macSira6_button_15ust;
    @FXML
    private Button macSira6_button_25ust;
    @FXML
    private Button macSira6_button_15alt;
    @FXML
    private Button macSira6_button_ms1;
    @FXML
    private Button macSira6_button_msX;
    @FXML
    private Button macSira6_button_ms2;

    @FXML
    private Button macSira7_button_15ust;
    @FXML
    private Button macSira7_button_25ust;
    @FXML
    private Button macSira7_button_15alt;
    @FXML
    private Button macSira7_button_ms1;
    @FXML
    private Button macSira7_button_msX;
    @FXML
    private Button macSira7_button_ms2;

    @FXML
    private Button macSira8_button_15ust;
    @FXML
    private Button macSira8_button_25ust;
    @FXML
    private Button macSira8_button_15alt;
    @FXML
    private Button macSira8_button_ms1;
    @FXML
    private Button macSira8_button_msX;
    @FXML
    private Button macSira8_button_ms2;


    @FXML
    private Button macSira9_button_15ust;
    @FXML
    private Button macSira9_button_25ust;
    @FXML
    private Button macSira9_button_15alt;
    @FXML
    private Button macSira9_button_ms1;
    @FXML
    private Button macSira9_button_msX;
    @FXML
    private Button macSira9_button_ms2;

    @FXML
    private Button macSira10_button_15ust;
    @FXML
    private Button macSira10_button_25ust;
    @FXML
    private Button macSira10_button_15alt;
    @FXML
    private Button macSira10_button_ms1;
    @FXML
    private Button macSira10_button_msX;
    @FXML
    private Button macSira10_button_ms2;
    private pane_bp_betspane betspane;
    private final String ust15 = "oran_15ust", alt15 = "oran_15alt", ust25 = "oran_25ust", ms1 = "oran_ms1", ms2 = "oran_ms2", msX = "oran_msX";
    private Map<String, Boolean> buttonStates;
    User user = DatabaseConnection.getUserDetails(HelloController.getLoggedUserMail());
    private final String PROPERTIES_PATH = "src/buttonStates.properties";

    public void initialize() {
        initializeButtonActions();
        loadButtonStates();
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pb_01/pane_betspane.fxml"));
            AnchorPane anchorpane_betspane = loader.load();
            betspane = loader.getController();

            buttonStates = ButtonStateManager.loadButtonStates();
            updateButtonStates();

            initializeButtonActions();


            Runtime.getRuntime().addShutdownHook(new Thread(() -> ButtonStateManager.saveButtonStates(buttonStates)));


            maclariEkranaGetir();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void fetchMatchData(int siraNo) {
        Task<AktifMac> task = DatabaseConnection.getAktifMacBilgileriTask(siraNo);
        task.setOnSucceeded(e -> {
            AktifMac aktifMac = task.getValue();
            updateMatchDatas(siraNo, aktifMac);

        });
        task.setOnFailed(e -> {
            e.getSource().getException().printStackTrace();
        });
        new Thread(task).start();
    }

    private void updateMatchDatas(int siraNo, AktifMac aktifMac) {
        // Eğer aktifMac null değilse, etiketlere bilgileri yerleştir
        if (aktifMac != null) {
            switch (siraNo) {
                case 1:
                    updateLabels(macSira1_label_15ust, macSira1_label_15alt, macSira1_label_25ust,
                            macSira1_label_ms1, macSira1_label_msX, macSira1_label_ms2,
                            macSira1_label_takimAd1, macSira1_label_takimAd2, aktifMac);
                    break;
                case 2:
                    updateLabels(macSira2_label_15ust, macSira2_label_15alt, macSira2_label_25ust,
                            macSira2_label_ms1, macSira2_label_msX, macSira2_label_ms2,
                            macSira2_label_takimAd1, macSira2_label_takimAd2, aktifMac);
                    break;
                case 3:
                    updateLabels(macSira3_label_15ust, macSira3_label_15alt, macSira3_label_25ust,
                            macSira3_label_ms1, macSira3_label_msX, macSira3_label_ms2,
                            macSira3_label_takimAd1, macSira3_label_takimAd2, aktifMac);
                    break;
                case 4:
                    updateLabels(macSira4_label_15ust, macSira4_label_15alt, macSira4_label_25ust,
                            macSira4_label_ms1, macSira4_label_msX, macSira4_label_ms2,
                            macSira4_label_takimAd1, macSira4_label_takimAd2, aktifMac);
                    break;
                case 5:
                    updateLabels(macSira5_label_15ust, macSira5_label_15alt, macSira5_label_25ust,
                            macSira5_label_ms1, macSira5_label_msX, macSira5_label_ms2,
                            macSira5_label_takimAd1, macSira5_label_takimAd2, aktifMac);
                    break;
                case 6:
                    updateLabels(macSira6_label_15ust, macSira6_label_15alt, macSira6_label_25ust,
                            macSira6_label_ms1, macSira6_label_msX, macSira6_label_ms2,
                            macSira6_label_takimAd1, macSira6_label_takimAd2, aktifMac);
                    break;
                case 7:
                    updateLabels(macSira7_label_15ust, macSira7_label_15alt, macSira7_label_25ust,
                            macSira7_label_ms1, macSira7_label_msX, macSira7_label_ms2,
                            macSira7_label_takimAd1, macSira7_label_takimAd2, aktifMac);
                    break;
                case 8:
                    updateLabels(macSira8_label_15ust, macSira8_label_15alt, macSira8_label_25ust,
                            macSira8_label_ms1, macSira8_label_msX, macSira8_label_ms2,
                            macSira8_label_takimAd1, macSira8_label_takimAd2, aktifMac);
                    break;
                case 9:
                    updateLabels(macSira9_label_15ust, macSira9_label_15alt, macSira9_label_25ust,
                            macSira9_label_ms1, macSira9_label_msX, macSira9_label_ms2,
                            macSira9_label_takimAd1, macSira9_label_takimAd2, aktifMac);
                    break;
                case 10:
                    updateLabels(macSira10_label_15ust, macSira10_label_15alt, macSira10_label_25ust,
                            macSira10_label_ms1, macSira10_label_msX, macSira10_label_ms2,
                            macSira10_label_takimAd1, macSira10_label_takimAd2, aktifMac);
                    break;
                default:

                    break;
            }
        }
    }

    private void updateLabels(Label label15ust, Label label15alt, Label label25ust,
                              Label labelMs1, Label labelMsX, Label labelMs2,
                              Label labelTakimAd1, Label labelTakimAd2, AktifMac aktifMac) {
        label15ust.setText(String.valueOf(aktifMac.getOran15ust()));
        label15alt.setText(String.valueOf(aktifMac.getOran15alt()));
        label25ust.setText(String.valueOf(aktifMac.getOran25ust()));
        labelMs1.setText(String.valueOf(aktifMac.getOranMs1()));
        labelMsX.setText(String.valueOf(aktifMac.getOranMsX()));
        labelMs2.setText(String.valueOf(aktifMac.getOranMs2()));
        labelTakimAd1.setText(aktifMac.getTakim1Isim());
        labelTakimAd2.setText(aktifMac.getTakim2Isim());
    }

    public void maclariEkranaGetir() {
        for (int i = 1; i <= 10; i++) {
            fetchMatchData(i);
        }
    }

    public void getClickedMatchDetails(int macSiraNo, String betType) {
        int macID = DatabaseConnection.getMatchID(macSiraNo);
        if (macID != -1) {

            AktifMac aktifMac = DatabaseConnection.getMatchInfosFromID(macID);

            switch (betType) {
                case ust15:
                    System.out.println(aktifMac.getOran15ust());
                    DatabaseConnection.storeMatchInBuffer(user.getId(), macID, aktifMac.getOran15ust());
                    break;
                case alt15:
                    System.out.println(aktifMac.getOran15alt());
                    DatabaseConnection.storeMatchInBuffer(user.getId(), macID, aktifMac.getOran15alt());
                    break;
                case ust25:
                    System.out.println(aktifMac.getOran25ust());
                    DatabaseConnection.storeMatchInBuffer(user.getId(), macID, aktifMac.getOran25ust());
                    break;
                case ms1:
                    System.out.println(aktifMac.getOranMs1());
                    DatabaseConnection.storeMatchInBuffer(user.getId(), macID, aktifMac.getOranMs1());
                    break;
                case ms2:
                    System.out.println(aktifMac.getOranMs2());
                    DatabaseConnection.storeMatchInBuffer(user.getId(), macID, aktifMac.getOranMs2());
                    break;
                case msX:
                    System.out.println(aktifMac.getOranMsX());
                    DatabaseConnection.storeMatchInBuffer(user.getId(), macID, aktifMac.getOranMsX());

                    break;

                default:

                    break;
            }

        } else {
            System.out.println("Maç Bulunamadı");
        }
    }


    private void updateButtonStates() {
        for (Map.Entry<String, Boolean> entry : buttonStates.entrySet()) {
            Button button = getButtonById(entry.getKey());
            if (button != null) {
                button.setDisable(entry.getValue());
            }
        }
    }

    private Button[] getButtonsForMac(int macIndex) {
        switch (macIndex) {
            case 1:
                return new Button[]{macSira1_button_ms1, macSira1_button_15alt, macSira1_button_15ust, macSira1_button_25ust, macSira1_button_ms2, macSira1_button_msX};
            case 2:
                return new Button[]{macSira2_button_ms1, macSira2_button_15alt, macSira2_button_15ust, macSira2_button_25ust, macSira2_button_ms2, macSira2_button_msX};
            case 3:
                return new Button[]{macSira3_button_ms1, macSira3_button_15alt, macSira3_button_15ust, macSira3_button_25ust, macSira3_button_ms2, macSira3_button_msX};
            case 4:
                return new Button[]{macSira4_button_ms1, macSira4_button_15alt, macSira4_button_15ust, macSira4_button_25ust, macSira4_button_ms2, macSira4_button_msX};
            case 5:
                return new Button[]{macSira5_button_ms1, macSira5_button_15alt, macSira5_button_15ust, macSira5_button_25ust, macSira5_button_ms2, macSira5_button_msX};
            case 6:
                return new Button[]{macSira6_button_ms1, macSira6_button_15alt, macSira6_button_15ust, macSira6_button_25ust, macSira6_button_ms2, macSira6_button_msX};
            case 7:
                return new Button[]{macSira7_button_ms1, macSira7_button_15alt, macSira7_button_15ust, macSira7_button_25ust, macSira7_button_ms2, macSira7_button_msX};
            case 8:
                return new Button[]{macSira8_button_ms1, macSira8_button_15alt, macSira8_button_15ust, macSira8_button_25ust, macSira8_button_ms2, macSira8_button_msX};
            case 9:
                return new Button[]{macSira9_button_ms1, macSira9_button_15alt, macSira9_button_15ust, macSira9_button_25ust, macSira9_button_ms2, macSira9_button_msX};
            case 10:
                return new Button[]{macSira10_button_ms1, macSira10_button_15alt, macSira10_button_15ust, macSira10_button_25ust, macSira10_button_ms2, macSira10_button_msX};
            default:
                return new Button[]{};
        }
    }

    private void disableButtonsForMac(int macIndex) {
        Button[] buttons = getButtonsForMac(macIndex);
        for (Button button : buttons) {
            button.setDisable(true);
            buttonStates.put(button.getId(), true);
        }
    }

    private Button getButtonById(String buttonId) {
        switch (buttonId) {
            case "macSira1_button_15alt":
                return macSira1_button_15alt;
            case "macSira1_button_15ust":
                return macSira1_button_15ust;
            case "macSira1_button_25ust":
                return macSira1_button_25ust;
            case "macSira1_button_ms2":
                return macSira1_button_ms2;
            case "macSira1_button_msX":
                return macSira1_button_msX;
            case "macSira2_button_15alt":
                return macSira2_button_15alt;
            case "macSira2_button_15ust":
                return macSira2_button_15ust;
            case "macSira2_button_25ust":
                return macSira2_button_25ust;
            case "macSira2_button_ms2":
                return macSira2_button_ms2;
            case "macSira2_button_msX":
                return macSira2_button_msX;
            case "macSira3_button_15alt":
                return macSira3_button_15alt;
            case "macSira3_button_15ust":
                return macSira3_button_15ust;
            case "macSira3_button_25ust":
                return macSira3_button_25ust;
            case "macSira3_button_ms2":
                return macSira3_button_ms2;
            case "macSira3_button_msX":
                return macSira3_button_msX;
            case "macSira4_button_15alt":
                return macSira4_button_15alt;
            case "macSira4_button_15ust":
                return macSira4_button_15ust;
            case "macSira4_button_25ust":
                return macSira4_button_25ust;
            case "macSira4_button_ms2":
                return macSira4_button_ms2;
            case "macSira4_button_msX":
                return macSira4_button_msX;
            case "macSira5_button_15alt":
                return macSira5_button_15alt;
            case "macSira5_button_15ust":
                return macSira5_button_15ust;
            case "macSira5_button_25ust":
                return macSira5_button_25ust;
            case "macSira5_button_ms2":
                return macSira5_button_ms2;
            case "macSira5_button_msX":
                return macSira5_button_msX;
            case "macSira6_button_15alt":
                return macSira6_button_15alt;
            case "macSira6_button_15ust":
                return macSira6_button_15ust;
            case "macSira6_button_25ust":
                return macSira6_button_25ust;
            case "macSira6_button_ms2":
                return macSira6_button_ms2;
            case "macSira6_button_msX":
                return macSira6_button_msX;
            case "macSira7_button_15alt":
                return macSira7_button_15alt;
            case "macSira7_button_15ust":
                return macSira7_button_15ust;
            case "macSira7_button_25ust":
                return macSira7_button_25ust;
            case "macSira7_button_ms2":
                return macSira7_button_ms2;
            case "macSira7_button_msX":
                return macSira7_button_msX;
            case "macSira8_button_15alt":
                return macSira8_button_15alt;
            case "macSira8_button_15ust":
                return macSira8_button_15ust;
            case "macSira8_button_25ust":
                return macSira8_button_25ust;
            case "macSira8_button_ms2":
                return macSira8_button_ms2;
            case "macSira8_button_msX":
                return macSira8_button_msX;
            case "macSira9_button_15alt":
                return macSira9_button_15alt;
            case "macSira9_button_15ust":
                return macSira9_button_15ust;
            case "macSira9_button_25ust":
                return macSira9_button_25ust;
            case "macSira9_button_ms2":
                return macSira9_button_ms2;
            case "macSira9_button_msX":
                return macSira9_button_msX;
            case "macSira10_button_15alt":
                return macSira10_button_15alt;
            case "macSira10_button_15ust":
                return macSira10_button_15ust;
            case "macSira10_button_25ust":
                return macSira10_button_25ust;
            case "macSira10_button_ms2":
                return macSira10_button_ms2;
            case "macSira10_button_msX":
                return macSira10_button_msX;
            default:
                return null;
        }
    }


    // İlk maç sırası için buton tıklama olayları
    private void initializeButtonActions() {
        // Birinci maç sırası için buton tıklama olayları
        macSira1_button_ms1.setOnAction(event -> {
            getClickedMatchDetails(1, ms1);
            disableButtonsForMac(1);
            betspane.setMatchDetailsToLabel(user.getId());
            betspane.updateLabelsForUser(user.getId());

        });
        macSira1_button_15alt.setOnAction(event -> {
            getClickedMatchDetails(1, alt15);
            disableButtonsForMac(1);
            betspane.setMatchDetailsToLabel(user.getId());
            loadBetspane();
        });
        macSira1_button_15ust.setOnAction(event -> {
            getClickedMatchDetails(1, ust15);
            disableButtonsForMac(1);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira1_button_25ust.setOnAction(event -> {
            getClickedMatchDetails(1, ust25);
            disableButtonsForMac(1);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira1_button_ms2.setOnAction(event -> {
            getClickedMatchDetails(1, ms2);
            disableButtonsForMac(1);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira1_button_msX.setOnAction(event -> {
            getClickedMatchDetails(1, msX);
            disableButtonsForMac(1);
            betspane.setMatchDetailsToLabel(user.getId());
        });

        // İkinci maç sırası için buton tıklama olayları
        macSira2_button_ms1.setOnAction(event -> {
            getClickedMatchDetails(2, ms1);
            disableButtonsForMac(2);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira2_button_15alt.setOnAction(event -> {
            getClickedMatchDetails(2, alt15);
            disableButtonsForMac(2);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira2_button_15ust.setOnAction(event -> {
            getClickedMatchDetails(2, ust15);
            disableButtonsForMac(2);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira2_button_25ust.setOnAction(event -> {
            getClickedMatchDetails(2, ust25);
            disableButtonsForMac(2);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira2_button_ms2.setOnAction(event -> {
            getClickedMatchDetails(2, ms2);
            disableButtonsForMac(2);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira2_button_msX.setOnAction(event -> {
            getClickedMatchDetails(2, msX);
            disableButtonsForMac(2);
            betspane.setMatchDetailsToLabel(user.getId());
        });

        // Üçüncü maç sırası için buton tıklama olayları
        macSira3_button_ms1.setOnAction(event -> {
            getClickedMatchDetails(3, ms1);
            disableButtonsForMac(3);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira3_button_15alt.setOnAction(event -> {
            getClickedMatchDetails(3, alt15);
            disableButtonsForMac(3);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira3_button_15ust.setOnAction(event -> {
            getClickedMatchDetails(3, ust15);
            disableButtonsForMac(3);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira3_button_25ust.setOnAction(event -> {
            getClickedMatchDetails(3, ust25);
            disableButtonsForMac(3);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira3_button_ms2.setOnAction(event -> {
            getClickedMatchDetails(3, ms2);
            disableButtonsForMac(3);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira3_button_msX.setOnAction(event -> {
            getClickedMatchDetails(3, msX);
            disableButtonsForMac(3);
            betspane.setMatchDetailsToLabel(user.getId());
        });

        // Dördüncü maç sırası için buton tıklama olayları
        macSira4_button_ms1.setOnAction(event -> {
            getClickedMatchDetails(4, ms1);
            disableButtonsForMac(4);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira4_button_15alt.setOnAction(event -> {
            getClickedMatchDetails(4, alt15);
            disableButtonsForMac(4);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira4_button_15ust.setOnAction(event -> {
            getClickedMatchDetails(4, ust15);
            disableButtonsForMac(4);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira4_button_25ust.setOnAction(event -> {
            getClickedMatchDetails(4, ust25);
            disableButtonsForMac(4);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira4_button_ms2.setOnAction(event -> {
            getClickedMatchDetails(4, ms2);
            disableButtonsForMac(4);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira4_button_msX.setOnAction(event -> {
            getClickedMatchDetails(4, msX);
            disableButtonsForMac(4);
            betspane.setMatchDetailsToLabel(user.getId());
        });

        // Beşinci maç sırası için buton tıklama olayları
        macSira5_button_ms1.setOnAction(event -> {
            getClickedMatchDetails(5, ms1);
            disableButtonsForMac(5);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira5_button_15alt.setOnAction(event -> {
            getClickedMatchDetails(5, alt15);
            disableButtonsForMac(5);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira5_button_15ust.setOnAction(event -> {
            getClickedMatchDetails(5, ust15);
            disableButtonsForMac(5);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira5_button_25ust.setOnAction(event -> {
            getClickedMatchDetails(5, ust25);
            disableButtonsForMac(5);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira5_button_ms2.setOnAction(event -> {
            getClickedMatchDetails(5, ms2);
            disableButtonsForMac(5);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira5_button_msX.setOnAction(event -> {
            getClickedMatchDetails(5, msX);
            disableButtonsForMac(5);
            betspane.setMatchDetailsToLabel(user.getId());
        });

        // Altıncı maç sırası için buton tıklama olayları
        macSira6_button_ms1.setOnAction(event -> {
            getClickedMatchDetails(6, ms1);
            disableButtonsForMac(6);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira6_button_15alt.setOnAction(event -> {
            getClickedMatchDetails(6, alt15);
            disableButtonsForMac(6);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira6_button_15ust.setOnAction(event -> {
            getClickedMatchDetails(6, ust15);
            disableButtonsForMac(6);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira6_button_25ust.setOnAction(event -> {
            getClickedMatchDetails(6, ust25);
            disableButtonsForMac(6);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira6_button_ms2.setOnAction(event -> {
            getClickedMatchDetails(6, ms2);
            disableButtonsForMac(6);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira6_button_msX.setOnAction(event -> {
            getClickedMatchDetails(6, msX);
            disableButtonsForMac(6);
            betspane.setMatchDetailsToLabel(user.getId());
        });

        // Yedinci maç sırası için buton tıklama olayları
        macSira7_button_ms1.setOnAction(event -> {
            getClickedMatchDetails(7, ms1);
            disableButtonsForMac(7);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira7_button_15alt.setOnAction(event -> {
            getClickedMatchDetails(7, alt15);
            disableButtonsForMac(7);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira7_button_15ust.setOnAction(event -> {
            getClickedMatchDetails(7, ust15);
            disableButtonsForMac(7);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira7_button_25ust.setOnAction(event -> {
            getClickedMatchDetails(7, ust25);
            disableButtonsForMac(7);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira7_button_ms2.setOnAction(event -> {
            getClickedMatchDetails(7, ms2);
            disableButtonsForMac(7);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira7_button_msX.setOnAction(event -> {
            getClickedMatchDetails(7, msX);
            disableButtonsForMac(7);
            betspane.setMatchDetailsToLabel(user.getId());
        });


        macSira8_button_ms1.setOnAction(event -> {
            getClickedMatchDetails(8, ms1);
            disableButtonsForMac(8);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira8_button_15alt.setOnAction(event -> {
            getClickedMatchDetails(8, alt15);
            disableButtonsForMac(8);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira8_button_15ust.setOnAction(event -> {
            getClickedMatchDetails(8, ust15);
            disableButtonsForMac(8);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira8_button_25ust.setOnAction(event -> {
            getClickedMatchDetails(8, ust25);
            disableButtonsForMac(8);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira8_button_ms2.setOnAction(event -> {
            getClickedMatchDetails(8, ms2);
            disableButtonsForMac(8);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira8_button_msX.setOnAction(event -> {
            getClickedMatchDetails(8, msX);
            disableButtonsForMac(8);
            betspane.setMatchDetailsToLabel(user.getId());
        });


        macSira9_button_ms1.setOnAction(event -> {
            getClickedMatchDetails(9, ms1);
            disableButtonsForMac(9);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira9_button_15alt.setOnAction(event -> {
            getClickedMatchDetails(9, alt15);
            disableButtonsForMac(9);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira9_button_15ust.setOnAction(event -> {
            getClickedMatchDetails(9, ust15);
            disableButtonsForMac(9);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira9_button_25ust.setOnAction(event -> {
            getClickedMatchDetails(9, ust25);
            disableButtonsForMac(9);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira9_button_ms2.setOnAction(event -> {
            getClickedMatchDetails(9, ms2);
            disableButtonsForMac(9);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira9_button_msX.setOnAction(event -> {
            getClickedMatchDetails(9, msX);
            disableButtonsForMac(9);
            betspane.setMatchDetailsToLabel(user.getId());
        });

        macSira10_button_ms1.setOnAction(event -> {
            getClickedMatchDetails(10, ms1);
            disableButtonsForMac(10);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira10_button_15alt.setOnAction(event -> {
            getClickedMatchDetails(10, alt15);
            disableButtonsForMac(10);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira10_button_15ust.setOnAction(event -> {
            getClickedMatchDetails(10, ust15);
            disableButtonsForMac(10);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira10_button_25ust.setOnAction(event -> {
            getClickedMatchDetails(10, ust25);
            disableButtonsForMac(10);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira10_button_ms2.setOnAction(event -> {
            getClickedMatchDetails(10, ms2);
            disableButtonsForMac(10);
            betspane.setMatchDetailsToLabel(user.getId());
        });
        macSira10_button_msX.setOnAction(event -> {
            getClickedMatchDetails(10, msX);
            disableButtonsForMac(10);
            betspane.setMatchDetailsToLabel(user.getId());
        });

    }


    private void loadButtonStates() {
        Properties properties = new Properties();
        File file = new File(PROPERTIES_PATH);

        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                properties.load(fis);


                for (int i = 1; i <= 10; i++) {
                    String prefix = "macSira" + i + "_";


                    setButtonDisabled(prefix + "ms1", Boolean.parseBoolean(properties.getProperty(prefix + "ms1", "false")));
                    setButtonDisabled(prefix + "15alt", Boolean.parseBoolean(properties.getProperty(prefix + "15alt", "false")));
                    setButtonDisabled(prefix + "15ust", Boolean.parseBoolean(properties.getProperty(prefix + "15ust", "false")));
                    setButtonDisabled(prefix + "25ust", Boolean.parseBoolean(properties.getProperty(prefix + "25ust", "false")));
                    setButtonDisabled(prefix + "ms2", Boolean.parseBoolean(properties.getProperty(prefix + "ms2", "false")));
                    setButtonDisabled(prefix + "msX", Boolean.parseBoolean(properties.getProperty(prefix + "msX", "false")));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void saveButtonStates() {
        Properties properties = new Properties();

        for (int i = 1; i <= 10; i++) {
            String prefix = "macSira" + i + "_";


            properties.setProperty(prefix + "ms1", String.valueOf(((Button) anchorpane_centerpane_anamenu.lookup("#" + prefix + "ms1")).isDisable()));
            properties.setProperty(prefix + "15alt", String.valueOf(((Button) anchorpane_centerpane_anamenu.lookup("#" + prefix + "15alt")).isDisable()));
            properties.setProperty(prefix + "15ust", String.valueOf(((Button) anchorpane_centerpane_anamenu.lookup("#" + prefix + "15ust")).isDisable()));
            properties.setProperty(prefix + "25ust", String.valueOf(((Button) anchorpane_centerpane_anamenu.lookup("#" + prefix + "25ust")).isDisable()));
            properties.setProperty(prefix + "ms2", String.valueOf(((Button) anchorpane_centerpane_anamenu.lookup("#" + prefix + "ms2")).isDisable()));
            properties.setProperty(prefix + "msX", String.valueOf(((Button) anchorpane_centerpane_anamenu.lookup("#" + prefix + "msX")).isDisable()));
        }

        try (FileOutputStream fos = new FileOutputStream(PROPERTIES_PATH)) {
            properties.store(fos, "Button States");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setButtonDisabled(String buttonId, boolean disabled) {
        Button button = (Button) anchorpane_centerpane_anamenu.lookup("#" + buttonId);
        if (button != null) {
            button.setDisable(disabled);
        }
    }

    public void loadBetspane() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pb_01/pane_betspane.fxml"));
            AnchorPane anchorpane_betspane = loader.load();
            betspane = loader.getController();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

