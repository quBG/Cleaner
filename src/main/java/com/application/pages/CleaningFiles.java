package com.application.pages;

import javafx.event.ActionEvent;

public class CleaningFiles extends Page {

    @Override
    public void use() {
        System.out.println("WORK");
    }

    public void workButton(ActionEvent event) {
        System.out.println("work");
    }
}
