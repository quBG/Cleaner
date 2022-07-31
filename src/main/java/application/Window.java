package application;

import application.exit.Observer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Window extends Observer {
    private static volatile Window window = null;
    private Scene scene;
    private Stage stage;
    private double OffsetX, OffsetY;
    private boolean addedToTray = false;

    private Window(Stage stage, Scene scene) {
        this.stage = stage;
        this.scene = scene;
    }

    public static Window getInstance(Stage stage, Scene scene) {
        Window result = window;

        if (result != null)
            return result;

        synchronized(Window.class) {
            if (window == null)
                window = new Window(stage, scene);
            return window;
        }
    }

    public void addToTray() {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            Platform.exit();
        }

        if (addedToTray)
            return;

        Image image = Toolkit.getDefaultToolkit().getImage("src/main/resources/pictures/Icons/MainIcon.png");

        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon = new TrayIcon(image, "ACCleaner");
        final SystemTray tray = SystemTray.getSystemTray();

        MenuItem openItem = new MenuItem("Open");
        MenuItem exitItem = new MenuItem("Exit");

        popup.add(openItem);
        popup.add(exitItem);

        trayIcon.setPopupMenu(popup);

        exitItem.addActionListener(event -> System.exit(0));
        openItem.addActionListener(event -> Platform.runLater(() -> stage.show()));

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }

        addedToTray = true;
    }

    public void dragging() {
        scene.setOnMousePressed(event -> {
            OffsetX = stage.getX() - event.getScreenX();
            OffsetY = stage.getY() - event.getScreenY();
        });
        scene.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() + OffsetX);
            stage.setY(event.getScreenY() + OffsetY);
        });
    }

    public void hideToTray(){
        addToTray();
        if (stage.isShowing()){
            stage.hide();
        }
    }

    @Override
    public void update() {
        hideToTray();
    }
}