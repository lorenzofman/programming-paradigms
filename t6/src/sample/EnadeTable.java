package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class EnadeTable
{
    private final String[] columnNames = {"Ano", "Prova","Tipo Questão","Id Questão","Objeto","Acertos Curso","Acertos Região","Acertos Brasil","Dif"};
                              /* B, C, D, E, F, I, J, K e L */
    private final int[] index = {1, 2, 3, 4, 5, 8, 9, 10, 11};
    public Scene CreateFXTable() throws FileNotFoundException
    {
        Label label = new Label("TableView Example");
        TableView table = new TableView();
        CSVStream csvStream = new CSVStream(new File("enade.csv"));

        TableColumn[] columns = new TableColumn[columnNames.length];
        for(int i = 0; i < columns.length; i++)
        {
            columns[i] = new TableColumn(columnNames[i]);
        }

        table.getColumns().addAll(columns);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, table);
        return new Scene(vbox,180,400);
    }


}
