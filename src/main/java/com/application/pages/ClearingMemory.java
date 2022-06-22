package com.application.pages;

import javafx.event.ActionEvent;
import com.application.tools.RAM.EmptyWorkingSet;

public class ClearingMemory extends Page{
    private EmptyWorkingSet emptyWorkingSet = new EmptyWorkingSet();

    public void clear(ActionEvent event) {
        emptyWorkingSet.clear();
        cleaningCompleted();
    }

    private void cleaningCompleted(){
        System.out.println("Complete Cleaning Memory");
    }
}
