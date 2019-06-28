package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.MalformedURLException;

public class Main extends Application
{
    private EnadeTable table = new EnadeTable();
    public static String defaultUrl = "https://docs.google.com/spreadsheets/d/e/2PACX-1vTO06Jdr3J1kPYoTPRkdUaq8XuslvSD5--FPMht-ilVBT1gExJXDPTiX0P3FsrxV5VKUZJrIUtH1wvN/pub?gid=0&single=true&output=csv";

    @Override
    public void start(Stage stage) throws IOException
    {
        VBox vbox = new VBox();
        MenuBar menuBar = createMainMenuBar(stage);
        vbox.getChildren().addAll(menuBar, table.createFXTable());
        stage.setScene(new Scene(vbox, 1200, 512 + 256));
        stage.setTitle("ENADE");
        stage.show();
    }

    public static void main(String[] args)
    {
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
            }
            catch (MalformedURLException ex)
            {
                ErrorAlert.DisplayError("Invalid URL", ex);
            }
            catch (IOException ex)
            {
                ErrorAlert.DisplayError("Invalid URL file", ex);
            }
        });
    }

    private void setSourceButtonCallback(MenuItem sourceButton)
    {
        sourceButton.setOnAction(e ->
        {
            Stage newWindow = new Stage();
            TextField textField = new TextField();
            textField.setText(defaultUrl);
            newWindow.setScene(new Scene(textField, 768, 30));
            newWindow.initModality(Modality.APPLICATION_MODAL);
            newWindow.show();
            newWindow.setTitle("URL Link");
            newWindow.setOnCloseRequest(ev -> defaultUrl = textField.getText());
        });
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
