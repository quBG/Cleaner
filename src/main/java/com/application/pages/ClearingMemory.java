package com.application.pages;

import com.application.tools.memory.Cleaning;
import javafx.event.ActionEvent;

public class ClearingMemory{

    public void clear(ActionEvent event) {
        Cleaning.use();
        System.out.println("Complete Cleaning Memory");
    }
}
