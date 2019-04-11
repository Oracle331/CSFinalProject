// Introducing Tatooine to the player
//

import java.util.Timer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class Tatooine extends Application {
    private Stage title = new Stage();
    private StackPane window = new StackPane();
    private Text logo = new Text("You're surrounded by an endless desert.\nYou notice the tracks from a sandcrawler blow into the wind \nas a group of Jawa's move out from behind a rock.\n What would you like to do?");

    public Tatooine() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(final Stage primaryStage) {

        desert1 des = new desert1();
        approachJawa init = new approachJawa();

        title = primaryStage;
        Scene background = new Scene(this.window, 1200, 800);
        ImageView i = new ImageView("tatoonie1.png");
        i.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        i.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        window.getChildren().add(i);
        logo.setFont(Font.loadFont("file:src/Roboto-Regular.TTF", 40));
        logo.setFill(Color.WHITE);
        logo.setTextAlignment(TextAlignment.CENTER);
        window.getChildren().add(this.logo);
        title.setTitle("Star Wars: Text Adventure - Tatooine");
        primaryStage.setScene(background);
        primaryStage.show();
        title.show();
        new StackPane();
        new StackPane();
        new StackPane();
        final Button but1 = new Button("Approach \nJawas");
        Button but2 = new Button("Attack \nJawas");
        final Button but3 = new Button("Run \naway");
        but1.setStyle("-fx-background-color: #a50000; ");
        but1.setFont(Font.font("Courier New", 40));
        but2.setFont(Font.font("Courier New", 40));
        but3.setFont(Font.font("Courier New", 40));
        but2.setStyle("-fx-background-color: #a50000; ");
        but3.setStyle("-fx-background-color: #a50000; ");
        but1.setStyle("-fx-text-fill: #a50000");
        but2.setStyle("-fx-text-fill: #a50000");
        but3.setStyle("-fx-text-fill: #a50000");
        HBox but = new HBox();
        but.setSpacing(125);
        but.setAlignment(Pos.BOTTOM_CENTER);
        but.getChildren().add(but1);
        but.getChildren().add(but2);
        but.getChildren().add(but3);
        window.getChildren().add(but);
        but1.setOnAction(e -> {
            FadeTransition ft = new FadeTransition(Duration.millis(2000), logo);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setCycleCount(1);
            ft.play();
            but1.setDisable(true);
            but1.setVisible(false);
            init.start(primaryStage);
        });
        but3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                FadeTransition ft = new FadeTransition(Duration.millis(2000), logo);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setCycleCount(1);
                ft.play();
                but3.setDisable(true);
                but3.setVisible(false);
                des.start(primaryStage);
            }
        });
    }
}
