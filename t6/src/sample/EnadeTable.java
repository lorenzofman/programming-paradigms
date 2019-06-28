package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class EnadeTable
{
    private final String[] columnNames = {"Ano", "Prova","Tipo Questão","Id Questão","Objeto","Acertos Curso","Acertos Região","Acertos Brasil","Dif"};

    public Scene CreateFXTable() throws IOException
    {
        Label label = new Label("TableView Example");
        TableView table = new TableView();
        CSVStream csvStream = new CSVStream(new File("enade.csv"));
        ArrayList<TableColumn<Question,String>> columns = new ArrayList<>();
        ArrayList<Question> data = new ArrayList<>();
        for(int i = 0; i < columnNames.length; i++)
        {
            columns.add(new TableColumn<>(columnNames[i]));
        }
        // Skip header
        for(int i = 1; i < csvStream.records.size(); i++)
        {
            data.add(CreateQuestionFromRecord(csvStream.records.get(i)));
        }
        System.out.println(csvStream.records.size());
        ObservableList<Question> list = FXCollections.observableArrayList(data);
        table.setItems(list);
        table.getColumns().addAll(columns);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, table);
        return new Scene(vbox,180,400);
    }

    private Question CreateQuestionFromRecord(String[] strings)
    {
        //                              /* B, C, D, E, F, I, J, K e L */
        //    private final int[] index = {1, 2, 3, 4, 5, 8, 9, 10, 11};
        return new Question(
                strings[1],
                strings[2],
                strings[3],
                strings[4],
                strings[5],
                strings[8],
                strings[9],
                strings[10],
                strings[11]
                );

    }


}
