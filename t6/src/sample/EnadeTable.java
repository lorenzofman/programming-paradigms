package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EnadeTable
{
    public TableView()
    public Scene CreateFXTable()
    {
        Label label = new Label("TableView Example");
        TableView table = new TableView();
        TableColumn fstCol = new TableColumn("A");
        TableColumn sndCol = new TableColumn("B");
        table.getColumns().addAll(fstCol, sndCol);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, table);
        return new Scene(vbox,180,400);
    }


}
