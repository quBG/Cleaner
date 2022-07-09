package application.pages;

import application.tools.ExeTools;
import javafx.event.ActionEvent;

public class ClearingMemory {
    public void clear(ActionEvent event) {
        ExeTools.startExeService("SetProcessWorkingSetSize.exe",
                "/application/exeServices/SetProcessWorkingSetSize.exe");
    }
}