package com.application.pages;

import com.application.tools.ExeTools;
import javafx.event.ActionEvent;

public class ClearingMemory {
    public void clear(ActionEvent event) {
        ExeTools.startExeService("SetProcessWorkingSetSize.exe",
                "/com/application/exeServices/SetProcessWorkingSetSize.exe");
    }
}