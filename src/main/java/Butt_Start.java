import processing.core.PApplet;

public class Butt_Start extends Button  {


    Butt_Start(PApplet p, Player player){
        super( p, player);
        position.set(p.width/2,p.height/5);
        text = "Start";


    }

}
