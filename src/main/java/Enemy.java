import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;


public class Enemy {

    PApplet p;

    ArrayList<Bullet> bullets;

    Player player;

    PVector playerPosition;
    PVector enemyPosition = new PVector();
    PVector getGetEnemyVelocity = new PVector(0, 0);
    PVector acceleration;


    boolean followingPlayer = false;
    boolean enemySlashRange = false;
    boolean ret;

    int time =-1;
    int t0 = 0;

    int hastighed;

    float maximumHealth = 100;
    float healthbarWidth = 100;
    float healthbarHeight = 20;
    float health = 100;
    float moveSpeed = 4;
    float maxForce = 1;
    float playerDiameter = 10;
    float enemyDiameter = 10;

    //float calculateHP;

    Enemy(float xPos, float yPos, int hastighed, int DIAMETER, PVector playerPosition, PApplet p, Player player) {
        enemyPosition.x = xPos;
        enemyPosition.y = yPos;
        this.hastighed = hastighed;
        this.p = p;
        this.playerPosition = playerPosition;
        this.player = player;
        this.bullets = player.bullets;

        acceleration = new PVector(0, 0);

    }

    void update() {
        if (followingPlayer) {
            //Identificere spillerens lokation.
            PVector targetVector = new PVector();

            targetVector.x = playerPosition.x;
            targetVector.y = playerPosition.y;
            // Fjendens position forhold til playeren.
            PVector enemychase = new PVector();
            enemychase.x = enemyPosition.x;
            enemychase.y = enemyPosition.y;

            PVector direction = PVector.sub(targetVector, enemychase);
            //for at lave det til en normalvektor med en længde på 1.
            direction.normalize();

            direction.mult(moveSpeed);
            enemyPosition.x += direction.x;
            enemyPosition.y += direction.y;

            direction.limit(moveSpeed);
            //getGetEnemyvelocity.limit(movespeed);

            enemyPosition.add(getGetEnemyVelocity);
            PVector steerforce = PVector.sub(direction, getGetEnemyVelocity);
            //PVector steerforce = PVector.sub(direction,enemychase);
            steerforce.limit(maxForce);

            //getGetEnemyvelocity.limit(movespeed);
            //p.println(steerforce);
        }
        if (health < 50) {
            p.fill(175, 215, 0);
        } else if (health > 50) {
            p.fill(0, 255, 0);
        } else if (health < 25) {
            p.fill(0, 255, 0);
        }

    }

    public void display() {

        p.ellipse(enemyPosition.x, enemyPosition.y, enemyDiameter, enemyDiameter);

        //Laver enemies Healthbar.

        float calculateHP = (health / maximumHealth) * healthbarWidth;

        p.stroke(153);
        p.rect(enemyPosition.x - 50, enemyPosition.y - 50, calculateHP, healthbarHeight);
        boolean hit = pointRadius(playerPosition.x, playerPosition.y, playerDiameter, enemyPosition.x, enemyPosition.y, enemyDiameter);

        if (hit) {
            p.fill(255, 150, 0);
            p.text("u dead now", 200, 200);
            player.playerHealth -= 10;


        }

    }
void timerreset() {
        time = p.millis();
}
    boolean invincibilityFrame(int seconds) {
        //int delta =p.millis();
return (p.millis() - time > 1000 *seconds);
    }



    boolean pointRadius(float positionx, float positiony, float Activeradius, float getEnemypositionx, float timer, float Enemyradius) {
        float distanceX = playerPosition.x - enemyPosition.x;
        float distanceY = playerPosition.y - enemyPosition.y;
        float distance = p.sqrt((distanceX * distanceX) + (distanceY * distanceY));
        Activeradius = 350;
        if (distance <= Activeradius) {
            followingPlayer = true;

            if(distance < 35) {
                enemySlashRange = true;
                if (enemySlashRange = true) ;

                float slowdown = 1.6f;
                moveSpeed = slowdown;
            }
                 else

                     //HIT FUCKTION HERE WHEN ATTACKING.
                     moveSpeed =4;
                     enemySlashRange = false;


                //getGetEnemyvelocity = ();

                //float magnitude = p.map(distance,0,0,0,0);
                //getEnemyposition.mult(magnitude);


        }
        if (distance <= Enemyradius) {
            return true;
        }
        if(timer == 120) {

    }

    return false;
    }

}