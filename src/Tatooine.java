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
    private Text logo = new Text("You're surrounded by an endless desert.\nYou notice the tracks from a \nsandcrawler blow into the wind as a group \nof Jawa's move out from behind a rock.\n What would you like to do?");

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
        logo.setFont(Font.font("Courier New", 40));
        logo.setFill(Color.WHITE);
        logo.setTextAlignment(TextAlignment.CENTER);
        window.getChildren().add(this.logo);
        title.setTitle("Star Wars: Text Adventure - Tatooine");
        primaryStage.setScene(background);
        primaryStage.show();
        title.show();

        Button approach = new Button("Approach \nJawas");
        Button attack = new Button("Attack \nJawas");
        Button run = new Button("Run \naway");

        approach.setStyle("-fx-background-color: #a50000; ");
        approach.setFont(Font.font("Courier New", 40));
        attack.setFont(Font.font("Courier New", 40));
        run.setFont(Font.font("Courier New", 40));
        attack.setStyle("-fx-background-color: #a50000; ");
        run.setStyle("-fx-background-color: #a50000; ");
        approach.setStyle("-fx-text-fill: #a50000");
        attack.setStyle("-fx-text-fill: #a50000");
        run.setStyle("-fx-text-fill: #a50000");

        HBox but = new HBox();
        but.setSpacing(125);
        but.setAlignment(Pos.BOTTOM_CENTER);

        but.getChildren().add(approach);
        but.getChildren().add(attack);
        but.getChildren().add(run);

        window.getChildren().add(but);
        approach.setOnAction(e -> {
            FadeTransition ft = new FadeTransition(Duration.millis(2000), logo);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setCycleCount(1);
            ft.play();
            approach.setDisable(true);
            approach.setVisible(false);
            init.start(primaryStage);
        });
        run.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                FadeTransition ft = new FadeTransition(Duration.millis(2000), logo);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setCycleCount(1);
                ft.play();
                run.setDisable(true);
                run.setVisible(false);
                init.start(primaryStage); // for demo
                //des.start(primaryStage);
            }
        });
        attack.setOnAction(e -> {
            BattleArena fight = new BattleArena();
            fight.setEnemy("Jawa");
            init.attack(true);
            init.start(primaryStage);
            //fight.start(primaryStage);
        });
    }
}
