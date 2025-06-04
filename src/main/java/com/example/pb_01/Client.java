package com.example.pb_01;

import java.net.Socket;

public class Client {
    private static User loggedInUser;

    private static final String SERVER_ADDRESS = "95.214.177.78";
    private static final int SERVER_PORT = 8080;

    public static void startClient() {

        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            System.out.println("Server Bağlantısı Başarılı");
        } catch (Exception ex) {
            System.out.println("Server Bağlantı Hatası: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }
    public String getUserName(){
        Error errorType = null;
        String userGENERIC;

        userGENERIC = getLoggedInUser().getName();

        if (userGENERIC.isEmpty()){
        printErrType(errorType);
        }

        return loggedInUser.getName();
    }

    public Error printErrType(Error errType){
        errType.printStackTrace();
        return errType;
    }

}