package application.pages;

import application.MainPageController;
import application.tools.ExeTools;

public class CleaningFiles {
    private PageController pageController = new PageController();

    public void clear() {
        pageController.loadPage(MainPageController.getWorkspace(),
                "/application/WorkPages/SubPages/AfterCleaningFiles.fxml");
        ExeTools.startExeService("DiskSpaceCleanup.exe",
                "/application/ExeServices/DiskSpaceCleanup.exe");
    }

    public void backButton(){
        pageController.loadPage(MainPageController.getWorkspace(),
                "/application/WorkPages/CleaningFiles.fxml");
    }
}
