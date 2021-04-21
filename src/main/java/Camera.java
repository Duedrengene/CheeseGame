import processing.core.PApplet;
import processing.core.PVector;
public class Camera {

    Player player;
    PVector perspective = new PVector();

    PVector startpos = new PVector(250,250);
    PApplet p;

    Camera( PApplet p) {
        this.p = p;

    }
    void changeAngle(){
    p.pushMatrix();
    p.translate(p.width/2,p.height/2);
    p.translate(-perspective.x,-perspective.y);
    //p.noFill();
    perspective = PVector.lerp(perspective,perspective,0);
    //player.changeposition();
        //player.showHealth();
    p.popMatrix();

    }
}
