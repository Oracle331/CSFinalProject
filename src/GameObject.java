import javafx.scene.shape.Circle;

import java.util.Random;

public class GameObject {

    private static GameObject _object = null;
    private double x, y;
    private double vx, vy;
    private double maxX, maxY;
    private double radius;
    private Circle node;
    private double dt = 0.06;
    private Random random = new Random();
    private double speedCoeficient;
    private boolean alive = true;


    private GameObject() {
    }

    public GameObject(double x, double y, double radius, double vx, double vy) {
        this.x = x;
        this.y = y;
        this.radius = radius;

        this.vx = vx - x;
        this.vy = vy - y;

        node = new Circle(x, y, radius);
    }

    /**
     * Constructor used for player.
     *
     * @param x
     * @param y
     * @param radius
     */
    public GameObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        node = new Circle(x, y, radius);


    }

    static GameObject getInstance() {
        if (_object == null) {
            _object = new GameObject();
        }

        return _object;
    }

    static void setProperties() {
        //Do stuff to set its properties.
    }

    public Circle getGraphic() {
        return node;
    }

    public void setBoundary(double x, double y) {
        this.maxX = x;
        this.maxY = y;
    }

    public void move() {

        x = x + speedCoeficient / 2 * vx * dt;
        y = y + speedCoeficient / 2 * vy * dt;

        node.setCenterX(x);
        node.setCenterY(y);

    }

    public boolean isOutOfBounds() {
        return (x - radius <= -50 || x + radius >= maxX + 50) || (y - radius <= -50 || y + radius >= maxY + 50);
    }


}
