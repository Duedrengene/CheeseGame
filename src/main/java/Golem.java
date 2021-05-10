import processing.core.PApplet;
import processing.core.PVector;

public class Golem extends Enemy {
    PApplet p;


    Golem(float xPos, float yPos, int hastighed, int DIAMETER, PVector playerPosition, PApplet p, Player player) {
        super(xPos, yPos, hastighed, DIAMETER, playerPosition, p, player);
    }




}
