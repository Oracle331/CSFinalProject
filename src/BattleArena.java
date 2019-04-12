import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;

public class BattleArena extends Application {

    public int enemyHealth, charHealth;
    public Inventory inventory = new Inventory();
    private int dmg, enemyDmg, crit = 0;
    public String enemyName;
    public Text dialogue = new Text(), action, response, updateHealth, cont;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage pStage) {

        Pane root = new Pane();
        Stage primaryStage;
        primaryStage = pStage;
        Timer timer = new Timer();
        VBox fight = new VBox();



        Scene s = new Scene(root, 1200, 800);
        primaryStage.setTitle("Fight!");

        Image jawa = new Image("jawa1.png");
        fight.getChildren().add(new ImageView(jawa));

        battle();
        dialogue.setFont(Font.font("Courier New", 75));

        fight.getChildren().add(dialogue);


        primaryStage.setScene(s);
        primaryStage.show();
        //Cast the new object from getInstance in the GameObject Class
        //Add the object into the pane

//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//
//            }
//        }, 500, 60);


        primaryStage.requestFocus();
    }
    public void setEnemy(String name){
        enemyName = name;
    }
    public int blaster(){

        // Random chance for shot to miss
        Random rand = new Random();
        int hit = rand.nextInt(5) + 1;

        // Range of potential damage
        dmg = rand.nextInt(5) + 3;

        // droids can't aim
        if(inventory.check("d"))
            hit--;

        if(hit <= 1)
            dmg = 0;

        return dmg;
    }
    public int saber(){
        Random rand = new Random();
        int hit = rand.nextInt(3)+1;

        dmg = hit * rand.nextInt(5) + 3;

        return dmg;
    }
    public int easyEnemy(){
        crit++;
        if(crit == 4) {
            crit = 0;
            return 5;
        }
        return 2;
    }
    public void battle(){


        //Scanner sc = new Scanner(System.in);
        //Text action, response, updateHealth, cont;

        do{

            if(inventory.check("blaster"))
                dmg = blaster();
            else if(inventory.check("saber"))
                dmg = saber();
            else
                dialogue = new Text("Only a fool goes into battle without a weapon");

            if (dmg > 0) {
                action = new Text("You did " + dmg + " damage. The enemy prepares to strike");
                enemyHealth -= dmg;

            } else if(dmg == 0) {
                action = new Text("Your shot missed!");
            }
            enemyDmg = easyEnemy();
            response = new Text("The enemy throws a rock at your big dumb head for " + enemyDmg + " damage.");
            charHealth -= enemyDmg;
            if(enemyHealth > 0)
                updateHealth = new Text("The enemy has " + enemyHealth + " charHealth remaining");
            else
                updateHealth = new Text("The enemy has no charHealth remaining");

//            if(charHealth < 20 && enemyHealth > 0){
//                cont = new Text("Do you wish to continue this fight? y/n");
//
//                if(cont.equals("n"))
//                    break;
//            }
        }while(enemyHealth > 1 && charHealth > 1);
        if(charHealth < 1) {
            updateHealth = new Text("How did you get killed by a " + enemyName + " Maybe you shouldn't play this game.");
            System.exit(0);
        }
        //System.out.println("You have " + charHealth + " charHealth left.");

    }


}
