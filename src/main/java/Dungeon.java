import processing.core.PApplet;

import java.util.ArrayList;

public class Dungeon {
    int level;
    int DIAMETER = 80;
    int hastighed = 4;
    PApplet p;
    Player player;
    ArrayList<Enemy> enemies = new ArrayList<>();

    Dungeon(PApplet p,Player player,ArrayList<Enemy> enemies){
    this.p = p;
    this.player = player;
    this.enemies = enemies;

    }

   void functions(){

   playerFunctions();
   enemyFunctions();


   }

   void playerFunctions(){
    player.showHealth();
    player.setAim();
    player.runability();
    player.regainStamina();
    player.useStamina();
    player.showStamina();

       p.mouseClicked();


       int bls = player.bullets.size();
       while (bls-- != 0)
           player.bullets.get(bls).script();


   }

   void enemyFunctions(){
       if (enemies.size() < 5)
           enemies.add(new Enemy((int) p.random(0, 1000), (int) p.random(0, 1000), hastighed, DIAMETER, player.position, p, player));

       for (int i = 0; i < enemies.size(); i++) {
           enemies.get(i).update();
           enemies.get(i).display();


       }

   }


}
