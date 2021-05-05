import processing.core.PApplet;
import processing.core.PImage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Furniture {

PImage img;

     Furniture(){


     }

     Furniture(PImage img){
          this.img = img;

     }

     void display(PApplet p,float x,float y){
     p.image(img,x,y);


     };
     void function(){


     };
     void playerNearby(){


     };
}
