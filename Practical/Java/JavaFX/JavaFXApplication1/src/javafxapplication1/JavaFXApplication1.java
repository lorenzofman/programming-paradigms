package javafxapplication1;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;




// Exemplo em JavaFX com tratamento de evento associado a um objeto da classe Button
// Ver mais sobre classes anonimas em:
// https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html


public class JavaFXApplication1 extends Application {
   public static void main(String[] args) 
   {
      launch(args);
   }
   int index;
   private Image shownImage;
   private Stage stage;
   private HBox hb;
   private ImageView imageView;
   private Button leftButton;
   private Button rightButton;
   private ArrayList<Image> images;
   @Override
   public void start(Stage stage) {
        this.stage = stage;
        images = LoadImages();
        CreateHorizontalBox();
        shownImage = images.get(0);
        imageView = new ImageView(shownImage);
        CreateButtons();
        PopulateHBox();
        stage.setScene(new Scene(hb, 300, 250));
        stage.show();
   }
   
   private void CreateHorizontalBox()
   {
        hb = new HBox();
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);
   }
   
   private void CreateButtons()
   {
        leftButton = new Button();
        leftButton.setOnAction(event -> ButtonAction(event, true));
        
        rightButton = new Button();
        rightButton.setOnAction(event -> ButtonAction(event, false));
   }
   
   private void ButtonAction(Event event, boolean left)
   {
       if(left)
       {
           index--;
       }
       else
       {
           index++;
       }
       shownImage = images.get(Math.floorMod(index, (images.size() - 1)));
       imageView.setImage(shownImage);
   }
   
   private void PopulateHBox()
   {
       hb.getChildren().add(leftButton);
       hb.getChildren().add(imageView);
       hb.getChildren().add(rightButton);
   }
   
   private ArrayList<Image> LoadImages()
   {
       ArrayList<Image> list = new ArrayList<>();
       list.add(new Image("selva.png"));
       list.add(new Image("acacia.png"));
       list.add(new Image("carvalho.png"));
       list.add(new Image("carvalhoescuro.png"));
       list.add(new Image("eucalipto.png"));
       list.add(new Image("pinheiro.png"));
       return list;
   }
}

