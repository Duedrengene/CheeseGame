import processing.core.PApplet;
import processing.core.PVector;

public class CheeseDemon extends Enemy {

    PApplet p;


    CheeseDemon(float xPos, float yPos,  PVector playerPosition, PApplet p, Player player,ImageLoader imgLoad) {
        super(xPos, yPos, 4,100,600, playerPosition, p, player,imgLoad);
        img = imgLoad.cheeseDemon;
        drop = Items.cheddar;

    }
}
