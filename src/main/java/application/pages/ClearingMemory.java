package application.pages;

import application.MainApplicationController;
import application.tools.ExeTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ClearingMemory{
    private PageController pageController = new PageController();

    public ClearingMemory(){
        pageController.setWorkspace(MainApplicationController.getWorkspace());
    }

    @FXML
    public void clear(ActionEvent event) {
        ExeTools.startExeService("SetProcessWorkingSetSize.exe",
                "/application/ExeServices/SetProcessWorkingSetSize.exe");
        pageController.loadPage("/application/WorkPages/SubPages/AfterClearingMemory.fxml");
    }

    @FXML
    public void backButton(){
        pageController.loadPage("/application/WorkPages/ClearingMemory.fxml");
    }
}