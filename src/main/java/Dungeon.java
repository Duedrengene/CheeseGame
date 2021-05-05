import processing.core.PApplet;

import java.util.ArrayList;

public class Dungeon {
    int level;
    int DIAMETER = 80;
    int hastighed = 4;
    PApplet p;
    Player player;
    ArrayList<Enemy> enemies;

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
       player.runAbility();
       player.regainStamina();
       player.useStamina();
       player.showStamina();


       p.mouseClicked();


       int bls = player.bullets.size();
       while (bls-- != 0) {
           player.bullets.get(bls).script();
           for(int i=0; i<enemies.size();i++)
            if (player.bullets.get(bls).hit(player.bullets, enemies.get(i))) {
                enemies.get(i).followingplayer=true;
                System.out.println("Mathias er ikke cool");
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
