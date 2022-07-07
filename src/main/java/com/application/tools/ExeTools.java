package com.application.tools;

import java.awt.*;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExeTools {
    /**
    * Method launches an exe file by unpacking it to a predefined folder
    * @param serviceName must be specified in the format "service.exe"
    * @param pathToService must be specified in the format "/com/application/pathToExe/program.exe"
    */
    public static void startExeService(String serviceName, String pathToService) {
        Path exe = Path.of(System.getProperty("user.home"), ".ACCleaner", serviceName);
        try {
            if (Files.notExists(exe)) {
                try (InputStream in = ExeTools.class.getResourceAsStream(pathToService)) {
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
