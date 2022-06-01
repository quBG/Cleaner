package com.application.Tools;

import javafx.scene.control.Button;
import javafx.scene.effect.Bloom;

import java.util.List;

public class ButtonTools {
    public static void clearButtonsEffects(List<javafx.scene.control.Button> buttons){
        for (javafx.scene.control.Button button : buttons)
            button.setEffect(null);
    }

    public static void buttonBacklight(Button button, List<Button> list){
        ButtonTools.clearButtonsEffects(list);
        button.setEffect(new Bloom(0.9f));
    }

}
