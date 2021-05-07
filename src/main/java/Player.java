
import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;
import static processing.core.PConstants.*;

public class Player {

    PApplet p;

    ArrayList<Bullet> bullets;

    Inventory inventory;

    ImageLoader imgLoad;

    PVector position = new PVector();
    PVector velocity = new PVector();
    PVector bodyDash = new PVector();
    PVector bulletSpeed = new PVector();
    PVector runningSpeed = new PVector(1,1);



    boolean isShooting = false;
    boolean showAim = false;
    boolean cooldown = false;
    boolean check = true;
    boolean down,up,left,right = false;
    boolean ready = true;
    boolean open = false;
    boolean running = false;
    boolean notAbleToRun = false;
    boolean buildMode = false;
    boolean activate = false;
    boolean immobile = false;
    boolean inventoryOpen = false;
    boolean dead = false;

    float playerSpd = 20;
    float maximumHealth = 100;
    float healthbarWidth = 200;
    float healthbarHeight = 40;
    float playerHealth = 100;
    float maxMagasineUpgrade;
    float maximumStamina = 100;
    float staminaLoss = 0.5f;
    float passiveStamina = 0.10f;
    float stamina = maximumStamina;

    int playerWidth = 10;
    int playerHeight = 10;



    Player(PApplet p, ArrayList<Bullet> bullets,Inventory inventory,ImageLoader imgLoad) {
        this.playerHealth = playerHealth;
        this.p = p;
        this.bullets = bullets;
        this.imgLoad = imgLoad;
        this.inventory = inventory;

        position.set(1400, this.p.height / 2);
    }


    void changePosition() {

        PVector speed = new PVector(velocity.x,velocity.y);
        speed.mult(runningSpeed.x);
        position.add(speed);

        position.x = p.constrain(position.x, 0, p.width - playerWidth);
        position.y = p.constrain(position.y, 0, p.height - playerHeight);
        PVector dir = new PVector(position.x,position.y);

        Walk(dir);
    }

    public void Walk(PVector dir) {
        //PVector bodydash= new PVector(dir.x*playerspd,dir.y*playerspd);
    }

   void setAim() {

        if (showAim) {
           p.stroke(255, 0, 0, 180);
           p.strokeWeight(3);
           p.line(p.mouseX, p.mouseY, position.x, position.y);

           p.stroke(0);


       }
   }
    void draw(ArrayList<GridSpaceDefault> inventoryGridList,Location location) {
        //void draw(location) {
        changePosition();
        p.fill(255);
        p.stroke(204, 102, 0);
        p.rect(position.x, position.y, playerWidth, playerHeight);

        inventory.display(buildMode,this,inventoryGridList);

        if (playerHealth < 0) {
            playerHealth = 0;
dead = true;
            position.set(960, 890);
location.changeLocation(LocationType.deathrealm);

        }
    }
     void addBullet() {
        bulletSpeed.set(p.mouseX,p.mouseY,0);
        bulletSpeed.sub(position);
        bulletSpeed.normalize();
        bulletSpeed.mult(Bullet.VEL);
        Magasine();

    }
    void Magasine() {
            bullets.add(new Bullet(p,position, bulletSpeed));
        }

    void gameoverscreen(boolean gameoverscreen) {
        if(dead ==true) {

            // Just for right now.

        }
    }

    void showHealth() {
        if (playerHealth < 50) {
            p.fill(175, 215, 0);
        }
        else if ( playerHealth > 50) {
            p.fill(0,255,0);
        }
        else if ( playerHealth < 25) {
            p.fill(0,255,0);
        }

        float calculateplayerHP = (playerHealth / maximumHealth)* healthbarWidth;

        //der er 2 rect tilstede grundet til at der skal være en omkreds om cirkel (da det andet areal/længde går nedad når den mister liv).


        p.stroke(204, 104, 0);


        p.strokeWeight(3);

        p.rect(1660,25,calculateplayerHP,healthbarHeight);
        p.noFill();
        p.rect(1660,25,healthbarWidth,healthbarHeight);
        //Til at vise den maximale HP bar stadig selvom HP forsvinder.

        p.fill(255);
        p.textSize(20);
        p.text((int)calculateplayerHP/2+" HP",1725,50);
    }
 void useStamina() {
     if (running == true) {
         stamina -= staminaLoss;
         if (stamina < 0) {
             stamina = 0.f;

             if (stamina < 10) {
                 notAbleToRun = true;
                 if (notAbleToRun) {
                     running = false;
                 }
             }
         }
     }
 }
void regainStamina() {
    if (running == false) {
        stamina += passiveStamina;
        if (stamina > maximumStamina) {
            stamina = 100.f;
        }
    }
}

