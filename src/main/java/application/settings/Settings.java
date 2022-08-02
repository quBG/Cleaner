package application.settings;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public interface Settings extends Serializable {
    boolean getHideProgramToTray();
    boolean getAutoStartProgram();
    boolean getDarkMode();

//    void writeObject(ObjectOutputStream stream) throws IOException;
//    void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException;
}
