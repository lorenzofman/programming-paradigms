package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException
    {
        EnadeTable table = new EnadeTable();
        stage.setScene(table.CreateFXTable());
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
