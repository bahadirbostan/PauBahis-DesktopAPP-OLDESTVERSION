package com.example.pb_01.AdminPanel;

import com.example.pb_01.AktifMac;
import com.example.pb_01.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class pane_adminPanel_bahisDuzenleController {
    @FXML
    private Button button_bahisDuzenle_siraNoOnay;
    @FXML
    private Button button_bahisDuzenle_bahisYenile;
    @FXML
    private Button button_bahisDuzenle_bahisKaydet;

    @FXML
    private TextField textfield_bahisduzenle_siraNo;
    @FXML
    private TextField textfield_bahisduzenle_takimAd1;
    @FXML
    private TextField textfield_bahisduzenle_takimAd2;
    @FXML
    private TextField textfield_bahisduzenle_15ust;
    @FXML
    private TextField textfield_bahisduzenle_25ust;
    @FXML
    private TextField textfield_bahisduzenle_15alt;
    @FXML
    private TextField textfield_bahisduzenle_ms1;
    @FXML
    private TextField textfield_bahisduzenle_msX;
    @FXML
    private TextField textfield_bahisduzenle_ms2;

    @FXML
    private Label label_mevcutbahis_takimAd1;
    @FXML
    private Label label_mevcutbahis_takimAd2;
    @FXML
    private Label label_mevcutbahis_15ust;
    @FXML
    private Label label_mevcutbahis_25ust;
    @FXML
    private Label label_mevcutbahis_15alt;
    @FXML
    private Label label_mevcutbahis_ms1;
    @FXML
    private Label label_mevcutbahis_msX;
    @FXML
    private Label label_mevcutbahis_ms2;
    @FXML
    private Label label_mevcutbahis_siraNo;

    @FXML
    private Label label_guncellenmisbahis_takimAd1;
    @FXML
    private Label label_guncellenmisbahis_takimAd2;
    @FXML
    private Label label_guncellenmisbahis_15ust;
    @FXML
    private Label label_guncellenmisbahis_25ust;
    @FXML
    private Label label_guncellenmisbahis_15alt;
    @FXML
    private Label label_guncellenmisbahis_ms1;
    @FXML
    private Label label_guncellenmisbahis_msX;
    @FXML
    private Label label_guncellenmisbahis_ms2;
    @FXML
    private Label label_guncellenmisbahis_siraNo;

    @FXML
    private void handleOnayButtonAction() {
        try {
            String siraNo = textfield_bahisduzenle_siraNo.getText();
            AktifMac aktifMac = DatabaseConnection.getAktifMacBilgileri(siraNo);

            if (aktifMac != null) {
                label_mevcutbahis_takimAd1.setText(aktifMac.getTakim1Isim());
                label_mevcutbahis_takimAd2.setText(aktifMac.getTakim2Isim());
                label_mevcutbahis_15ust.setText(String.valueOf(aktifMac.getOran15ust()));
                label_mevcutbahis_25ust.setText(String.valueOf(aktifMac.getOran25ust()));
                label_mevcutbahis_15alt.setText(String.valueOf(aktifMac.getOran15alt()));
                label_mevcutbahis_ms1.setText(String.valueOf(aktifMac.getOranMs1()));
                label_mevcutbahis_msX.setText(String.valueOf(aktifMac.getOranMsX()));
                label_mevcutbahis_ms2.setText(String.valueOf(aktifMac.getOranMs2()));
                label_mevcutbahis_siraNo.setText(String.valueOf(aktifMac.getMacSiraNo()));

                label_guncellenmisbahis_siraNo.setText(String.valueOf(aktifMac.getMacSiraNo()));
                label_guncellenmisbahis_takimAd1.setText(aktifMac.getTakim1Isim());
                label_guncellenmisbahis_takimAd2.setText(aktifMac.getTakim2Isim());
                label_guncellenmisbahis_15ust.setText(String.valueOf(aktifMac.getOran15ust()));
                label_guncellenmisbahis_25ust.setText(String.valueOf(aktifMac.getOran25ust()));
                label_guncellenmisbahis_15alt.setText(String.valueOf(aktifMac.getOran15alt()));
                label_guncellenmisbahis_ms1.setText(String.valueOf(aktifMac.getOranMs1()));
                label_guncellenmisbahis_msX.setText(String.valueOf(aktifMac.getOranMsX()));
                label_guncellenmisbahis_ms2.setText(String.valueOf(aktifMac.getOranMs2()));
            } else {
                showAlert(Alert.AlertType.ERROR, "Hata", "Maç bilgileri bulunamadı.");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Hata", "Geçersiz maç sıra numarası.");
        }
    }

    @FXML
    private void handleYenileButtonAction() {
        label_guncellenmisbahis_takimAd1.setText(textfield_bahisduzenle_takimAd1.getText());
        label_guncellenmisbahis_takimAd2.setText(textfield_bahisduzenle_takimAd2.getText());
        label_guncellenmisbahis_15ust.setText(textfield_bahisduzenle_15ust.getText());
        label_guncellenmisbahis_25ust.setText(textfield_bahisduzenle_25ust.getText());
        label_guncellenmisbahis_15alt.setText(textfield_bahisduzenle_15alt.getText());
        label_guncellenmisbahis_ms1.setText(textfield_bahisduzenle_ms1.getText());
        label_guncellenmisbahis_msX.setText(textfield_bahisduzenle_msX.getText());
        label_guncellenmisbahis_ms2.setText(textfield_bahisduzenle_ms2.getText());
    }

    @FXML
    private void handleKaydetButtonAction() {
        try {
            int siraNo = Integer.parseInt(textfield_bahisduzenle_siraNo.getText());
            String takim1 = textfield_bahisduzenle_takimAd1.getText();
            String takim2 = textfield_bahisduzenle_takimAd2.getText();
            float oran15ust = Float.parseFloat(textfield_bahisduzenle_15ust.getText());
            float oran25ust = Float.parseFloat(textfield_bahisduzenle_25ust.getText());
            float oran15alt = Float.parseFloat(textfield_bahisduzenle_15alt.getText());
            float oranMs1 = Float.parseFloat(textfield_bahisduzenle_ms1.getText());
            float oranMsX = Float.parseFloat(textfield_bahisduzenle_msX.getText());
            float oranMs2 = Float.parseFloat(textfield_bahisduzenle_ms2.getText());

            AktifMac yeniMac = new AktifMac(takim1, takim2, siraNo, oran15ust, oran15alt, oran25ust, oranMs1, oranMs2, oranMsX, 0, "", "", true, 0, 0, true);
            boolean isUpdated = DatabaseConnection.updateAktifMacBilgileri(siraNo, yeniMac);

            if (isUpdated) {
                showAlert(Alert.AlertType.INFORMATION, "Başarılı", "Bahis bilgileri güncellendi.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Hata", "Güncelleme başarısız.");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Hata", "Geçersiz sayı formatı.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
