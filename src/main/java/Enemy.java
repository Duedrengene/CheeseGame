import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;


public class Enemy {

    PApplet p;

    ArrayList<Bullet> bullets;

    Player player;

    PImage img;

    PVector playerPosition;
    PVector enemyPosition = new PVector();
    PVector getGetEnemyVelocity = new PVector(0, 0);
    PVector acceleration;

    Items drop = Items.empty;
    ImageLoader imgLoad;

    boolean followingPlayer = false;
    boolean enemySlashRange = false;
    boolean knockback = false;

    int time =-1;
    int t0 = 0;

    float speed;
    float activeRadius;
    float maximumHealth;
    float healthbarWidth = 100;
    float healthbarHeight = 20;
    float health;
    float moveSpeed;
    float maxForce = 1;
    float playerDiameter = 64;
    float enemyDiameter = 64;


    //float calculateHP;

    Enemy(float xPos, float yPos, float speed, float health,float activeRadius, PVector playerPosition, PApplet p, Player player,ImageLoader imgLoad) {
        enemyPosition.x = xPos;
        enemyPosition.y = yPos;
        this.speed = speed;
        this.p = p;
        this.playerPosition = playerPosition;
        this.player = player;
        this.bullets = player.bullets;
        this.imgLoad = imgLoad;
        acceleration = new PVector(0, 0);
        moveSpeed = speed;
        this.activeRadius = activeRadius;
        this.maximumHealth = health;
        this.health = maximumHealth;
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


            //getGetEnemyvelocity.limit(movespeed);

            enemyPosition.add(getGetEnemyVelocity);
            PVector steerforce = PVector.sub(direction, getGetEnemyVelocity);
            //PVector steerforce = PVector.sub(direction,enemychase);
            steerforce.limit(maxForce);

            //getGetEnemyvelocity.limit(movespeed);
            //p.println(steerforce);
            if(knockback ==true) {
               enemyPosition.add(-direction.x*12,-direction.y*12);
                knockback =false;
            }

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
        p.imageMode(3);
        p.image(img,enemyPosition.x, enemyPosition.y, enemyDiameter, enemyDiameter);
        p.imageMode(0);

        //Laver enemies Healthbar.

        float calculateHP = (health / maximumHealth) * healthbarWidth;

        p.stroke(153);
        p.rect(enemyPosition.x - 50, enemyPosition.y - 50, calculateHP, healthbarHeight);
        boolean hit = pointRadius(playerPosition.x, playerPosition.y, enemyPosition.x, enemyPosition.y, enemyDiameter);

        if (hit) {
           //timerReset();


            player.playerHealth -= 10;
            //playerPosition.add()

        }

    }
void timerReset() {
        time = p.millis();
       // p.println(time);
}
    boolean invincibilityFrame(int seconds) {
        //int delta =p.millis();
    return (p.millis() - time > 1000 * seconds);
    }

    void timerFunction() {
        for(int i =1; i<3;i++) {
            if(invincibilityFrame(i)) {
                }
            }
        }




    boolean pointRadius(float positionx, float positiony,  float getEnemypositionx, float timer, float Enemyradius) {
        float distanceX = playerPosition.x - enemyPosition.x;
        float distanceY = playerPosition.y - enemyPosition.y;
        float distance = p.sqrt((distanceX * distanceX) + (distanceY * distanceY));

        if (distance <= activeRadius) {
            followingPlayer = true;

            if(distance < 35) {
                enemySlashRange = true;
                if (enemySlashRange = true) ;

                float slowdown = 0.04f;
                moveSpeed = slowdown;
            }
                 else

                     //HIT FUCKTION HERE WHEN ATTACKING.
                     moveSpeed =speed;
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