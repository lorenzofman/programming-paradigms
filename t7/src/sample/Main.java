package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        InterfaceController viewer = new InterfaceController();
        viewer.idleDisplay(primaryStage, new CallbacksController(viewer));

    }


    public static void main(String[] args) {
        launch(args);
    }
}
