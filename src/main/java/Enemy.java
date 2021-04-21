import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;


public class Enemy {

    ArrayList<Bullet> bullets;

    boolean followingplayer = false;
    boolean dead = false;
    int hastighed;
    PApplet p;
    PVector getEnemyposition = new PVector();
    float maximumhealth = 100;
    float healthbarWidth = 100;
    float healthbarHeight = 20;
    float health = 100;
    Player player;
    //float calculateHP;
    PVector getGetEnemyvelocity = new PVector(0,0);
    PVector acceleration;
    float movespeed = 4;
    float maxforce = 1;
    boolean enemyslashrange = false;

    float Playeradius = 10;
    float Enemyradius = 10;

    PVector position;


    Enemy(float xPos, float yPos, int hastighed, int DIAMETER, PVector position, PApplet p, Player player) {
        getEnemyposition.x = xPos;
        getEnemyposition.y = yPos;
        this.hastighed = hastighed;
        this.p = p;
        this.position = position;
        this.player = player;
        this.bullets = player.bullets;

        acceleration = new PVector(0,0);

    }

    void update() {
        if (followingplayer) {
            //Identificere spillerens lokation.
            PVector targetVector = new PVector();

            targetVector.x = position.x;
            targetVector.y = position.y;
            // Fjendens position forhold til playeren.
            PVector enemychase = new PVector();
            enemychase.x = getEnemyposition.x;
            enemychase.y = getEnemyposition.y;

            PVector direction = PVector.sub(targetVector, enemychase);
            //for at lave det til en normalvektor med en længde på 1.
            direction.normalize();

            direction.mult(movespeed);
            getEnemyposition.x += direction.x;
            getEnemyposition.y += direction.y;

            direction.limit(movespeed);
            //getGetEnemyvelocity.limit(movespeed);

            getEnemyposition.add(getGetEnemyvelocity);
            PVector steerforce = PVector.sub(direction,getGetEnemyvelocity);
            //PVector steerforce = PVector.sub(direction,enemychase);
            steerforce.limit(maxforce);

            //getGetEnemyvelocity.limit(movespeed);
            //p.println(steerforce);

            if (health < 50) {
                p.fill(175, 215, 0);
            } else if (health > 50) {
                p.fill(0, 255, 0);
            } else if (health < 25) {
                p.fill(0, 255, 0);
            }
        }
    }

    public void display() {

        p.ellipse(getEnemyposition.x, getEnemyposition.y, Enemyradius, Enemyradius);

        //Laver enemies Healthbar.

        float calculateHP = (health / maximumhealth) * healthbarWidth;

        p.stroke(153);
        p.rect(getEnemyposition.x - 50, getEnemyposition.y - 50, calculateHP, healthbarHeight);
        boolean hit = pointRadius(position.x, position.y, Playeradius, getEnemyposition.x, getEnemyposition.y, Enemyradius);

        if (hit) {
            p.fill(255, 150, 0);
            p.text("u dead now",200,200);
            player.playerhealth -=10;

            if(player.playerhealth < 0) {
                p.text("Press to Respawn",250,50);
                player.playerhealth =0;

            }

        }

    }

    boolean pointRadius(float positionx, float positiony, float Activeradius, float getEnemypositionx, float timer, float Enemyradius) {
        float distanceX = position.x - getEnemyposition.x;
        float distanceY = position.y - getEnemyposition.y;
        float distance = p.sqrt((distanceX * distanceX) + (distanceY * distanceY));
        Activeradius = 350;
        if (distance <= Activeradius) {
            followingplayer = true;

            if(distance < 35) {
                enemyslashrange = true;
                if (enemyslashrange = true) ;

                float slowdown = (float) 1.6;
                movespeed = slowdown;
            }
                 else

                     //HIT FUCKTION HERE WHEN ATTACKING.
                     movespeed =4;
                     enemyslashrange = false;


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