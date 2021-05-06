import processing.core.PApplet;
import processing.core.PVector;

public class PasswordPillar {
int amount;
float x;
float y;

float diameter = 20;
PVector playerPosition;
Player player;

PApplet p;

//PasswordPillar(PApplet p, int xOffsetTemp, int yOffsetTemp,int xTemp, int yTemp,int tempAmount) {
//PasswordPillar(PApplet p,int xTemp, int yTemp,int tempAmount) {

    PasswordPillar(float  xPos, float yPos, int pillarDiameter, PVector position, Player player,PApplet p) {
        this.playerPosition = playerPosition;
        this.player = player;
            x = xPos;
            y = yPos;
       this.p = p;
}
void display() {
    p.fill(135);
    p.rect(x,y,15,15);
}

}
