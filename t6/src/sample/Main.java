package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application
{
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException
    {
        Main.stage = stage;
        EnadeTable table = new EnadeTable();
        stage.setScene(table.createFXTable());
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
