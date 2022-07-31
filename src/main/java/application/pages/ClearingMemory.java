package application.pages;

import application.MainPageController;
import application.tools.ExeTools;
import javafx.fxml.FXML;

public class ClearingMemory{
    private PageController pageController = new PageController();

    @FXML
    public void clear() {
        ExeTools.startExeService("SetProcessWorkingSetSize.exe",
                "/application/ExeServices/SetProcessWorkingSetSize.exe");
        pageController.loadPage(MainPageController.getWorkspace(),
                "/application/WorkPages/SubPages/AfterClearingMemory.fxml");
    }

    @FXML
    public void backButton(){
        pageController.loadPage(MainPageController.getWorkspace(),
                "/application/WorkPages/ClearingMemory.fxml");
    }
}