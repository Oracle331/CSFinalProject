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

import java.util.Timer;

public class desert2 extends Application{


    private Stage title = new Stage();
    private StackPane window = new StackPane();
    private Text logo = new Text("There's nothing here \nbut the vast empty desert");

    public desert2() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(final Stage primaryStage) {
        Raiders raid = new Raiders();
        new Timer();
        title = primaryStage;
        Scene background = new Scene(this.window, 1200.0D, 800.0D);
        ImageView i = new ImageView("des1.png");
        i.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        i.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        window.getChildren().add(i);
        logo.setFont(Font.font("Courier New", 40));
        logo.setFill(Color.DARKBLUE);
        logo.setTextAlignment(TextAlignment.CENTER);
        window.getChildren().add(this.logo);
        title.setTitle("Star Wars: Text Adventure - Tatooine");
        primaryStage.setScene(background);
        primaryStage.show();
        title.show();
        new StackPane();
        new StackPane();
        new StackPane();
        final Button but1 = new Button("Keep Exploring");
        but1.setStyle("-fx-background-color: #a50000; ");
        but1.setFont(Font.font("Courier New", 40.0D));
        but1.setStyle("-fx-text-fill: #a50000");
        HBox but = new HBox();
        but.setSpacing(125.0D);
        but.setAlignment(Pos.BOTTOM_CENTER);
        but.getChildren().add(but1);
        window.getChildren().add(but);
        but1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                FadeTransition ft = new FadeTransition(Duration.millis(2000.0D), desert2.this.logo);
                ft.setFromValue(1.0D);
                ft.setToValue(0.0D);
                ft.setCycleCount(1);
                ft.play();
                but1.setDisable(true);
                but1.setVisible(false);
                raid.start(primaryStage);
            }
        });
    }
}