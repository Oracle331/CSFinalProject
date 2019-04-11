//
// Initial interaction with first NPC, Jawa's
//
//

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class approachJawa extends Application {
    private Stage title = new Stage();
    private StackPane window = new StackPane();
    private Text dialogue = new Text("\"Utinni! Utinni\" \n The Jawa is \nsurprised to see you!");
    jawaCont nextStage = new jawaCont();

    public approachJawa() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(final Stage primaryStage) {
        Inventory inv = new Inventory();
        title = primaryStage;
        Scene background = new Scene(window, 1200, 800);

        ImageView i = new ImageView("tatoonie1.png");
        i.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        i.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        Image jawa = new Image("jawa1.png");
        window.getChildren().add(i);

        HBox jPos = new HBox();
        jPos.getChildren().add(new ImageView(jawa));
        window.getChildren().add(jPos);
        jPos.setAlignment(Pos.CENTER_RIGHT);

        dialogue.setFont(Font.loadFont("file:src/Roboto-Regular.TTF", 100));
        dialogue.setFill(Color.WHITE);
        dialogue.setTextAlignment(TextAlignment.CENTER);
        window.getChildren().add(dialogue);

        title.setTitle("Star Wars: Text Adventure - Tatooine");
        primaryStage.setScene(background);
        primaryStage.show();
        title.show();

        Button contBut = new Button("Continue");
        contBut.setStyle("-fx-background-color: #a50000; ");
        contBut.setFont(Font.font("Courier New", 40));
        contBut.setStyle("-fx-text-fill: #a50000");

        HBox but = new HBox();
        but.setSpacing(125);
        but.setAlignment(Pos.BOTTOM_CENTER);
        but.getChildren().add(contBut);
        window.getChildren().add(but);

        contBut.setOnAction(e ->  {
            Text dialogueOne = new Text("\"Etee uwanna waa.\"");
            dialogue.setVisible(false);
            window.getChildren().add(dialogueOne);
            //if (inv.check("d"))

            //else
           //     System.out.println("They gesture towards some junk on the sand crawler, implying they want to trade.");
            contBut.setDisable(true);
            contBut.setVisible(false);
            nextStage.start(primaryStage);
        });
    }

}
