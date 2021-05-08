
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class DeathReaper {
PApplet p;
PVector position = new PVector();
boolean talkOpen;
boolean playerNearby;
Deathrealm deathrealm;
    ImageLoader imgLoad;

    int amount = 8;
    int count;

    float verticalRadius = 8;
    float horizontalRadius = 2.5f;
    float angle = 0;

DeathReaper(PApplet p,float posX,float posY, ImageLoader imgLoad) {
    this.p=p;
    this.position.x = posX;
    this.position.y = posY;
    this.imgLoad = imgLoad;
}
void drawDeathReaper() {
    p.background(95,73,41);
    p.image(imgLoad.deathRealm,0,0);
    p.fill(133);
    //p.rect(940,65,96,96);
    float x = horizontalRadius*p.cos(angle);
    float y = verticalRadius * p.sin(angle);

    p.image(imgLoad.grimReaper,x+940,y+65,96,96);
    angle+=0.05;

    if(this.playerNearby) {
        this.p.fill(133);
        this.p.text(" You have came here to Suffer?",this.position.x - 20.0f, this.position.y-20.0f);

    talkOpen = true;
    }
}

void ReaperPillars(){

    //p.rect();

}
}