   void showStamina(){
   p.fill(244,35,3);
   p.noStroke();
   float displaystamina = stamina *2;
   p.rect(1660,75,displaystamina,40);


   p.stroke(0);

   p.fill(255);
   p.text((int)stamina+" S",1725,110);
   }

    void runAbility(){
    //PVector runningspeed = new PVector();

if(running == false) {
    runningSpeed.set(1,1);
}
else{
    runningSpeed.set(4,4);


    }
    }
    void interact(){

    }
    void controls(char key, int keyCode,  boolean pressed,LocationType location) {
        velocity.set(0, 0);


        if (key != p.CODED)
            switch (key) {

                case '1': {
                    if (pressed == true) {
                        inventory.useBarList.get(0).selected = !inventory.useBarList.get(0).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 0)
                                inventory.useBarList.get(i).selected = false;
                        }
                        if (inventory.useBarList.get(0).selected)
                            inventory.selected = inventory.useBarList.get(0);
                    }

                }
                break;
                case '2': {
                    if (pressed == true) {
                        inventory.useBarList.get(1).selected = !inventory.useBarList.get(1).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 1)
                                inventory.useBarList.get(i).selected = false;
                        }
                        if (inventory.useBarList.get(1).selected)
                            inventory.selected = inventory.useBarList.get(1);
                    }

                }
                break;
                case '3': {
                    if (pressed == true) {
                        if (inventory.itemToolBarList.size() > 3)
                            inventory.useBarList.get(2).selected = !inventory.useBarList.get(2).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 2)
                                inventory.useBarList.get(i).selected = false;
                        }
                        if (inventory.useBarList.get(2).selected)
                            inventory.selected = inventory.useBarList.get(2);
                    }

                }
                break;
                case '4': {
                    if (pressed == true) {
                        if (inventory.itemToolBarList.size() > 4)
                            inventory.useBarList.get(3).selected = !inventory.useBarList.get(3).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 3)
                                inventory.useBarList.get(i).selected = false;
                        }
                        if (inventory.useBarList.get(3).selected)
                            inventory.selected = inventory.useBarList.get(3);
                    }


                }
                break;
                case '5': {
                    if (pressed == true) {
                        if (inventory.itemToolBarList.size() > 5)
                            inventory.useBarList.get(4).selected = !inventory.useBarList.get(4).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 4)
                                inventory.useBarList.get(i).selected = false;
                        }
                        if (inventory.useBarList.get(4).selected)
                            inventory.selected = inventory.useBarList.get(4);
                    }
                }
                break;

                case 'o':
                case 'O':{
                    if(pressed && check){
                        if(!inventoryOpen)
                        inventory.open(this);
                        else
                            inventory.close(this);
                        check = false;
                    }else{
                        check = true;
                    }



                }   break;


                case 'l':
                case 'L':{
                    inventory.add(new PizzaTopping(imgLoad),10);

                }break;

                case 'E':
                case 'e':{
                    if(location == LocationType.shop&&pressed == true)
                    activate=true;

                }break;


                case 'F':
                case 'f': {
                    if ((pressed == false) && (ready))
                        showAim = true;

                        //setAim();
                    else{
                        //else if ((pressed == true) && (ready = false))
                        showAim = false;
                }


            }break;
                case 'S':
                case 's': {
                    if((pressed) &&(ready))
                        down=true;
                    else{
                        down=false;}

                }break;
                case 'W':
                case 'w': {
                    if((pressed) &&(ready))
                        up = true;
                    else
                        up=false;

                }break;
                case 'A':
                case 'a': {
                    if((pressed) &&(ready))
                        left=true;
                    else
                        left=false;

                }break;
                case 'D':
                case 'd': {
                    if((pressed) &&(ready))
                        right=true;
                    else
                        right=false;



                }break;

                case TAB:{
                    if(pressed) {
                        for(int i=0;i <inventory.useBarList.size();i++)
                        inventory.useBarList.get(i).selected = false;

                        if (location == LocationType.shop) {
                            buildMode = !buildMode;

                        }

                    }

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
                case SHIFT: {
                    if((pressed)) {
                        if (ready)
                            running = true;
                    }
                    else {
                        running = false;


                    }

                }break;



            }


        }
        velocity.set((((right)?1:0) +((left)?-1:0)),(((up)?-1:0) +((down)?1:0)));

        }


     void mouseControls(int mouseX, int mouseY,boolean pressed,LocationType location,ArrayList<GridSpaceDefault> grid) {
        if(location==LocationType.dungeon) {
            if(pressed)
               if(check) {
                check=false;

                   addBullet();
               }
            else {
                check=true;
                isShooting =false;
            }
        }

         if(location == LocationType.shop) {
             if (pressed)
             if(buildMode) {
                 for (int i = 0; i < grid.size(); i++)
                     grid.get(i).pressed(true, mouseX, mouseY);
             }
             inventory.selector(true, mouseX, mouseY, inventory);
         }


     }

}
