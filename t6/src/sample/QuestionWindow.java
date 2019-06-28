package sample;

import javafx.stage.Modality;
import javafx.stage.Stage;

public class QuestionWindow
{
    public static void Create(Question question)
    {
        Stage newWindow = new Stage();
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.show();
    }

}
