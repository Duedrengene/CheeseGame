import processing.core.PApplet;
import processing.core.PImage;
public class ImageLoader {
    //Bagrounds
    PImage cave;
    PImage startup;




    //items  models.
    PApplet p;
    PImage parmesan;
    PImage cheddar;
    PImage madonna;
    PImage mozarella;

    //Player models
    PImage npcmale;
    PImage captaincheese;
    PImage enemy;

    //Furniture

    PImage wall;
    float scaleW = 1;
    float scaleH = 1;

    ImageLoader(PApplet p) { this.p = p;}

    void loadTheImages(int var, int w, int h) {
        p.loadImage("wall.png");


        scaleH = (float) w/1920;
        scaleW = (float) h/1080;

    }

}
