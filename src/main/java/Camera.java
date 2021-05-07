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
    float translateX;
    float translateY;
    boolean ready;

    public Camera( PApplet p, PVector position,Player player) {
        this.p = p;
        this.position = position;
        this.player = player;

    }

    void changeAngle(){
    switch (mode) {
        case 0: {
            translateX = 0;
            translateY= 0;
        }
        break;
        case 1: {
            translateX = p.width/2-player.position.x;
            translateY= p.height/2-player.position.y;
          //  p.translate(p.width / 2, p.height / 2);
          //  p.translate(-perspective.x, -perspective.y);


        }
        break;

    }
        p.translate(translateX,translateY);

      //  p.pushMatrix();
        //Lerp er en matematisk lineær interpolation, som er til at lave en kurvetilpasning. Dette virker for kameraet, da det konstruerer ny data ved center af skærmen ud fra hvor playeren går(playerens perspective.)
  //  perspective = PVector.lerp(player.position,player.position,0.0F);

    //perspective = PVector.lerp(player.position,player.position,0);

    //p.translate(-player.position.x,-player.position.y);
    //p.noFill();
    //perspective = PVector.lerp(perspective,perspective,0);

   // p.popMatrix();

    }/*
    void setPerspective(char key, int keyCode, boolean pressed, LocationType location) {
            if(pressed == true)
            if(key == 'k'||key=='K') {
                System.out.println("MATHIAS STINK");
            }
        }
*/
    }

