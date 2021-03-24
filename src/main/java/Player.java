import processing.core.PApplet;
import processing.core.PVector;

import static processing.core.PConstants.*;

public class Player {


    PVector position = new PVector();
    PVector velocity = new PVector();


boolean showAim = false;

    PApplet p;
    int playerWidth = 10;
    int playerHeight=10;
    boolean down,up,left,right = false;
    boolean ready = true;

    Player(PApplet p){
        this.p = p;


        position.set(100,this.p.height/2);

    }


    void changePosition(){

        position.add(velocity);
        position.x =p.constrain(position.x,0,p.width-playerWidth);
        position.y=  p.constrain(position.y,0,p.height-playerHeight);
    }
   void setVolicityaim(){
        if(showAim == true);
        p.stroke(255,0,0,180);
        p.strokeWeight(3);
p.line(p.mouseX,p.mouseY,position.x,position.y);
   }

    void draw(){

        changePosition();
        //if(level ==1) {
            //p.image(captaincheese,position.x,position.y);
            p.rect(position.x,position.y,playerWidth,playerHeight);
        //}
        changePosition();
        setVolicityaim();
        simulate();
        interact();



    }
 void simulate() {
     //if (level == 1) {
    // }
 }

    void interact(){

    }



    void controls(char key, int keyCode,  boolean pressed){
        velocity.set(0,0);
        if (key != p.CODED)
            switch(key) {


                case 'f': {
                    if ((pressed) && (ready))
                        showAim = true;

            }break;

                case 's': {
                    if((pressed) &&(ready))
                        down=true;
                    else{
                        down=false;}

                }break;

                case 'w': {
                    if((pressed) &&(ready))
                        up = true;
                    else
                        up=false;

                }break;
                case 'a': {
                    if((pressed) &&(ready))
                        left=true;
                    else
                        left=false;

                }break;
                case 'd': {
                    if((pressed) &&(ready))
                        right=true;
                    else
                        right=false;



                }break;



            }
        else{
            switch (keyCode){

                case DOWN: {
                    if((pressed) &&(ready))
                        down=true;
                    else{
                        down=false;}

                }break;

                case UP: {
                    if((pressed) &&(ready))
                        up=true;
                    else{
                        up=false;}

                }break;
                case RIGHT: {
                    if((pressed) &&(ready))
                        right=true;
                    else{
                        right=false;}


                }break;
                case LEFT: {
                    if((pressed) &&(ready))
                        left=true;
                    else{
                        left=false;}


                }break;

            }


        }
        velocity.set(((right)?1:0) +((left)?-1:0),(((up)?-1:0) +((down)?1:0)));
    }



}
