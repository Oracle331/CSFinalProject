import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CreateACharacter extends Application {


    public static void CreateACharacter(){

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox characters = new HBox();
        Image image = new Image("space.jpg");



        Scene charSelect = new Scene(characters, 1200, 800);
        //characters.getChildren().add(new ImageView(image));
        Image d = new Image(getClass().getResourceAsStream("droid.png"));
        Image m = new Image(getClass().getResourceAsStream("medic.png"));
        Image j = new Image(getClass().getResourceAsStream("jedi.png"));
        Image s = new Image(getClass().getResourceAsStream("han.gif"));


        Button medic = new Button("",new ImageView(m));
        Button droid = new Button("",new ImageView(d));
        Button shoot = new Button("",new ImageView(s));
        Button jedi = new Button("",new ImageView(j));

        characters.autosize();
        characters.getChildren().add(medic);
        characters.getChildren().add(droid);
        characters.getChildren().add(jedi);
        characters.getChildren().add(shoot);

        primaryStage.setScene(charSelect);
    }
}
