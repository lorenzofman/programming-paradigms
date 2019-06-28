package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
    private EnadeTable table = new EnadeTable();
    @Override
    public void start(Stage stage) throws IOException
    {
        VBox vbox = new VBox();
        MenuBar menuBar = createMainMenuBar(stage);
        vbox.getChildren().addAll(menuBar, table.createFXTable());
        stage.setScene(new Scene(vbox,1200,512+256));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private MenuBar createMainMenuBar(Stage primaryStage) throws IOException
    {
        // Menus (File and Help)
        Menu fileMenu = new Menu("File");
        Menu helpMenu = new Menu("Help");

        // Menu Dropdowns(File -> Reload & Source & Exit; Help -> About)
        MenuItem reloadButton = new MenuItem("Reload");
        MenuItem sourceButton = new MenuItem("Source");
        MenuItem exitButton = new MenuItem("Exit");
        MenuItem aboutButton = new MenuItem("About");

        // Set callbacks
        setReloadButtonCallback(reloadButton);
        setSourceButtonCallback(sourceButton);
        setExitButtonCallback(exitButton);
        setAboutButtonCallback(aboutButton);

        MenuBar menuBar = new MenuBar();

        fileMenu.getItems().addAll(reloadButton, sourceButton, exitButton);

        helpMenu.getItems().add(aboutButton);


        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(helpMenu);

        return  menuBar;
    }

    private void setReloadButtonCallback(MenuItem reloadButton)
    {
        reloadButton.setOnAction(e ->
        {
            try
            {
                table.updateFXTable();
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        });
    }

    private void setSourceButtonCallback(MenuItem sourceButton)
    {

    }

    private void setExitButtonCallback(MenuItem exitButton)
    {
        exitButton.setOnAction(e -> Platform.exit());
    }

    private void setAboutButtonCallback(MenuItem aboutButton)
    {
        aboutButton.setOnAction(e ->
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("ENADE Spreadsheet");
            alert.setContentText("Lorenzo Schwertner Kaufmann\n2019");
            alert.showAndWait();
        });
    }

}
