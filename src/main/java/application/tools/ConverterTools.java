package application.tools;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.List;

public class ConverterTools {
    public static  <T> void vboxToList(VBox box, List<T> list) {
        for (Node element : box.getChildren().stream().toList())
            list.add((T)element);
    }
}
