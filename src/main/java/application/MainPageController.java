package application;

import application.exit.Observer;
import application.pages.PageController;
import application.tools.ButtonTools;
import application.tools.ConverterTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.*;

public class MainPageController implements Initializable {
    @FXML
    private VBox containerButtons;
    @FXML
    private static BorderPane workspace;
    private List<Observer> observers = new ArrayList<>();
    private List<Button> modeSelections = new ArrayList<>();
    private PageController pageController = new PageController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ConverterTools.vboxToList(containerButtons, modeSelections);
    }

    /**
     * Need to use this to bypass creating new
     * instances of a class or creating a singleton
     */
    public static BorderPane getWorkspace(){
        return workspace;
    }

    /**
     * @param observer used when exiting the program
     */
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @FXML
    private void cleaningFiles(ActionEvent event) {
        pageController.loadPage(workspace,"/application/WorkPages/CleaningFiles.fxml");
        ButtonTools.buttonBacklight((Button) event.getSource(), modeSelections);
    }

    @FXML
    private void clearingMemory(ActionEvent event) {
        pageController.loadPage(workspace,"/application/WorkPages/ClearingMemory.fxml");
        ButtonTools.buttonBacklight((Button) event.getSource(), modeSelections);
    }

    @FXML
    private void computerInformation(ActionEvent event) {
        pageController.loadPage(workspace,"/application/WorkPages/ComputerInformation.fxml");
        ButtonTools.buttonBacklight((Button) event.getSource(), modeSelections);
    }

    @FXML
    private void programSettings(ActionEvent event) {
        pageController.loadPage(workspace,"/application/WorkPages/ProgramSettings.fxml");
        ButtonTools.buttonBacklight((Button) event.getSource(), modeSelections);
    }

    /**
     * Notifies all listeners of the exit
     */
    @FXML
    private void closeProgram() {
        addObserver(Window.getInstance(null, null));
        for (Observer observer : observers)
            observer.update();
    }
}
