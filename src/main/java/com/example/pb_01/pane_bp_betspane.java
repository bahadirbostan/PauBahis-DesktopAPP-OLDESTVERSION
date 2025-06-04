package com.example.pb_01;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class pane_bp_betspane implements Initializable {
    @FXML
    private AnchorPane anchorpane_betspane;
    @FXML
    private HBox hbox_kuponpencere_bahis1;
    @FXML
    private HBox hbox_kuponpencere_bahis2;
    @FXML
    private HBox hbox_kuponpencere_bahis3;
    @FXML
    private HBox hbox_kuponpencere_bahis4;
    @FXML
    private HBox hbox_kuponpencere_bahis5;
    @FXML
    private HBox hbox_kuponpencere_bahis6;
    @FXML
    private HBox hbox_kuponpencere_bahis7;
    @FXML
    private HBox hbox_kuponpencere_bahis8;
    @FXML
    private HBox hbox_kuponpencere_bahis9;
    @FXML
    private HBox hbox_kuponpencere_bahis10;
    @FXML
    private Label label_oynanmisBahis1_takim1Kisaltma;
    @FXML
    private Label label_oynanmisBahis1_takim2Kisaltma;
    @FXML
    private Label label_oynanmisBahis2_takim1Kisaltma;
    @FXML
    private Label label_oynanmisBahis2_takim2Kisaltma;
    @FXML
    private Label label_oynanmisBahis3_takim1Kisaltma;
    @FXML
    private Label label_oynanmisBahis3_takim2Kisaltma;
    @FXML
    private Label label_oynanmisBahis4_takim1Kisaltma;
    @FXML
    private Label label_oynanmisBahis4_takim2Kisaltma;
    @FXML
    private Label label_oynanmisBahis5_takim1Kisaltma;
    @FXML
    private Label label_oynanmisBahis5_takim2Kisaltma;
    @FXML
    private Label label_oynanmisBahis6_takim1Kisaltma;
    @FXML
    private Label label_oynanmisBahis6_takim2Kisaltma;
    @FXML
    private Label label_oynanmisBahis7_takim1Kisaltma;
    @FXML
    private Label label_oynanmisBahis7_takim2Kisaltma;
    @FXML
    private Label label_oynanmisBahis8_takim1Kisaltma;
    @FXML
    private Label label_oynanmisBahis8_takim2Kisaltma;
    @FXML
    private Label label_oynanmisBahis9_takim1Kisaltma;
    @FXML
    private Label label_oynanmisBahis9_takim2Kisaltma;
    @FXML
    private Label label_oynanmisBahis10_takim1Kisaltma;
    @FXML
    private Label label_oynanmisBahis10_takim2Kisaltma;

    @FXML
    private Label label_oynanmisBahis1_bahisAdi;
    @FXML
    private Label label_oynanmisBahis1_oran;
    @FXML
    private Label label_oynanmisBahis2_bahisAdi;
    @FXML
    private Label label_oynanmisBahis2_oran;
    @FXML
    private Label label_oynanmisBahis3_bahisAdi;
    @FXML
    private Label label_oynanmisBahis3_oran;
    @FXML
    private Label label_oynanmisBahis4_bahisAdi;
    @FXML
    private Label label_oynanmisBahis4_oran;
    @FXML
    private Label label_oynanmisBahis5_bahisAdi;
    @FXML
    private Label label_oynanmisBahis5_oran;
    @FXML
    private Label label_oynanmisBahis6_bahisAdi;
    @FXML
    private Label label_oynanmisBahis6_oran;
    @FXML
    private Label label_oynanmisBahis7_bahisAdi;
    @FXML
    private Label label_oynanmisBahis7_oran;
    @FXML
    private Label label_oynanmisBahis8_bahisAdi;
    @FXML
    private Label label_oynanmisBahis8_oran;
    @FXML
    private Label label_oynanmisBahis9_bahisAdi;
    @FXML
    private Label label_oynanmisBahis9_oran;
    @FXML
    private Label label_oynanmisBahis10_bahisAdi;
    @FXML
    private Label label_oynanmisBahis10_oran;

    @FXML
    private Label label_oynanmisBahis1_bahisSiraNo;
    @FXML
    private Label label_oynanmisBahis2_bahisSiraNo;
    @FXML
    private Label label_oynanmisBahis3_bahisSiraNo;
    @FXML
    private Label label_oynanmisBahis4_bahisSiraNo;
    @FXML
    private Label label_oynanmisBahis5_bahisSiraNo;
    @FXML
    private Label label_oynanmisBahis6_bahisSiraNo;
    @FXML
    private Label label_oynanmisBahis7_bahisSiraNo;
    @FXML
    private Label label_oynanmisBahis8_bahisSiraNo;
    @FXML
    private Label label_oynanmisBahis9_bahisSiraNo;
    @FXML
    private Label label_oynanmisBahis10_bahisSiraNo;

    @FXML
    private TextField textfield_bahisTutari;
    @FXML
    private Label label_toplamOran;
    @FXML
    private Label label_bahisMaksKazanc;
    @FXML
    private Button button_bahisOnayla;
    @FXML
    private Button button_bahisSifirla;

    private ClickedMatch clickedMatch;
    private static final String BUTTON_STATE_FILE = "src/buttonStates.properties";
    Boolean propertiesDeleter = ButtonStateManager.clearPropertiesFile(BUTTON_STATE_FILE);
    private int bahis_macSiraNo;
    private String bahis_betType, bahis_team1Name, bahis_team2Name;
    User user = DatabaseConnection.getUserDetails(HelloController.getLoggedUserMail());
    private DatabaseConnection db;

    private Label[] bahisAdiLabels;
    private Label[] takim1KisaltmaLabels;
    private Label[] takim2KisaltmaLabels;
    private Label[] oranLabels;

   public pane_bp_betspane(){

   }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        bahisAdiLabels = new Label[]{label_oynanmisBahis1_bahisAdi,label_oynanmisBahis2_bahisAdi,label_oynanmisBahis3_bahisAdi,
                label_oynanmisBahis4_bahisAdi,label_oynanmisBahis5_bahisAdi,label_oynanmisBahis6_bahisAdi,label_oynanmisBahis7_bahisAdi,
                label_oynanmisBahis8_bahisAdi,label_oynanmisBahis9_bahisAdi,label_oynanmisBahis10_bahisAdi};

        takim1KisaltmaLabels = new Label[]{label_oynanmisBahis1_takim1Kisaltma,label_oynanmisBahis2_takim1Kisaltma,label_oynanmisBahis3_takim1Kisaltma,
                label_oynanmisBahis4_takim1Kisaltma,label_oynanmisBahis5_takim1Kisaltma,label_oynanmisBahis6_takim1Kisaltma,
                label_oynanmisBahis7_takim1Kisaltma,label_oynanmisBahis8_takim1Kisaltma,label_oynanmisBahis9_takim1Kisaltma,label_oynanmisBahis10_takim1Kisaltma};

        takim2KisaltmaLabels = new Label[]{label_oynanmisBahis1_takim2Kisaltma,label_oynanmisBahis2_takim2Kisaltma,label_oynanmisBahis3_takim2Kisaltma,
                label_oynanmisBahis4_takim2Kisaltma,label_oynanmisBahis5_takim2Kisaltma,label_oynanmisBahis6_takim2Kisaltma,
                label_oynanmisBahis7_takim2Kisaltma,label_oynanmisBahis8_takim2Kisaltma,label_oynanmisBahis9_takim2Kisaltma,label_oynanmisBahis10_takim2Kisaltma};


        oranLabels = new Label[]{label_oynanmisBahis1_oran,label_oynanmisBahis2_oran,label_oynanmisBahis3_oran,
                label_oynanmisBahis4_oran,label_oynanmisBahis5_oran,label_oynanmisBahis6_oran,
                label_oynanmisBahis7_oran,label_oynanmisBahis8_oran,label_oynanmisBahis9_oran,label_oynanmisBahis10_oran};

        if (DatabaseConnection.isKullaniciKuponuExists(user.getId())) {
            loadMatchDetails(user.getId());
        }
        button_bahisSifirla.setOnMouseClicked(event-> deleteProperties());
        updateLabelsForUser(user.getId());
    }

    public void setMatchDetailsToLabel(int userID) {
        Platform.runLater(() -> {
            List<Integer> matchIDs = DatabaseConnection.getUserBufferMatchIDs(userID);
            for (int i = 0; i < matchIDs.size() && i < bahisAdiLabels.length; i++) {
                AktifMac match = DatabaseConnection.getMatchInfosFromID(matchIDs.get(i));
                if (match != null) {
                    bahisAdiLabels[i].setText("T"); // Bahis adı bilgisi varsa ekle
                    takim1KisaltmaLabels[i].setText(match.getTakim1Isim());
                    takim2KisaltmaLabels[i].setText(match.getTakim2Isim());
                    oranLabels[i].setText(String.valueOf(match.getOranMs1())); // İlgili oran bilgisini ekle
                }
            }
        });
    }
    public void onaylaButtonClicked(){
        //kullanıcnın parası azalacak vs.
        transferBufferToKuponlar();
    }
    public void transferBufferToKuponlar(){

    }

    private void loadMatchDetails(int userID) {
        Task<List<Integer>> getMatchIDsTask = new Task<>() {
            @Override
            protected List<Integer> call() throws Exception {
                return DatabaseConnection.getUserBufferMatchIDs(userID);
            }
        };

        getMatchIDsTask.setOnSucceeded(event -> {
            List<Integer> matchIDs = getMatchIDsTask.getValue();
            if (matchIDs.isEmpty()) return;

            Task<List<AktifMac>> getMatchesTask = new Task<>() {
                @Override
                protected List<AktifMac> call() throws Exception {
                    List<AktifMac> matches = new ArrayList<>();
                    for (Integer matchID : matchIDs) {
                        AktifMac matchInfo = DatabaseConnection.getMatchInfosFromID(matchID);
                        if (matchInfo != null) {
                            matches.add(matchInfo);
                        }
                    }
                    return matches;
                }
            };

            getMatchesTask.setOnSucceeded(e -> {
                List<AktifMac> matches = getMatchesTask.getValue();
                Platform.runLater(() -> {
                    for (int i = 0; i < matches.size() && i < bahisAdiLabels.length; i++) {
                        AktifMac match = matches.get(i);
                        bahisAdiLabels[i].setText("BA"); // Bahis adı bilgisi varsa ekle
                        takim1KisaltmaLabels[i].setText(match.getTakim1Isim());
                        takim2KisaltmaLabels[i].setText(match.getTakim2Isim());
                        oranLabels[i].setText("T"); // İlgili oran bilgisini ekle
                    }
                });
            });

            new Thread(getMatchesTask).start();
        });

        new Thread(getMatchIDsTask).start();
    }
    public void deleteProperties(){
       if (propertiesDeleter){
           System.out.println("properties silindi");
           DatabaseConnection.deleteBufferKuponlar(user.getId());
           return;
       }else {
           System.err.println("PROPERTIES DOSYASI SILINIRKEN HATA OLUŞTU");
           return;
       }
    }
    public void updateLabelsForUser(int userID) {

        Platform.runLater(() -> {
            List<Integer> matchIDs = DatabaseConnection.getUserBufferMatchIDs(userID);
            for (int i = 0; i < matchIDs.size() && i < bahisAdiLabels.length; i++) {
                AktifMac match = DatabaseConnection.getMatchInfosFromID(matchIDs.get(i));
                if (match != null) {
                    bahisAdiLabels[i].setText("msX"); // Gerçek bahis adı // DEGİSTİRİLECEK
                    takim1KisaltmaLabels[i].setText(match.getTakim1Isim());
                    takim2KisaltmaLabels[i].setText(match.getTakim2Isim());
                    oranLabels[i].setText("0.2"); // Oran bilgisi // DEGISTIRILECEK
                } else {

                    bahisAdiLabels[i].setText("");
                    takim1KisaltmaLabels[i].setText("");
                    takim2KisaltmaLabels[i].setText("");
                    oranLabels[i].setText("");
                }
            }
        });
    }
}





