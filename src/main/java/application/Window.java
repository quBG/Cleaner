package application;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Window {
    private static Window window = null;
    private static Timer notificationTimer = new Timer();
    private Scene scene;
    private Stage stage;
    private double OffsetX, OffsetY;

    private Window(Stage stage, Scene scene){
        this.stage = stage;
        this.scene = scene;
        window.WindowDragging();
    }

    public static synchronized Window getInstance(Stage stage, Scene scene) {
        if (window == null) {
            window = new Window(stage, scene);
        }
        return window;
    }

    public void hideWindowsToTray(){
        try {
            java.awt.Toolkit.getDefaultToolkit();

            if (!java.awt.SystemTray.isSupported()) {
                System.out.println("No system tray support, application exiting.");
                Platform.exit();
            }

            java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();
            URL imageLoc = new URL(
                    "https://upload.wikimedia.org/wikipedia/ru/5/51/CCleaner_logo.png"
            );

            java.awt.Image image = ImageIO.read(imageLoc);
            java.awt.TrayIcon trayIcon = new java.awt.TrayIcon(image);

            trayIcon.addActionListener(event -> Platform.runLater(showStage()));

            java.awt.MenuItem openItem = new java.awt.MenuItem("hello, world");
            openItem.addActionListener(event -> Platform.runLater(showStage()));

            java.awt.Font defaultFont = java.awt.Font.decode(null);
            java.awt.Font boldFont = defaultFont.deriveFont(java.awt.Font.BOLD);
            openItem.setFont(boldFont);

            java.awt.MenuItem exitItem = new java.awt.MenuItem("Exit");
            exitItem.addActionListener(event -> {
                notificationTimer.cancel();
                Platform.exit();
                tray.remove(trayIcon);
            });

            final java.awt.PopupMenu popup = new java.awt.PopupMenu();
            popup.add(openItem);
            popup.addSeparator();
            popup.add(exitItem);
            trayIcon.setPopupMenu(popup);

            notificationTimer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        javax.swing.SwingUtilities.invokeLater(() ->
                                trayIcon.displayMessage(
                                        "hello",
                                        "The time is now " + SimpleDateFormat.getTimeInstance().format(new Date()),
                                        java.awt.TrayIcon.MessageType.INFO
                                )
                        );
                    }
                },
                    5_000,
                    60_000
            );
            tray.add(trayIcon);
        } catch (java.awt.AWTException | IOException e) {
            System.out.println("Unable to init system tray");
            e.printStackTrace();
        }
    }

    private void WindowDragging(){
        scene.setOnMousePressed(event -> {
            OffsetX = stage.getX() - event.getScreenX();
            OffsetY = stage.getY() - event.getScreenY();
        });
        scene.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() + OffsetX);
            stage.setY(event.getScreenY() + OffsetY);
        });
    }

    private Runnable showStage() {
        if (stage != null) {
            stage.show();
            stage.toFront();
        }
        return null;
    }
}
