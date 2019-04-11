//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
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
    private Text logo = new Text("\"Utinni! Utinni\" \n The Jawa is \nsurprised to see you!");
    jawaCont init = new jawaCont();

    public approachJawa() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(final Stage primaryStage) {
        this.title = primaryStage;
        Scene background = new Scene(this.window, 1200.0D, 800.0D);
        ImageView i = new ImageView("tatoonie1.png");
        i.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        i.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        Image jawa = new Image("jawa1.png");
        this.window.getChildren().add(i);
        HBox j = new HBox();
        j.getChildren().add(new ImageView(jawa));
        this.window.getChildren().add(j);
        j.setAlignment(Pos.CENTER_RIGHT);
        this.logo.setFont(Font.loadFont("file:src/Roboto-Regular.TTF", 50.0D));
        this.logo.setFill(Color.WHITE);
        this.logo.setTextAlignment(TextAlignment.CENTER);
        this.window.getChildren().add(this.logo);
        this.title.setTitle("Approaching Jawa");
        primaryStage.setScene(background);
        primaryStage.show();
        this.title.show();
        final Button but1 = new Button("Continue");
        but1.setStyle("-fx-background-color: #a50000; ");
        but1.setFont(Font.font("Courier New", 40.0D));
        but1.setStyle("-fx-text-fill: #a50000");
        HBox but = new HBox();
        but.setSpacing(125.0D);
        but.setAlignment(Pos.BOTTOM_CENTER);
        but.getChildren().add(but1);
        this.window.getChildren().add(but);
        but1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                FadeTransition ft = new FadeTransition(Duration.millis(2000.0D), approachJawa.this.logo);
                ft.setFromValue(1.0D);
                ft.setToValue(0.0D);
                ft.setCycleCount(1);
                ft.play();
                but1.setDisable(true);
                but1.setVisible(false);
                approachJawa.this.init.start(primaryStage);
            }
        });
    }
}
