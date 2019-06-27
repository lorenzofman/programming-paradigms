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

public class Main extends Application {

    @Override
    public void start(Stage stage)
    {
        EnadeTable table = new EnadeTable();
        table.CreateFXTable();
        stage.setScene(table.CreateFXTable());
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
