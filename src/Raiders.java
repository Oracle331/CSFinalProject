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

import java.util.Timer;

import static javafx.application.Application.launch;

public class Raiders extends Application{

        private Stage title = new Stage();
        private StackPane window = new StackPane();
        private Text logo = new Text("As you approach you see a group \nof tuskan raiders surrounding a few humans \n with their weapons drawn. \nThe humans appear to be in danger.");
    public Raiders(){}


        public static void main(String[] args) {
            launch(args);

        }

        public void start(Stage primaryStage) {

        desert2 des = new desert2();
        new Timer();
            title = primaryStage;
            Scene background = new Scene(this.window, 1200.0D, 800.0D);
            ImageView i = new ImageView("tat3.jpg");
            i.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
            i.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
            window.getChildren().add(i);
            logo.setFont(Font.loadFont("file:src/Roboto-Regular.TTF", 40.0D));
            logo.setFill(Color.WHITE);
            logo.setTextAlignment(TextAlignment.CENTER);
            window.getChildren().add(this.logo);
            title.setTitle("Stage 1");

            Image jawa = new Image("tusken.png");

            HBox j = new HBox();
            j.getChildren().add(new ImageView(jawa));
            window.getChildren().add(j);
            j.setAlignment(Pos.CENTER_RIGHT);

            Image ja = new Image("tusken.png");

            HBox jaw = new HBox();
            jaw.getChildren().add(new ImageView(ja));
            window.getChildren().add(jaw);
            jaw.setAlignment(Pos.CENTER_LEFT);


            primaryStage.setScene(background);
            primaryStage.show();
            title.show();
            new StackPane();
            new StackPane();
            new StackPane();
            Button but1 = new Button("Join the fight!");
            Button but2 = new Button("Run away in fear");
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
            window.getChildren().add(but);

           //action for running away....--> goes to empty desert
            but2.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    FadeTransition ft = new FadeTransition(Duration.millis(2000), logo);
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setCycleCount(1);
                    ft.play();
                    but1.setDisable(true);
                    but1.setVisible(false);
                    des.start(primaryStage);
                }
            });

            //action for fighting needs to be added

        }
    }
