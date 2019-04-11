import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class BattleArena extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();

        Timer timer = new Timer();

        //Cast the new object from getInstance in the GameObject Class
        //Add the object into the pane

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 500, 60);


        primaryStage.requestFocus();
    }


}
