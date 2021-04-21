import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;

public class Bullet {

 PApplet p;
 PVector bulletlocation;

 PVector pos = new PVector();
 PVector bulletspeed = new PVector();
 static final short FREQUENCY=2;
 static final short VEL = 5;
 //boolean isShooting;

 int bullettype;

    Bullet(PApplet p,PVector bulletlocation, PVector velocity) {
        this.p = p;
        bullettarget(bulletlocation,velocity);
    }

    void bullettarget(PVector bulletlocation, PVector velocity) {
        pos.set(bulletlocation);
        bulletspeed.set(velocity);
        //isShooting = false;
    }

void drawbullet() {

         p.fill(250,150,150);
        p.ellipse(pos.x,pos.y,10,10);

}
void movebullet() {

    pos.add(bulletspeed);

}
boolean check() {
        return pos.x > p.width | pos.x < 0 | pos.y > p.height | pos.y < 0;
}
    void hit(ArrayList<Bullet> bullets, Enemy enemy, int i) {
        if(bulletlocation.x <= enemy.getEnemyposition.x && bulletlocation.x >= enemy.getEnemyposition.x && bulletlocation.y <= enemy.getEnemyposition.y && bulletlocation.y >= enemy.getEnemyposition.y) {
            enemy.health -= -1;
            bullets.remove(i);
        }

    }
void script() {


        drawbullet();
        movebullet();
        //hit();
        //return isShooting;

}



}
