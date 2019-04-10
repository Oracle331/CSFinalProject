import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
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
        StackPane menu = new StackPane();



        Scene charSelect = new Scene(menu, 1200, 800);
        menu.getChildren().add(new ImageView(image));


        Image d = new Image(getClass().getResourceAsStream("droid.png"));
        Image j = new Image(getClass().getResourceAsStream("jedi.png"));
        Image s = new Image(getClass().getResourceAsStream("han.gif"));

        Text choose = new Text("Choose your character:");
        choose.setStyle("-fx-text-fill: #ffffff");
        menu.getChildren().add(choose);

        Button droid = new Button("",new ImageView(d));
        Button shoot = new Button("",new ImageView(s));
        Button jedi = new Button("",new ImageView(j));

        characters.setSpacing(125);

        droid.setMaxSize(320,300);
        droid.setMinSize(320,300);
//        droid.setPrefSize(100,100);
//        shoot.setPrefSize(100,100);
//        jedi.setPrefSize(100,100);
        shoot.setMaxSize(320,300);
        shoot.setMinSize(320,300);
        jedi.setMinSize(320,300);
        jedi.setMaxSize(320,300);

        droid.setStyle("-fx-background-color: transparent; ");
        shoot.setStyle("-fx-background-color: transparent; ");
        jedi.setStyle("-fx-background-color: transparent; ");

//        droid.setAlignment(Pos.BOTTOM_LEFT);
//        shoot.setAlignment(Pos.BOTTOM_CENTER);
//        jedi.setAlignment(Pos.BOTTOM_RIGHT);

        //characters.autosize();
        //characters.getChildren().add(bg);

        characters.getChildren().add(droid);
        characters.getChildren().add(jedi);
        characters.getChildren().add(shoot);

        characters.setAlignment(Pos.CENTER);

        menu.getChildren().add(characters);

        primaryStage.setScene(charSelect);
        primaryStage.show(); // for testing
    }
}
