
import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;
import static processing.core.PConstants.*;

public class Player {


    ArrayList<Bullet> bullets;

    PApplet p;


    PVector position = new PVector();
    PVector velocity = new PVector();
    PVector playerspeed = new PVector(0,0);
    PVector bodydash = new PVector();
    float playerspd = 20;
    PVector bulletspeed = new PVector();
    PVector runningspeed = new PVector();




    boolean isShooting = false;
    boolean showAim = false;
    boolean cooldown = false;
    boolean check = true;

    Inventory inventory;

    boolean down,up,left,right = false;
    boolean ready = true;
    boolean open = false;


    boolean running = false;
    boolean notAbleToRun = false;

    boolean buildMode = false;
    int playerWidth = 10;
    int playerHeight = 10;




    float maximumhealth = 100;
    float healthbarWidth = 200;
    float healthbarHeight = 40;
    float playerhealth = 100;
    float maxmagasineupgrade;


    float maximumstamina = 100;
    float staminaloss = 0.5f;
    float passivestamina = 0.10f;

    float stamina = maximumstamina;





    Player(PApplet p, ArrayList<Bullet> bullets,Inventory inventory) {
        this.playerhealth = playerhealth;
        this.p = p;
        this.bullets = bullets;
        //this.bulletpool = bulletpool;

        this.inventory = inventory;

        position.set(100, this.p.height / 2);
    }


    void changePosition() {

        PVector speed = new PVector(velocity.x,velocity.y);
                speed.mult(runningspeed.x);
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
           p.strokeWeight(1);

       }
   }
    void draw() {
        changePosition();

        p.stroke(204, 102, 0);
        p.rect(position.x, position.y, playerWidth, playerHeight);

        inventory.display(buildMode);

    }
     void addBullet() {
        bulletspeed.set(p.mouseX,p.mouseY,0);
        bulletspeed.sub(position);
        bulletspeed.normalize();
        bulletspeed.mult(Bullet.VEL);
        Magasine();

    }
    void Magasine() {
            bullets.add(new Bullet(p,position,bulletspeed));
        }

    void showHealth() {
        if (playerhealth < 50) {
            p.fill(175, 215, 0);
        }
        else if ( playerhealth > 50) {
            p.fill(0,255,0);
        }
        else if ( playerhealth < 25) {
            p.fill(0,255,0);
        }

        float calculateplayerHP = (playerhealth/maximumhealth)* healthbarWidth;

        //der er 2 rect tilstede grundet til at der skal være en omkreds om cirkel (da det andet areal/længde går nedad når den mister liv).
        p.strokeCap(ROUND);

        p.stroke(204, 104, 0);


        p.strokeWeight(3);

        p.rect(740,25,calculateplayerHP,healthbarHeight);
        p.noFill();
        p.rect(740,25,healthbarWidth,healthbarHeight);
        p.println(calculateplayerHP);
        //Til at vise den maximale HP bar stadig selvom HP forsvinder.

        p.fill(255);
        p.textSize(20);
        p.text((int)calculateplayerHP/2+" HP",805,50);
    }
 void useStamina() {
     if (running == true) {
         stamina -= staminaloss;
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
        stamina += passivestamina;
        if (stamina > maximumstamina) {
            stamina = 100.f;
        }
    }
}

   void showStamina(){
   p.fill(244,35,3);
   p.noStroke();
   float displaystamina = stamina *2;
   p.rect(740,75,displaystamina,40);


   p.stroke(0);

   p.fill(255);
   p.text((int)stamina+" S",805,110);
   }

    void runAbility(){
    //PVector runningspeed = new PVector();

if(running == false) {
    runningspeed.set(1,1);
}
else{
    runningspeed.set(4,4);

       // if(running) {
        //position.add(runningspeed);

System.out.println("Lugte");
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
                        inventory.toolBarList.get(0).selected = !inventory.toolBarList.get(0).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 0)
                                inventory.toolBarList.get(i).selected = false;
                        }
                        if (inventory.toolBarList.get(0).selected)
                            inventory.selected = inventory.toolBarList.get(0);
                    }

                }
                break;
                case '2': {
                    if (pressed == true) {
                        inventory.toolBarList.get(1).selected = !inventory.toolBarList.get(1).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 1)
                                inventory.toolBarList.get(i).selected = false;
                        }
                        if (inventory.toolBarList.get(1).selected)
                            inventory.selected = inventory.toolBarList.get(1);
                    }

                }
                break;
                case '3': {
                    if (pressed == true) {
                        if (inventory.itemList.size() > 3)
                            inventory.toolBarList.get(2).selected = !inventory.toolBarList.get(2).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 2)
                                inventory.toolBarList.get(i).selected = false;
                        }
                        if (inventory.toolBarList.get(2).selected)
                            inventory.selected = inventory.toolBarList.get(2);
                    }

                }
                break;
                case '4': {
                    if (pressed == true) {
                        if (inventory.itemList.size() > 4)
                            inventory.toolBarList.get(3).selected = !inventory.toolBarList.get(3).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 3)
                                inventory.toolBarList.get(i).selected = false;
                        }
                        if (inventory.toolBarList.get(3).selected)
                            inventory.selected = inventory.toolBarList.get(3);
                    }


                }
                break;
                case '5': {
                    if (pressed == true) {
                        if (inventory.itemList.size() > 5)
                            inventory.toolBarList.get(4).selected = !inventory.toolBarList.get(4).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 4)
                                inventory.toolBarList.get(i).selected = false;
                        }
                        if (inventory.toolBarList.get(4).selected)
                            inventory.selected = inventory.toolBarList.get(4);
                    }
                }
                break;
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
                    System.out.println("Bruh");
                    if(pressed) {
                        if (location == LocationType.shop) {
                            buildMode = !buildMode;
                            System.out.println(buildMode);

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
                        System.out.println(running);
                    }
                    else {
                        running = false;


                    }

                }break;



            }


        }
        velocity.set((((right)?1:0) +((left)?-1:0)),(((up)?-1:0) +((down)?1:0)));

        }


     void mouseControls(int mouseX, int mouseY,boolean pressed,LocationType location,ArrayList<GridSpace> grid) {
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
                     grid.get(i).pressed(true, mouseX, mouseY, inventory);
             }
             inventory.selector(true, mouseX, mouseY, inventory);
         }


     }

}
