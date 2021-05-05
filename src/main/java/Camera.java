import processing.core.PApplet;
import processing.core.PVector;

import static processing.core.PConstants.CODED;
import static processing.core.PConstants.CONTROL;

public class Camera {

    Player player;
    PVector perspective = new PVector();
    int mode;
    PVector startpos = new PVector(250,250);
    PApplet p;
    PVector position;

    public Camera( PApplet p, PVector position,Player player) {
        this.p = p;
        this.position = position;
        this.player = player;
    }

    void changeAngle(){
    switch (mode) {
        case 0: {

        }
        break;
        case 1: {
            p.translate(p.width / 2, p.height / 2);
            p.translate(-perspective.x, -perspective.y);
        }
        break;
    }
        p.pushMatrix();

    perspective = PVector.lerp(player.position,player.position,0);
    //perspective = PVector.lerp(player.position,player.position,0);

    //p.translate(-player.position.x,-player.position.y);
    //p.noFill();

    //perspective = PVector.lerp(perspective,perspective,0);

    //player.changeposition();
        //player.showHealth();
    p.popMatrix();

    }
    void setPerspective(char key, int keyCode, boolean b, LocationType location) {
        if(key==CODED) {
            if(keyCode == 'k') {
                mode= (mode+1)%2;
            }
        }
    }
    }

