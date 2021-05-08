import processing.core.PApplet;
import processing.core.PImage;
public class ImageLoader {
    //Backgrounds
    PImage cave;
    PImage startup;

    //Animations.
    PImage[] frontImgs = new PImage[2];
    PImage[] behindImgs = new PImage[2];


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
   
    PImage leftsideplayer;
    PImage rightsideplayer;
    PImage forward1;



    //Furniture

    PImage wall;
    PImage door;
    PImage shopCounter;
    PImage cashRegister;
    PImage pillar;
    PImage deathRealm;



    float scaleW = 1;
    float scaleH = 1;

    ImageLoader(PApplet p) {
        this.p = p;
    }


    void loadTheImages() {

/// Hvis resize(skulle importeres).
        //scaleH = (float) w/1920;
        //scaleW = (float) h/1080;

//Structure
        wall = p.loadImage("wall.png");
        door = p.loadImage("door.png");
        shopCounter = p.loadImage("shopCounter.png");
        cashRegister = p.loadImage("cashRegister.png");
        pillar = p.loadImage("Pillar.png");
        deathRealm = p.loadImage("deathrealm.png");


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

        leftsideplayer = p.loadImage("leftsidecheeseman.png");
        rightsideplayer = p.loadImage("rightsidecheeseman.png");

        //Model 3/4 perspective playermodels.
        grimReaper = p.loadImage("GrimR.png");
        forward1 = p.loadImage("forwardplayer1.png");

        for (int i = 1; i <= 2; i++) {
            frontImgs[i-1] = p.loadImage("forwardplayer"+i+".png");
            behindImgs[i-1] = p.loadImage("behindcheeseman"+i+".png");
        }
    }
}
