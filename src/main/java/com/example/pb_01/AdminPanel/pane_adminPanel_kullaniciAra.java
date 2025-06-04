package com.example.pb_01.AdminPanel;

import com.example.pb_01.DatabaseConnection;
import com.example.pb_01.User;
import javafx.application.Platform;

public class pane_adminPanel_kullaniciAra {


    private User kullaniciyiAraByMail(String mail) {
        return DatabaseConnection.getUserDetails(mail);
    }

    private User kullaniciyiAraByID(int ID) {
        return DatabaseConnection.getUserDetailsByID(ID);
    }
}

 /*  private User[] kullanicilariListele(String name){
       User[] kullaniciList = new User[];

       return User[];
   }
} */
