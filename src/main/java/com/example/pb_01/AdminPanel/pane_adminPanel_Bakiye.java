package com.example.pb_01.AdminPanel;

import com.example.pb_01.DatabaseConnection;
import com.example.pb_01.HelloController;
import com.example.pb_01.User;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;

public class pane_adminPanel_Bakiye {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
    com.example.pb_01.HelloController loginController = loader.getController();
    String admin_mail = HelloController.getLoggedUserMail();
    User admin =  DatabaseConnection.getUserDetails(admin_mail);
    int user_currentBalance;





    private void addBalance(int id,int investmentAmount){
        if (admin.isAdmin()){
            user_currentBalance = DatabaseConnection.getUserDetailsByID(id).getBalance();
            DatabaseConnection.getUserDetailsByID(id).setBalance(user_currentBalance+investmentAmount);
        }
      else {
          yetkisizIslemAlert();

        }
    }
    private void delBalance(int id,int removalAmount){
        if (admin.isAdmin()){
        user_currentBalance = DatabaseConnection.getUserDetailsByID(id).getBalance();
        DatabaseConnection.getUserDetailsByID(id).setBalance(user_currentBalance-removalAmount);
        }
        else {
            yetkisizIslemAlert();
        }
    }

    private void updateBalance(int id,int balance){
        if (admin.isAdmin()){
            DatabaseConnection.getUserDetailsByID(id).setBalance(balance);
        }
        else {
            yetkisizIslemAlert();
        }
    }



    private void yetkisizIslemAlert(){
        loginController.showAlert(Alert.AlertType.ERROR,"YETKİSİZ İŞLEM !","Bu sayfayı görüntülemek için yetkiniz bulunmamaktadır !");
        Platform.exit();
        //bu asamadan sonra dataBase'e log düşecek yetkisiz bir giriş olduğuna dair !
    }

}
