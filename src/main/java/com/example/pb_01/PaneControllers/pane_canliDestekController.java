package com.example.pb_01.PaneControllers;

import com.example.pb_01.Client;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.*;
import java.net.Socket;

public class pane_canliDestekController {
    @FXML
    private TextField textField_mesajGirmeAlani;

    @FXML
    private TextArea textArea_chatArea;
    @FXML
    private Button button_sohbet_sohbettencik;

    private static final String SERVER_ADDRESS = ""; //VDS SERVERININ IP ADRESI BURAYA GIRILECEKTIR
    private static final int SERVER_PORT = 2000 ; //PORT DA BURAYA GIRILECEKTIR

    private BufferedWriter writer;
    private BufferedReader reader;
    private Socket socket;
    public boolean isUserConnectedToChat = true;

    @FXML
    public void initialize() {
        textArea_chatArea.setFont(Font.font("Courier New", FontWeight.BOLD, 18));
        try {
            button_sohbet_sohbettencik.setOnMouseClicked(mouseEvent -> disconnect());

            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            writer.write(Client.getLoggedInUser().getName() + "\n");
            writer.flush();

            Thread listenerThread = new Thread(this::listenForMessages);
            listenerThread.setDaemon(true);
            listenerThread.start();

            textField_mesajGirmeAlani.setOnAction(event -> sendMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String message = textField_mesajGirmeAlani.getText().trim();
        if (!message.isEmpty()) {
            try {
                writer.write(message + "\n");
                writer.flush();

                textField_mesajGirmeAlani.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void listenForMessages() {
        String message;
        try {
            while ((message = reader.readLine()) != null) {
                String finalMessage = message;
                Platform.runLater(() -> appendMessageToChat(finalMessage.toUpperCase()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void appendMessageToChat(String message) {
        textArea_chatArea.appendText(message + "\n");
    }

    private void disconnect(){
        try {
            socket.close();
            isUserConnectedToChat = false;
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
