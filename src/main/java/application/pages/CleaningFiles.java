package application.pages;

import application.MainPageController;
import application.tools.ExeTools;
import javafx.event.ActionEvent;

public class CleaningFiles {
    private PageController pageController = new PageController();

    public CleaningFiles(){
        pageController.setWorkspace(MainPageController.mainWorkspace);
    }

    public void clear(ActionEvent event) {
        pageController.loadPage("/application/WorkPages/SubPages/AfterCleaningFiles.fxml");
        ExeTools.startExeService("DiskSpaceCleanup.exe",
                "/application/ExeServices/DiskSpaceCleanup.exe");
    }

    public void backButton(ActionEvent event){
        pageController.loadPage("/application/WorkPages/CleaningFiles.fxml");
    }
}
