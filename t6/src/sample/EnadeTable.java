package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class EnadeTable
{
    private final String[] columnNames = {"Ano", "Prova","Tipo Questão","Id Questão","Objeto","Acertos Curso","Acertos Região","Acertos Brasil","Dif"};
    private final String[] attributesNames = {"year", "testType","questionType","id","object","courseRightQuestions","regionRightQuestions","countryRightQuestions","dif"};
    ObservableList<Question> list = null;
    public VBox createFXTable() throws IOException
    {
        Label label = new Label("ENADE");
        TableView table = new TableView();
        CSVReader csvStream = CSVFetcher.FetchCSV(false);
        ArrayList<TableColumn> columns = new ArrayList<>();
        for(int i = 0; i < columnNames.length; i++)
        {
            TableColumn column = new TableColumn(columnNames[i]);
            column.setCellValueFactory(
                    new PropertyValueFactory<Question,String>(attributesNames[i]));
            columns.add(column);
        }
        ArrayList<Question> data = new ArrayList<>();
        // Skip header
        for(int i = 1; i < csvStream.records.size(); i++)
        {
            data.add(CreateQuestionFromRecord(csvStream.records.get(i)));
        }
        list = FXCollections.observableArrayList(data);
        table.setItems(list);
        table.getColumns().addAll(columns);
        table.setRowFactory(tv ->
        {
            TableRow<Question> row = new TableRow<>();
            row.setOnMouseClicked(event ->
            {
                Question clickedRow = row.getItem();
                QuestionWindow.Create(clickedRow);
            });
            return row;
        });


        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, table);
        return vbox;
    }

    private Question CreateQuestionFromRecord(String[] strings)
    {
        return new Question(strings[1], strings[2], strings[3], strings[4], strings[5], strings[8], strings[9], strings[10], strings[11], strings.length == 18 ? strings[17] : null, strings[7]);
    }

    public void updateFXTable() throws IOException
    {
        ArrayList<Question> data = new ArrayList<>();
        CSVReader csvStream = CSVFetcher.FetchCSV(true);
        for(int i = 1; i < csvStream.records.size(); i++)
        {
            data.add(CreateQuestionFromRecord(csvStream.records.get(i)));
        }
        list.setAll(data);
    }
}
