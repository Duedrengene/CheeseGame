import processing.core.PApplet;

import java.util.ArrayList;

public class Dungeon {

    PApplet p;

    ImageLoader imgLoad;
    Player player;

    ArrayList<Enemy> enemies;
    Camera camera;
    int level;
    int DIAMETER = 80;
    int hastighed = 4;


    Dungeon(PApplet p,Player player,ArrayList<Enemy> enemies,Camera camera,ImageLoader imgLoad){

    this.p = p;
    this.player = player;
    this.enemies = enemies;
    this.camera = camera;
    this.imgLoad = imgLoad;

    }

   void functions() {

        p.pushMatrix();

       cameraFunctions();
       p.image(imgLoad.cavebackground,0,0);
       player.display();
       playerFunctions();
       enemyFunctions();
       p.popMatrix();

   }
   void cameraFunctions(){
        camera.changeAngle();
   }

   void playerFunctions(){

       player.runAbility();
       player.regainStamina();
       player.useStamina();
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
           enemies.add(new Enemy((int) p.random(0, 1000), (int) p.random(0, 1000), hastighed, DIAMETER, player.position, p, player));

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
