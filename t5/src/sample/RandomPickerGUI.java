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
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class RandomPickerGUI extends Application
{
    private TextArea listOfNamesTextArea = new TextArea();
    private ArrayList<String> shuffledList = new ArrayList<>();
    private int index = 0;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        MenuBar menuBar = createMainMenuBar(primaryStage);
        VBox program = new VBox(menuBar);

        HBox hBox = new HBox(listOfNamesTextArea);
        Label label = new Label();
        hBox.getChildren().add(label);

        program.getChildren().add(hBox);

        Button shuffleButton = new Button("Shuffle");
        Button nextButton = new Button("Next");
        nextButton.setDisable(true);
        shuffleButton.setOnAction(e ->
        {
            shuffleButton.setDisable(true);
            nextButton.setDisable(false);
            ArrayList<String> originalList = readListFromTextArea();
            index = 0;
            try
            {
                shuffledList = new ShufflerController<String>().Shuffle(originalList);
            }
            catch (Exception ex)
            {
                showErrorDialog("Couldn't shuffle","Unknown runtime error", ex.getMessage());
            }

        });
        nextButton.setOnAction(e->
        {
            if(index < shuffledList.size())
            {
                label.setText(label.getText() + shuffledList.get(index++) + "\n");
            }
            else
            {
                nextButton.setDisable(true);
                shuffleButton.setDisable(false);
            }
        });


        HBox buttons = new HBox(shuffleButton);
        buttons.getChildren().add(nextButton);
        program.getChildren().add(buttons);
        Scene scene = new Scene(program, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ArrayList<String> readListFromTextArea()
    {
        ArrayList<String> listOfNames = new ArrayList<>();
        Scanner sc = new Scanner(listOfNamesTextArea.getText());
        while (sc.hasNextLine())
        {
            listOfNames.add(sc.nextLine());
        }
        return listOfNames;
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
            if(inputFile == null)
            {
                return;
            }
            String text = null;
            try
            {
                text = readAllFile(inputFile);
            }
            catch (IOException ex)
            {
                showErrorDialog("Invalid input","Couldn't read file or file is missing", ex.getMessage());
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

    private void showErrorDialog(String title, String header, String content)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
