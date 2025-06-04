package com.example.pb_01;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField textfield_email;
    @FXML
    private PasswordField passwordfield_password;
    @FXML
    private Button button_close;
    @FXML
    private Button button_register;
    @FXML
    private ImageView image_login;
    @FXML
    private ImageView image_register;
    @FXML
    private Pane leftpane;
    @FXML
    private Pane rightpane;
    @FXML
    private Button button_slidetoleft;
    @FXML
    private Pane registerpane;
    @FXML
    private TextField textfield_reg_name;
    @FXML
    private TextField textfield_reg_email;
    @FXML
    private TextField textfield_reg_telno;
    @FXML
    private PasswordField passwordfield_reg_password;
    @FXML
    private Button button_reg_register;
    @FXML
    private Button button_minimize;
    @FXML
    private AnchorPane anchorpane_main;

    mainMenuController mainMenuController = new mainMenuController();

    private double xOffset = 0;
    private double yOffset = 0;
    private static String loggedUserEmail;
    boolean isRegisterationSucceed;

    @FXML
    protected void onCloseButtonClick(ActionEvent event) {
        fadeAnim(button_close);
        Platform.exit();
    }

    @FXML
    protected void onLoginButtonClick(ActionEvent event) {


        boolean isUserAuthenticated = false;
        fadeAnim(image_login);
        String email_input = textfield_email.getText();
        String password_input = passwordfield_password.getText();
        if (password_input.isEmpty() || email_input.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Bilgilerinizi Kontrol Ediniz", "Tüm Alanları Doldurduğunuzdan Emin Olunuz");
            return;
        }
        Task<Boolean> loginTask = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                return authenticateUser(email_input, password_input);
            }
        };

        loginTask.setOnSucceeded(e -> {
            if (loginTask.getValue()) {
                loggedUserEmail = email_input;
                showAlert(Alert.AlertType.CONFIRMATION, "Giriş Başarılı", "Yönlendiriliyorsunuz...");
                try {
                    switchToSecondScene();
                } catch (IOException exception) {

                    exception.printStackTrace();
                    showAlert(Alert.AlertType.ERROR, "Hata", "Menüye Giriş Sağlanırken Hata Oluştu\n0SCGH02");//SCENE GECIS HATASI 02 -> 2. SAHNEYE GECIS
                    textfield_email.setText(null);
                    passwordfield_password.setText(null);
                }


            } else {
                showAlert(Alert.AlertType.ERROR, "Giriş Başarısız", "Giriş Bilgilerinizi Kontrol Ediniz !");
                textfield_email.setText(null);
                passwordfield_password.setText(null);
            }
        });

        loginTask.setOnFailed(e -> {
            showAlert(Alert.AlertType.ERROR, "Giriş Başarısız", "Bir hata oluştu!");
            textfield_email.setText(null);
            passwordfield_password.setText(null);
        });

        new Thread(loginTask).start();
    }


    @FXML
    protected void onRegisterButtonClick(ActionEvent event) {//kayıt ekranındaki register butonu
        fadeAnim(image_register);

        String input_reg_name = textfield_reg_name.getText();
        String input_reg_email = textfield_reg_email.getText();
        String input_reg_telno = textfield_reg_telno.getText();
        String input_reg_password = passwordfield_reg_password.getText();

        if (input_reg_name.isEmpty() || input_reg_email.isEmpty() || input_reg_password.isEmpty() || input_reg_telno.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Bilgilerinizi Kontrol Ediniz", "Tüm Alanları Doldurduğunuzdan Emin Olunuz");
            return;
        }

        Task<Boolean> registerTask = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                if (isUserExists(input_reg_email, input_reg_telno)) {
                    return false;
                } else {
                    return registerUser(input_reg_name, input_reg_email, input_reg_telno, input_reg_password);
                }
            }
        };
        registerTask.setOnSucceeded(e -> {
            if (registerTask.getValue()) {
                showAlert(Alert.AlertType.CONFIRMATION, "Kayıt Başarılı !", "Başarıyla Kayıt Oldunuz !");
                textfield_reg_name.setText(null);
                textfield_reg_email.setText(null);
                textfield_reg_telno.setText(null);
                passwordfield_reg_password.setText(null);
                //bunun altı animasyon kodu
                girisEkraninaGit();


            } else {
                showAlert(Alert.AlertType.ERROR, "Kayıt Başarısız !", "E-Mail / Telefon Numarası Kullanılıyor !");
                textfield_reg_name.setText(null);
                textfield_reg_email.setText(null);
                textfield_reg_telno.setText(null);
                passwordfield_reg_password.setText(null);
            }
        });
        registerTask.setOnFailed(e -> {
            showAlert(Alert.AlertType.ERROR, "Kayıt Başarısız", "Bir Hata Meydana Geldi");
            textfield_reg_name.setText(null);
            textfield_reg_email.setText(null);
            textfield_reg_telno.setText(null);
            passwordfield_reg_password.setText(null);
        });
        new Thread(registerTask).start();

    }


    protected void switchToSecondScene() throws IOException {
        Stage stage = (Stage) button_register.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("usersMainMenu.fxml"));
        Scene scene = new Scene(loader.load());


        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xOffset = mouseEvent.getSceneX();
                yOffset = mouseEvent.getSceneY();
            }
        });
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setX(mouseEvent.getScreenX() - xOffset);
                stage.setY(mouseEvent.getScreenY() - yOffset);
            }
        });

        stage.setScene(scene);
    }

    @FXML
    protected void onMinimizeButtonClick(ActionEvent event) {
        Stage stage = (Stage) anchorpane_main.getScene().getWindow();

        // AnchorPane üzerinde opaklık azaltma animasyonu oluşturma
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(300), anchorpane_main);
        fadeTransition.setToValue(0.0);
        fadeTransition.setOnFinished(e -> {
            // Animasyon bittikten sonra pencereyi simge durumuna küçültme
            stage.setIconified(true);
            // Pencere tekrar açıldığında opaklığını geri yükleme
            stage.iconifiedProperty().addListener((ov, t, t1) -> {
                if (!stage.isIconified()) {
                    anchorpane_main.setOpacity(1.0);
                }
            });
        });
        fadeTransition.play();
    }


    private boolean authenticateUser(String email, String password) {
        String sqlQuery = "SELECT * FROM user_infos WHERE mail = ? AND password = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void fadeAnim(Node object) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.1), object);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_register.setOnAction(event1 -> {//slides to right
            TranslateTransition slide = new TranslateTransition(Duration.seconds(0.3), leftpane);//ana menüdeki register buttonu
            slide.setToX(400);
            slide.play();
            rightpane.setVisible(false);
            registerpane.setVisible(true);
            slide.setOnFinished(event2 -> {
                button_slidetoleft.setVisible(true);
                passwordfield_password.setText(null);
                textfield_email.setText(null);
            });
        });


        button_slidetoleft.setOnAction(event3 -> {
            TranslateTransition slide = new TranslateTransition(Duration.seconds(0.3), leftpane);
            slide.setToX(0);
            slide.play();
            rightpane.setVisible(true);
            registerpane.setVisible(false);
            slide.setOnFinished(event4 -> {
                button_slidetoleft.setVisible(false);
                textfield_reg_email.setText(null);
                textfield_reg_name.setText(null);
                textfield_reg_telno.setText(null);
                passwordfield_reg_password.setText(null);
            });
        });

    }

    private boolean isUserExists(String email, String telno) {
        String sqlQuery = "SELECT * FROM user_infos WHERE mail = ? OR telno = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, email);
            statement.setString(2, telno);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // eğer false dönüyosa kullanıcı yoktur.
        }
    }

    private boolean registerUser(String name, String email, String telno, String password) {
        String sqlQuery2 = "INSERT INTO user_infos (name, mail, telno, password) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlQuery2)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, telno);
            statement.setString(4, password);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getLoggedUserMail() {
        return loggedUserEmail;
    }


    public void girisEkraninaGit() {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.3), leftpane);
        slide.setToX(0);
        slide.play();
        rightpane.setVisible(true);
        registerpane.setVisible(false);
        slide.setOnFinished(event4 -> {
            button_slidetoleft.setVisible(false);
            textfield_reg_email.setText(null);
            textfield_reg_name.setText(null);
            textfield_reg_telno.setText(null);
            passwordfield_reg_password.setText(null);
        });
    }

}