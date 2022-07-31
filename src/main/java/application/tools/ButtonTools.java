package application.tools;

import javafx.scene.control.Button;
import javafx.scene.effect.Bloom;

import java.util.List;

public class ButtonTools {
    public static void clearButtonsEffects(List<Button> buttons){
        for (Button button : buttons)
            button.setEffect(null);
    }

    /**
     * Gets an array of buttons from which it removes
     * all effects and makes a certain button with a backlight
     * @param button button for which you want to set the effect
     * @param list list of buttons whose effects should be cleared
     */
    public static void buttonBacklight(Button button, List<Button> list){
        ButtonTools.clearButtonsEffects(list);
        button.setEffect(new Bloom(0.9f));
    }
}
