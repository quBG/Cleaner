package application.pages;

import application.MainApplicationController;
import application.tools.ExeTools;
import javafx.event.ActionEvent;

public class CleaningFiles {
    private PageController pageController = new PageController();

    public void clear(ActionEvent event) {
        pageController.setWorkspace(MainApplicationController.getWorkspace());
        pageController.loadPage("/application/WorkPages/SubPages/AfterCleaning.fxml");
        ExeTools.startExeService("DiskSpaceCleanup.exe",
                "/application/ExeServices/DiskSpaceCleanup.exe");
    }
}
