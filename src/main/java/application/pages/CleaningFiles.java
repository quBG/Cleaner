package application.pages;

import application.tools.ExeTools;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;

public class CleaningFiles {
    public HBox cleaningButton;
    public HBox background;
    public HBox cleaningCompletionBackground;

    public void clear(ActionEvent event) {
        cleaningButton.setVisible(false);
        background.setVisible(false);
        ExeTools.startExeService("DiskSpaceCleanup.exe",
                "/application/exeServices/DiskSpaceCleanup.exe");
        cleaningCompletionBackground.setVisible(true);
    }
}
