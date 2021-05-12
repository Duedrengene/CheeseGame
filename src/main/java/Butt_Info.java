import processing.core.PApplet;

public class Butt_Info extends Button  {

    Butt_Info(PApplet p, Player player){
        super( p, player);
        position.set(p.width/2,p.height/4);
        text = "Info";
    }

}
