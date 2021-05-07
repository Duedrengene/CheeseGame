
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


DeathReaper(PApplet p,float posX,float posY, ImageLoader imgLoad) {
    this.p=p;
    this.position.x = posX;
    this.position.y = posY;
    this.imgLoad = imgLoad;
}
void drawDeathReaper() {
    p.fill(133);
    p.rect(940,65,96,96);
    p.image(imgLoad.grimReaper,940,65,96,96);
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
