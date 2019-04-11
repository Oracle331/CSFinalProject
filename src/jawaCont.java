//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Timer;
import javafx.application.Application;
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

public class jawaCont extends Application {
    private Stage title = new Stage();
    private StackPane window = new StackPane();
    private Text logo = new Text("You hear the sounds of fighting \nin the far distance");

    public jawaCont() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        new Timer();
        this.title = primaryStage;
        Scene background = new Scene(this.window, 1200.0D, 800.0D);
        ImageView i = new ImageView("tatPNG.png");
        i.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
        i.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
        this.window.getChildren().add(i);
        this.logo.setFont(Font.loadFont("file:src/Roboto-Regular.TTF", 40.0D));
        this.logo.setFill(Color.WHITE);
        this.logo.setTextAlignment(TextAlignment.CENTER);
        this.window.getChildren().add(this.logo);
        this.title.setTitle("Stage 1");
        primaryStage.setScene(background);
        primaryStage.show();
        this.title.show();
        new StackPane();
        new StackPane();
        new StackPane();
        Button but1 = new Button("Go towards \nthe sounds");
        Button but2 = new Button("Turn around");
        but1.setStyle("-fx-background-color: #a50000; ");
        but1.setFont(Font.font("Courier New", 40.0D));
        but2.setFont(Font.font("Courier New", 40.0D));
        but2.setStyle("-fx-background-color: #a50000; ");
        but1.setStyle("-fx-text-fill: #a50000");
        but2.setStyle("-fx-text-fill: #a50000");
        HBox but = new HBox();
        but.setSpacing(125.0D);
        but.setAlignment(Pos.BOTTOM_CENTER);
        but.getChildren().add(but1);
        but.getChildren().add(but2);
        this.window.getChildren().add(but);
    }
}
