import processing.core.PApplet;
import processing.core.PVector;

public class Golem extends Enemy {
    PApplet p;


    Golem(float xPos, float yPos, float hastighed, int DIAMETER, PVector playerPosition, PApplet p, Player player) {
        super(xPos, yPos, hastighed*0.75f, DIAMETER, playerPosition, p, player);
        img = p.loadImage("cheesemob.png") ;
        drop = Items.primadonna;
    }




}
