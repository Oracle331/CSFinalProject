
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;

import static javafx.geometry.Pos.BOTTOM_CENTER;

public class Intro extends Application {
    public Stage title = new Stage();
    public StackPane window = new StackPane();
    public Text logo = new Text("Star Wars:\nText Adventure");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // calling necessary objects
        Timer timer = new Timer(); // initialize a timer
        CreateACharacter init = new CreateACharacter();

        title = primaryStage;

        Scene background = new Scene(window, 1200, 800);
        StackPane pos = new StackPane();
        Image image = new Image("space.jpg");

        window.getChildren().add(new ImageView(image));

        logo.setFont(Font.loadFont("file:src/STJEDISE.TTF", 100));
        logo.setFill(Color.YELLOW);

        logo.setTextAlignment(TextAlignment.CENTER);

        window.getChildren().add(logo);

        title.setTitle("Star Wars: Text Adventure");
        primaryStage.setScene(background);
        primaryStage.show();
        title.show();
        Image start = new Image(getClass().getResourceAsStream("start.png"));
        Button startButton = new Button("",new ImageView(start));
        pos.setAlignment(Pos.BOTTOM_CENTER);

        pos.getChildren().add(startButton);
        window.getChildren().add(pos);

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FadeTransition ft = new FadeTransition(Duration.millis(2000), logo);

                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setCycleCount(1);
                ft.play();
                startButton.setDisable(true);
                startButton.setVisible(false);
                //timer.schedule(() -> init.start(primaryStage), 2*60*1000);

                init.start(primaryStage);

            }

        });






    }
}
