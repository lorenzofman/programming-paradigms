package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class RandomPickerGUI extends Application
{
    public static void main(String[] args)
    {

        launch(args);
    }

    private TextArea listOfNamesTextArea = new TextArea();

    @Override
    public void start(Stage primaryStage)
    {
        MenuBar menuBar = createMainMenuBar(primaryStage);
        VBox program = new VBox(menuBar);

        HBox hBox = new HBox(listOfNamesTextArea);

        program.getChildren().add(hBox);

        Scene scene = new Scene(program, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private MenuBar createMainMenuBar(Stage primaryStage)
    {
        // Menus (File and Help)
        Menu fileMenu = new Menu("File");
        Menu helpMenu = new Menu("Help");

        // Menu Dropdowns(File -> Open & Exit; Help -> About)
        MenuItem openButton = new MenuItem("Open");
        MenuItem exitButton = new MenuItem("Exit");
        MenuItem aboutButton = new MenuItem("About");

        // Set callbacks
        setOpenButtonCallback(openButton,primaryStage);
        setExitButtonCallback(exitButton);
        setAboutButtonCallback(aboutButton);

        MenuBar menuBar = new MenuBar();

        fileMenu.getItems().add(openButton);
        fileMenu.getItems().add(exitButton);

        helpMenu.getItems().add(aboutButton);

        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(helpMenu);

        return  menuBar;
    }

    private String readAllFile(File file) throws IOException
    {
        String allFileText = "";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null)
        {
            allFileText += line + "\n";
        }
        return allFileText;
    }

    private void setOpenButtonCallback(MenuItem openButton, Stage primaryStage)
    {
        openButton.setOnAction(e ->
        {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File inputFile = fileChooser.showOpenDialog(primaryStage);
            String text = null;
            try
            {
                text = readAllFile(inputFile);
            }
            catch (IOException ex)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid input");
                alert.setHeaderText("Couldn't read file or file is missing");
                alert.setContentText("Please try again with a different file");
                alert.showAndWait();
            }
            if(listOfNamesTextArea.getText().length() > 0)
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Overwrite text");
                alert.setHeaderText("Text is already present in the text box");
                alert.setContentText("Do you want to overwrite it?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get() == ButtonType.OK)
                {
                    listOfNamesTextArea.setText(text);
                }
            }
            else
            {
                listOfNamesTextArea.setText(text);
            }
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
            alert.setHeaderText("List Shuffler");
            alert.setContentText("Lorenzo Schwertner Kaufmann\n2019");
            alert.showAndWait();
        });
    }


}
