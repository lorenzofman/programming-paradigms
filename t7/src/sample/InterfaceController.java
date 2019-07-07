package sample;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class InterfaceController {

    private MenuBar bar = new MenuBar();
    private Stage stage;
    public void idleDisplay(Stage stage, CallbacksController callbacks)
    {
        this.stage = stage;
        createMenuItems(stage, callbacks);
    }

    public void showInfoDialog(String title, String header, String content)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }


    public Stage getStage()
    {
        return stage;
    }

    private void createMenuItems(Stage stage, CallbacksController callbacks)
    {
        Menu fileMenu = new Menu("File");
        Menu toolsMenu = new Menu("Tools");
        Menu helpMenu = new Menu("Help");
        MenuItem openItem = new MenuItem("Open");
        openItem.setOnAction(e -> callbacks.onOpen());
        MenuItem quitItem = new MenuItem("Quit");
        quitItem.setOnAction(e -> callbacks.onExit());

        MenuItem commitItem = new MenuItem("Commit Analyzer");
        commitItem.setOnAction(e -> {
            try {
                callbacks.onCommitAnalyze();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        MenuItem aboutItem = new MenuItem("About");
        aboutItem.setOnAction(e -> callbacks.onAbout());

        fileMenu.getItems().add(openItem);
        fileMenu.getItems().add(quitItem);

        toolsMenu.getItems().add(commitItem);

        helpMenu.getItems().add(aboutItem);

        bar.getMenus().add(fileMenu);
        bar.getMenus().add(toolsMenu);
        bar.getMenus().add(helpMenu);
        stage.setScene(new Scene(bar, 600, 480));
        stage.show();
    }

}
