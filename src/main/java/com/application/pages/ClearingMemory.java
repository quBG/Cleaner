package com.application.pages;

import javafx.event.ActionEvent;
import java.awt.Desktop;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClearingMemory{
    public void clear(ActionEvent event) {
        useCleaningService();
    }

    private void useCleaningService() {
        Path exe = Path.of(System.getProperty("user.home"), ".ACCleaner", "SetProcessWorkingSetSize.exe");
        try {
            if (Files.notExists(exe)) {
                try (InputStream in = getClass().getResourceAsStream("/com/application/exeServices/SetProcessWorkingSetSize.exe")) {
                    Files.createDirectories(exe.getParent());
                    Files.copy(in, exe);
                }
            }
            Desktop.getDesktop().open(exe.toFile());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}