import processing.core.PApplet;
import processing.core.PImage;
public class ImageLoader {
    //Backgrounds
    PImage cave;
    PImage startup;




    //items  models.
    PApplet p;
    PImage parmesan;
    PImage cheddar;
    PImage primadonna;
    PImage pizzatopping;

    //Player models
    PImage npcmale;
    PImage captaincheese;
    PImage enemy;
    PImage cheeseGolem;
    PImage cheeseDemon;
    PImage grimReaper;


    //only player
    PImage behindplayer;
    PImage leftsideplayer;
    PImage rightsideplayer;
    PImage forward1;
    PImage forward2;

	
    //Furniture

    PImage wall;
    PImage door;
    PImage shopCounter;
    PImage cashRegister;
    PImage pillar;


    float scaleW = 1;
    float scaleH = 1;

    ImageLoader(PApplet p) { this.p = p;}



    void loadTheImages() {

/// Hvis resize(skulle importeres).
        //scaleH = (float) w/1920;
        //scaleW = (float) h/1080;

//Structure
        wall= p.loadImage("wall.png");
        door = p.loadImage("door.png");
        shopCounter = p.loadImage("shopCounter.png");
        cashRegister = p.loadImage("cashRegister.png");
        pillar = p.loadImage("Pillar.png");


        //Loaditemsmodel
        pizzatopping = p.loadImage("pizza topping.png");
        cheddar = p.loadImage("cheddar.png");
        primadonna = p.loadImage("Primadonna-export.png");
        //Characters & Mobs
        captaincheese = p.loadImage("Kaptajn Ost.png");
        cheeseGolem = p.loadImage("cheesemob.png");
        cheeseDemon = p.loadImage("cheesedemon.png");
        //Backgrounds

//Player
        behindplayer = p.loadImage("behindcheeseman.png");
        leftsideplayer = p.loadImage("leftsidecheeseman.png");
        rightsideplayer = p.loadImage("rightsidecheeseman.png");
        forward1 = p.loadImage("Playerforward1.png");
        forward2 = p.loadImage("forwardplayer2.png");

        //Model 3/4 perspective playermodels.
        grimReaper = p.loadImage("GrimR.png");


    }

}
