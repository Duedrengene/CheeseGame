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


     }
     void function(Main m){


     }
     float playerNearby(Player player,float x,float y){
         float distance = -1;

          float distanceX = player.position.x - x;
          float distanceY = player.position.y - y;
          float  distanceTemp = (float)Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
          if(distanceTemp <=75)
               distance = distanceTemp;
          return distance;
     }
}
