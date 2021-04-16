import processing.core.PApplet;
import processing.core.PVector;

import static processing.core.PConstants.*;

public class Player {

    PApplet p;

    PVector position = new PVector();
    PVector velocity = new PVector();

    Inventory inventory;

    boolean showAim = false;
    boolean down,up,left,right = false;
    boolean ready = true;
    boolean open = false;

    int playerWidth = 10;
    int playerHeight=10;


    Player(PApplet p,Inventory inventory){

        this.p = p;
        this.inventory = inventory;

        position.set(100,this.p.height/2);

    }


    void changePosition(){

        position.add(velocity);
        position.x =p.constrain(position.x,0,p.width-playerWidth);
        position.y=  p.constrain(position.y,0,p.height-playerHeight);
    }
   void setAim(){
        if(showAim == true);

        p.stroke(255,0,0,180);
        p.strokeWeight(3);
        p.line(p.mouseX,p.mouseY,position.x,position.y);


       p.stroke(0);
       p.strokeWeight(1);
   }

    void draw(){

       // changePosition();
        //if(level ==1) {
            //p.image(captaincheese,position.x,position.y);
            p.rect(position.x,position.y,playerWidth,playerHeight);
        //}
        inventory.display();
        changePosition();
        setAim();
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


                case '1':{
                    if(pressed == false) {
                    inventory.toolBarList.get(0).selected = !inventory.toolBarList.get(0).selected;
                    for(int i = 0; i<5;i++) {
                        if(i!=0)
                        inventory.toolBarList.get(i).selected = false;
                    }
                        if (inventory.toolBarList.get(0).selected)
                            inventory.selected = inventory.toolBarList.get(0);
                    }

                }break;
                case '2':{
                    if(pressed == false) {
                    inventory.toolBarList.get(1).selected = !inventory.toolBarList.get(1).selected;
                    for(int i = 0; i<5;i++) {
                        if (i != 1)
                            inventory.toolBarList.get(i).selected = false;
                    }
                        if (inventory.toolBarList.get(1).selected)
                        inventory.selected = inventory.toolBarList.get(1);
                    }


                }break;
                case '3':{
                    if(pressed == false) {
                        if(inventory.itemList.size()>3)
                    inventory.toolBarList.get(2).selected = !inventory.toolBarList.get(2).selected;
                    for(int i = 0; i<5;i++) {
                        if(i!=2)
                            inventory.toolBarList.get(i).selected = false;
                    }
                        if (inventory.toolBarList.get(2).selected)
                            inventory.selected = inventory.toolBarList.get(2);
                    }


                }break;
                case '4':{
                    if(pressed == false) {
                        if(inventory.itemList.size()>4)
                    inventory.toolBarList.get(3).selected = !inventory.toolBarList.get(3).selected;
                    for(int i = 0; i<5;i++) {
                        if(i!=3)
                            inventory.toolBarList.get(i).selected = false;
                    }
                        if (inventory.toolBarList.get(3).selected)
                            inventory.selected = inventory.toolBarList.get(3);
                    }


                }break;
                case '5':{
                    if(pressed == false) {
                        if(inventory.itemList.size()>5)
                        inventory.toolBarList.get(4).selected = !inventory.toolBarList.get(4).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 4)
                                inventory.toolBarList.get(i).selected = false;
                        }
                        if (inventory.toolBarList.get(4).selected)
                            inventory.selected = inventory.toolBarList.get(4);
                    }

                }break;


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
