import processing.core.PApplet;
import processing.core.PVector;

public class Golem extends Enemy {
    PApplet p;


    Golem(float xPos, float yPos, PVector playerPosition, PApplet p, Player player,ImageLoader imgLoad) {
        super(xPos, yPos, 2,200,350, playerPosition, p, player,imgLoad);
        img = imgLoad.cheeseGolem ;
        drop = Items.pizzaTopping;
    }




}
