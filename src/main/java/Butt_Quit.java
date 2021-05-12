import processing.core.PApplet;

public class Butt_Quit extends Button  {


    Butt_Quit(PApplet p, Player player){
        super( p, player);
        position.set(p.width/2,p.height/3);
        text = "Quit";

    }

}
