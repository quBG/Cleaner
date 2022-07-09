package application.pages;

import application.tools.ExeTools;
import javafx.event.ActionEvent;

public class CleaningFiles {
    public void clear(ActionEvent event) {
        ExeTools.startExeService("DiskSpaceCleanup.exe",
                "/application/exeServices/DiskSpaceCleanup.exe");
    }
}
