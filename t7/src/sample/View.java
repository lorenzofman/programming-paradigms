package sample;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class View {

    private MenuBar bar = new MenuBar();
    public void display(Stage stage) {
        createMenuItems(stage);
    }

    private void createMenuItems(Stage stage)
    {
        Menu fileMenu = new Menu("File");
        Menu toolsMenu = new Menu("Tools");
        Menu helpMenu = new Menu("Help");
        MenuItem openItem = new MenuItem("Open");
        MenuItem quitItem = new MenuItem("Quit");

        MenuItem commitItem = new MenuItem("Commit Analyzer");

        MenuItem aboutItem = new MenuItem("About");

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
