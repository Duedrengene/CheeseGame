import processing.core.PApplet;
import processing.core.PVector;

public class DeathReaper {
PApplet p;
PVector position = new PVector();
boolean talkOpen;
boolean playerNearby;
Deathrealm deathrealm;


DeathReaper(PApplet p,float posX,float posY) {
    this.p=p;
    this.position.x = posX;
    this.position.y = posY;
}
void drawDeathReaper() {
    p.fill(133);
    p.rect(250,250,250,250);
    if(this.playerNearby) {

        this.p.fill(133);
        this.p.text(" You have came to Suffer",this.position.x - 20.0F, this.position.y-20.0F);
    talkOpen = true;

    }
}

}
