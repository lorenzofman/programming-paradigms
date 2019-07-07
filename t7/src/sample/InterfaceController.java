package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class InterfaceController {

    private MenuBar bar = new MenuBar();
    private Stage stage;
    private VBox vbox = new VBox();
    private ObservableList<Commit> commits = FXCollections.observableArrayList();

    public void idleDisplay(Stage stage, CallbacksController callbacks)
    {
        this.stage = stage;
        createMenuItems(callbacks);
        TableView<Commit> tableView = new TableView<>();
        TableColumn repoUrl = new TableColumn("URL");
        repoUrl.setCellValueFactory(new PropertyValueFactory<Commit, String>("link"));
        TableColumn commitsCount = new TableColumn("Commits");
        commitsCount.setCellValueFactory(new PropertyValueFactory<Commit, String>("commitCount"));
        TableColumn commitsLength = new TableColumn("Total Length");
        tableView.getColumns().addAll(repoUrl, commitsCount, commitsLength);
        commitsLength.setCellValueFactory(new PropertyValueFactory<Commit, String>("totalLength"));
        tableView.setItems(commits);
        vbox.getChildren().add(bar);
        vbox.getChildren().add(tableView);
        stage.setScene(new Scene(vbox, 600, 480));
        stage.show();
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

    public void addLabelToTable(Commit info)
    {
        commits.add(info);
    }


    private void createMenuItems(CallbacksController callbacks)
    {
        Menu fileMenu = new Menu("File");
        Menu toolsMenu = new Menu("Tools");
        Menu helpMenu = new Menu("Help");
        MenuItem openItem = new MenuItem("Open");
        openItem.setOnAction(e -> {
            try {
                callbacks.onOpen();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        MenuItem quitItem = new MenuItem("Quit");
        quitItem.setOnAction(e -> callbacks.onExit());

        MenuItem commitItem = new MenuItem("Commit Analyzer");
        commitItem.setOnAction(e -> { callbacks.onCommitAnalyze(); });

        MenuItem aboutItem = new MenuItem("About");
        aboutItem.setOnAction(e -> callbacks.onAbout());

        fileMenu.getItems().add(openItem);
        fileMenu.getItems().add(quitItem);

        toolsMenu.getItems().add(commitItem);

        helpMenu.getItems().add(aboutItem);

        bar.getMenus().add(fileMenu);
        bar.getMenus().add(toolsMenu);
        bar.getMenus().add(helpMenu);

    }

}
