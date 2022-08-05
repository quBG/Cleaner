package application.pages;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public class ComputerInformation {
    @FXML
    private VBox container;
    private List<Label> parameters = new ArrayList<>();
    private OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

    @FXML
    public void initialize() {
        parameters.add(new Label("System"));
        parameters.add(new Label("OS name: " + System.getProperty("os.name")));
        parameters.add(new Label("OS version: " + System.getProperty("os.version")));
        parameters.add(new Label("Architecture: " + System.getProperty("os.arch")));
        parameters.add(new Label(""));
        parameters.add(new Label("CPU"));
        parameters.add(new Label("Usage: " + Math.round(osBean.getCpuLoad()*100)+ "%"));
        parameters.add(new Label("Cores: " + Runtime.getRuntime().availableProcessors()));
        parameters.add(new Label(""));
        parameters.add(new Label("RAM"));
        parameters.add(new Label("Total memory size: " + osBean.getTotalPhysicalMemorySize() + " MB"));
        parameters.add(new Label("Free memory: " + osBean.getFreeMemorySize() + " MB"));

        for (Label label : parameters) {
            container.getChildren().add(label);
        }
    }
}
