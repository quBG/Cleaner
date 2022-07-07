package com.application.pages;

import com.application.tools.ExeTools;
import javafx.event.ActionEvent;

public class CleaningFiles {
    public void clear(ActionEvent event) {
        ExeTools.startExeService("DiskSpaceCleanup.exe",
                "/com/application/exeServices/DiskSpaceCleanup.exe");
    }
}
