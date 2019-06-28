package sample;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class QuestionWindow
{
    public static void Create(Question question)
    {
        Stage newWindow = new Stage();
        Label year = new Label("Ano:" + question.getYear());
        Label testType = new Label("Prova:" + question.getTestType());
        Label questionType = new Label("Tipo Questão:" + question.getQuestionType());
        Label id = new Label("ID:" + question.getId());
        Label object = new Label("Ano:" + question.getYear());
        Label courseRightQuestions = new Label("Acertos Curso:" + question.getCourseRightQuestions());
        Label regionRightQuestions = new Label("Acertos Região:" + question.getRegionRightQuestions());
        Label countryRightQuestions = new Label("Acertos Brasil:" + question.getCountryRightQuestions());
        Label dif = new Label("Dif:" + question.getDif());
        Label answerKey = new Label("Gabarito:" + question.getAnswerKey());
        VBox vbox = new VBox();
        vbox.getChildren().addAll(year, testType, questionType, id, object, courseRightQuestions, regionRightQuestions, countryRightQuestions, dif, answerKey);
        if(question.getImageUrl() != null)
        {
            Image image = new Image(question.getImageUrl());
            ImageView imageView = new ImageView(image);
            vbox.getChildren().add(imageView);
        }
        newWindow.setScene(new Scene(vbox,512,320));
        newWindow.setTitle("Details");
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.show();
    }

}
