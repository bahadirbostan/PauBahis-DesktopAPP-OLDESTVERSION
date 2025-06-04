package com.example.pb_01;

import javafx.concurrent.Task;
import javafx.util.Callback;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection { //SIZ WEB API KULLANARAK DATABASE'E VE CANLI DESTEK GIBI MODULLERE BAGLANTI SAGLAYIN
    //BU HALIYLE OLABILDIGINCE GUVENLIK RISKI OLUSTURUYOR.
    public static final String URL = "jdbc:sqlserver://***.***.*.*;databaseName=pauBahis;encrypt=true;trustServerCertificate=true";
    public static final String USER = "*****";
    public static final String PASSWORD = "*********";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static User getUserDetails(String email) {
        String sqlQuery = "SELECT id, name, telno, isAdmin, balance FROM user_infos WHERE mail = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT id, name, telno, isAdmin, balance FROM user_infos WHERE mail = ?")) {
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String telno = resultSet.getString("telno");
                boolean isAdmin = resultSet.getBoolean("isAdmin");
                int balance = resultSet.getInt("balance");
                return new User(id, name, email, telno, isAdmin, balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AktifMac getAktifMacBilgileri(String macSiraNo) {
        String sqlQuery = "SELECT takim1, takim2, mac_siraNo, oran_15ust, oran_25ust, oran_15alt, oran_ms1, oran_msX, oran_ms2, mac_ID, Baslangic_Saati, Bitis_Saati, aktif_mi, skor_Takim1, skor_Takim2, mac_Basladi_mi FROM guncel_Maclar WHERE mac_siraNo = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, macSiraNo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String takim1_isim = resultSet.getString("takim1");
                String takim2_isim = resultSet.getString("takim2");
                int mac_siraNo = resultSet.getInt("mac_siraNo");
                float oran_15ust = resultSet.getFloat("oran_15ust");
                float oran_15alt = resultSet.getFloat("oran_15alt");
                float oran_25ust = resultSet.getFloat("oran_25ust");
                float oran_ms1 = resultSet.getFloat("oran_ms1");
                float oran_ms2 = resultSet.getFloat("oran_ms2");
                float oran_msX = resultSet.getFloat("oran_msX");
                int mac_ID = resultSet.getInt("mac_ID");
                String baslangic_Saati = resultSet.getString("baslangic_Saati");
                String bitis_Saati = resultSet.getString("bitis_Saati");
                boolean aktif_mi = resultSet.getBoolean("aktif_mi");
                int skor_takim1 = resultSet.getInt("skor_takim1");
                int skor_takim2 = resultSet.getInt("skor_takim2");
                boolean mac_Basladi_mi = resultSet.getBoolean("mac_Basladi_mi");

                return new AktifMac(takim1_isim, takim2_isim, mac_siraNo, oran_15ust, oran_15alt, oran_25ust, oran_ms1, oran_ms2, oran_msX, mac_ID, baslangic_Saati, bitis_Saati, aktif_mi, skor_takim1, skor_takim2, mac_Basladi_mi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean updateAktifMacBilgileri(int siraNo, AktifMac yeniMac) {
        String sqlQuery = "UPDATE guncel_Maclar SET takim1 = ?, takim2 = ?, oran_15ust = ?, oran_25ust = ?, oran_15alt = ?, oran_ms1 = ?, oran_msX = ?, oran_ms2 = ? WHERE mac_siraNo = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setString(1, yeniMac.getTakim1Isim());
            statement.setString(2, yeniMac.getTakim2Isim());
            statement.setFloat(3, yeniMac.getOran15ust());
            statement.setFloat(4, yeniMac.getOran25ust());
            statement.setFloat(5, yeniMac.getOran15alt());
            statement.setFloat(6, yeniMac.getOranMs1());
            statement.setFloat(7, yeniMac.getOranMsX());
            statement.setFloat(8, yeniMac.getOranMs2());
            statement.setInt(9, siraNo);

            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Task<AktifMac> getAktifMacBilgileriTask(int siraNo) {
        return new Task<>() {
            @Override
            protected AktifMac call() throws Exception {
                return DatabaseConnection.getAktifMacBilgileri(String.valueOf(siraNo));
            }
        };
    }


    public void updateUserBalance(String email, int balance) {

    }

    public static int getMatchID(int mac_siraNo) {
        String sqlQuery = "SELECT mac_ID FROM guncel_Maclar WHERE mac_siraNo = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, mac_siraNo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("mac_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static AktifMac getMatchInfosFromID(int mac_ID) {
        String sqlQuery = "SELECT takim1, takim2, mac_siraNo, oran_15ust, oran_25ust, oran_15alt, oran_ms1, oran_msX, oran_ms2, mac_ID, Baslangic_Saati, Bitis_Saati, aktif_mi, skor_Takim1, skor_Takim2, mac_Basladi_mi FROM guncel_Maclar WHERE mac_ID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, mac_ID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String takim1_isim = resultSet.getString("takim1");
                String takim2_isim = resultSet.getString("takim2");
                int mac_siraNo = resultSet.getInt("mac_siraNo");
                float oran_15ust = resultSet.getFloat("oran_15ust");
                float oran_15alt = resultSet.getFloat("oran_15alt");
                float oran_25ust = resultSet.getFloat("oran_25ust");
                float oran_ms1 = resultSet.getFloat("oran_ms1");
                float oran_ms2 = resultSet.getFloat("oran_ms2");
                float oran_msX = resultSet.getFloat("oran_msX");
                String baslangic_Saati = resultSet.getString("Baslangic_Saati");
                String bitis_Saati = resultSet.getString("Bitis_Saati");
                boolean aktif_mi = resultSet.getBoolean("aktif_mi");
                int skor_takim1 = resultSet.getInt("skor_Takim1");
                int skor_takim2 = resultSet.getInt("skor_Takim2");
                boolean mac_Basladi_mi = resultSet.getBoolean("mac_Basladi_mi");

                return new AktifMac(takim1_isim, takim2_isim, mac_siraNo, oran_15ust, oran_15alt, oran_25ust, oran_ms1, oran_ms2, oran_msX, mac_ID, baslangic_Saati, bitis_Saati, aktif_mi, skor_takim1, skor_takim2, mac_Basladi_mi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void storeMatchInBuffer(int user_ID, int macID, float oran) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                Connection connection = null;
                PreparedStatement statement = null;
                ResultSet resultSet = null;

                try {
                    connection = DatabaseConnection.getConnection();


                    String checkQuery = "SELECT mac1_id, mac2_id, mac3_id, mac4_id, mac5_id, mac6_id, mac7_id, mac8_id, mac9_id, mac10_id, toplamOran FROM kullanici_kuponlari_buffer WHERE user_ID = ?";
                    statement = connection.prepareStatement(checkQuery);
                    statement.setInt(1, user_ID);
                    resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        boolean matchExists = false;
                        float currentTotalOdds = resultSet.getFloat("toplamOran");


                        for (int i = 1; i <= 10; i++) {
                            if (macID == resultSet.getInt("mac" + i + "_id")) {
                                matchExists = true;
                                break;
                            }
                        }

                        if (matchExists) {

                            String updateQuery = "UPDATE kullanici_kuponlari_buffer SET toplamOran = ? WHERE user_ID = ?";
                            statement = connection.prepareStatement(updateQuery);
                            statement.setFloat(1, currentTotalOdds * oran);
                            statement.setInt(2, user_ID);
                            statement.executeUpdate();
                        } else {

                            String emptySlot = getEmptySlot(user_ID);
                            if (emptySlot != null) {
                                String sqlUpdateQuery = "UPDATE kullanici_kuponlari_buffer SET " + emptySlot + " = ?, toplamOran = ? WHERE user_ID = ?";
                                statement = connection.prepareStatement(sqlUpdateQuery);
                                statement.setInt(1, macID);
                                statement.setFloat(2, currentTotalOdds * oran);
                                statement.setInt(3, user_ID);
                                statement.executeUpdate();
                            } else {
                                System.out.println("No empty slot available for the user.");
                            }
                        }
                    } else {

                        String emptySlot = getEmptySlot(user_ID);
                        if (emptySlot != null) {
                            String sqlInsertQuery = "INSERT INTO kullanici_kuponlari_buffer (user_ID, " + emptySlot + ", toplamOran) VALUES (?, ?, ?)";
                            statement = connection.prepareStatement(sqlInsertQuery);
                            statement.setInt(1, user_ID);
                            statement.setInt(2, macID);
                            statement.setFloat(3, oran);
                            statement.executeUpdate();
                        } else {
                            System.out.println("No empty slot available for the user.");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (resultSet != null) try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if (statement != null) try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if (connection != null) try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                return null;
            }
        };
        new Thread(task).start();
    }


    public static boolean isKullaniciKuponuExists(int user_ID) {
        String sqlQuery = "SELECT COUNT(*) FROM kullanici_kuponlari_buffer WHERE user_ID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, user_ID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    private static String getEmptySlot(int user_ID) {
        String sqlQuery = "SELECT mac1_id, mac2_id, mac3_id, mac4_id, mac5_id, mac6_id, mac7_id, mac8_id, mac9_id, mac10_id FROM kullanici_kuponlari_buffer WHERE user_ID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, user_ID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                for (int i = 1; i <= 10; i++) {
                    if (resultSet.getObject("mac" + i + "_id") == null) {
                        return "mac" + i + "_id";
                    }
                }
            } else {

                return "mac1_id";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void getKullaniciKuponuMatches(int user_ID, Callback<List<AktifMac>> callback) {
        Task<List<AktifMac>> task = new Task<List<AktifMac>>() {
            @Override
            protected List<AktifMac> call() throws Exception {
                String sqlQuery = "SELECT mac1_ID, mac2_ID, mac3_ID, mac4_ID, mac5_ID, mac6_ID, mac7_ID, mac8_ID, mac9_ID, mac10_ID FROM kullanici_kuponlari_buffer WHERE user_ID = ?";
                List<AktifMac> matches = new ArrayList<>();

                try (Connection connection = DatabaseConnection.getConnection();
                     PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                    statement.setInt(1, user_ID);
                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        for (int i = 1; i <= 10; i++) {
                            int mac_ID = resultSet.getInt("mac" + i + "_ID");
                            if (mac_ID != 0) {
                                AktifMac matchInfo = getMatchInfosFromID(mac_ID);
                                if (matchInfo != null) {
                                    matches.add(matchInfo);
                                }
                            }
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return matches;
            }

            @Override
            protected void succeeded() {
                callback.call(getValue());
            }
        };
        new Thread(task).start();
    }


    public static List<Integer> getUserBufferMatchIDs(int userID) {
        List<Integer> matchIDs = new ArrayList<>();
        String sqlQuery = "SELECT mac1_id, mac2_id, mac3_id, mac4_id, mac5_id, mac6_id, mac7_id, mac8_id, mac9_id, mac10_id FROM kullanici_kuponlari_buffer WHERE user_ID = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                for (int i = 1; i <= 10; i++) {
                    int matchID = resultSet.getInt("mac" + i + "_id");
                    if (matchID != 0) {
                        matchIDs.add(matchID);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matchIDs;
    }

    public interface Callback<T> {
        void call(T result);
    }

    public static void deleteBufferKuponlar(int user_ID) {
        String sqlQuery = "DELETE FROM kullanici_kuponlari_buffer WHERE user_ID = ?";
        if (isKullaniciKuponuExists(user_ID)) {
            try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
                statement.setInt(1, user_ID);
                statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            return;
        }
    }

    public static User getUserDetailsByID(int id) {
        String sqlQuery = "SELECT mail, name, telno, isAdmin, balance FROM user_infos WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("mail");
                String name = resultSet.getString("name");
                String telno = resultSet.getString("telno");
                boolean isAdmin = resultSet.getBoolean("isAdmin");
                int balance = resultSet.getInt("balance");
                return new User(id,name,email,telno,isAdmin,balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*public static User[] getUsersByName(String name) {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users WHERE name LIKE ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + name + "%");

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return users.toArray(new User[0]);
    } */

}

