import processing.core.PApplet;
import processing.core.PVector;

public class CheeseDemon extends Enemy {

    PApplet p;


    CheeseDemon(float xPos, float yPos, int hastighed, int DIAMETER, PVector playerPosition, PApplet p, Player player) {
        super(xPos, yPos, hastighed, DIAMETER, playerPosition, p, player);
        img = p.loadImage("cheesedemon.png") ;
        drop = Items.pizzaTopping;

    }
}
