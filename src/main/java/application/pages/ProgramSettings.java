package application.pages;

import application.exit.Observer;
import application.settings.Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ProgramSettings extends Observer implements Settings, Initializable {
    private ProgramSettings programSettings;
    @FXML
    private CheckBox hideProgramToTray;
    @FXML
    private CheckBox autoStartProgram;
    @FXML
    private CheckBox darkMode;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadInputStream();
    }

    @Override
    public void update() {
        createOutputStream();
    }

    public boolean getHideProgramToTray() {
        return hideProgramToTray.isSelected();
    }

    public boolean getAutoStartProgram() {
        return autoStartProgram.isSelected();
    }

    public boolean getDarkMode() {
        return darkMode.isSelected();
    }

    private void loadInputStream() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("ProgramSettings.out"));
            programSettings = (ProgramSettings) inputStream.readObject();
            inputStream.close();
        } catch (ClassNotFoundException |IOException e) {
            System.out.println("LOAD INPUT STREAM EXCEPTION ");
        }
    }

    private void createOutputStream() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ProgramSettings.out"));
            out.writeObject(programSettings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}