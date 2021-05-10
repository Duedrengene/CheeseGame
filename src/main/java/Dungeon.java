import processing.core.PApplet;

import java.util.ArrayList;

public class Dungeon {

    PApplet p;

    ImageLoader imgLoad;
    Player player;
Door portal;
    ArrayList<Enemy> enemies;
    Camera camera;
    int portalX = 70;
        int portalY = 100;
    int level;
    int DIAMETER = 80;
    int hastighed = 4;
    Main m ;

    Dungeon(PApplet p,Player player,ArrayList<Enemy> enemies,Camera camera,ImageLoader imgLoad,Main m){

    this.p = p;
    this.player = player;
    this.enemies = enemies;
    this.camera = camera;
    this.imgLoad = imgLoad;
    this.m=m;
    portal= new Door(imgLoad.door);
    }

   void functions() {

        p.pushMatrix();

       cameraFunctions();
       p.image(imgLoad.cavebackground,0,0);
       player.display();
       playerFunctions();
       enemyFunctions();
       //System.out.println(portal.playerNearby(player,portalX,portalY,player.width,player.height,100,100));
       if(portal.playerNearby(player,portalX,portalY,player.width,player.height,100,100)!=-1)
       if(player.activate)
           portal.function(m);
       player.activate= false;

       p.popMatrix();


   }
   void cameraFunctions(){
        camera.changeAngle();
   }

   void playerFunctions(){

       player.runAbility();
       player.regainStamina();
       player.useStamina();
       player.entranceDetect();
       player.showAim(camera);





       p.mouseClicked();


       int bls = player.bullets.size();
       while (bls-- != 0) {
           player.bullets.get(bls).script();
           for(int i=0; i<enemies.size();i++)
            if (player.bullets.get(bls).hit(player.bullets, enemies.get(i))) {

                enemies.get(i).followingPlayer =true;
              
                player.bullets.remove(bls);
                break;
            }
       }


   }

   void enemyFunctions(){
       if (enemies.size() < 5)
           enemies.add(new Enemy((int) p.random(2000, 3000), (int) p.random(0, 1000), hastighed, DIAMETER, player.position, p, player));

       for (int i = 0; i < enemies.size(); i++) {
           enemies.get(i).update();
           enemies.get(i).display();
           if(enemies.get(i).health<0){
enemies.remove(i);
i--;
           }
       }

   }


}
