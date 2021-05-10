import processing.core.PApplet;
import processing.core.PImage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Furniture {
    Items itemType = Items.empty;
    PImage itemImg = null;
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

     float playerNearby(Player player,float x,float y,int playerWidth,int playerHeight,float gridWidth,float gridHeight){
         float distance = -1;

          float distanceX = player.position.x+playerWidth/2 - x-gridWidth/2;
          float distanceY = player.position.y+playerHeight/2 - y-gridHeight/2;
          float  distanceTemp = (float)Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
          if(distanceTemp <=75) {
              distance = distanceTemp;

          }
        // System.out.println("このすば"+distanceTemp);

         return distance;
     }
}
