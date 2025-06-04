package com.example.pb_01;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ButtonStateManager {

    private static final String BUTTON_STATE_FILE = "src/buttonStates.properties";

    public static void saveButtonStates(Map<String, Boolean> buttonStates) {
        try (OutputStream output = new FileOutputStream(BUTTON_STATE_FILE)) {
            Properties properties = new Properties();
            for (Map.Entry<String, Boolean> entry : buttonStates.entrySet()) {
                properties.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Boolean> loadButtonStates() {
        Map<String, Boolean> buttonStates = new HashMap<>();
        try (InputStream input = new FileInputStream(BUTTON_STATE_FILE)) {
            Properties properties = new Properties();
            properties.load(input);
            for (String key : properties.stringPropertyNames()) {
                buttonStates.put(key, Boolean.parseBoolean(properties.getProperty(key)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buttonStates;
    }
    public static boolean clearPropertiesFile(String filePath) {
        Properties properties = new Properties();
        File file = new File(filePath);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            properties.store(fos, null); // Dosyayı boş olarak sakla
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
