import processing.core.PApplet;
import processing.core.PVector;
public class Enemy {
boolean followingplayer;
PApplet p;
PVector getEnemyposition;
PVector getGetEnemyvelocity;
    float movespeed = 4;
int MaxDist = 10;
int MinDist = 5;

Enemy(float x, float y, float v) {
         getEnemyposition.x = x;
         getEnemyposition.y=y;
         movespeed =v;
}
void update() {
    if(followingplayer) {
        //Identificere spillerens lokation.
        PVector targetVector = new PVector();
        //targetVector.x = player.position.x();
        //targetVector.y = player.position.y();
        // Fjendens position forhold til playeren.
        PVector Enemychase = new PVector();
        Enemychase.x = getEnemyposition.x;
        Enemychase.y = getEnemyposition.y;

        PVector direction = PVector.sub(targetVector,Enemychase);

        direction.normalize();

        direction.mult(movespeed);
        getEnemyposition.x += direction.x;
        getEnemyposition.y += direction.y;
    }

}
}