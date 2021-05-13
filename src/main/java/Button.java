import processing.core.PApplet;
import processing.core.PVector;

import javax.swing.text.Position;

public class Button  {

    PVector position = new PVector();

    Player player;

    PApplet p;
    
    String text;

    int width = 200;
    int height = 50;

    Button(PApplet p,Player player){
        this.p = p;
        this.player = player;

    }

    void function(){

        System.out.println(text);

    }

    void checkPressed(){
        if(player.mouseActivate&&(p.mouseX>position.x&&p.mouseX<position.x+width&&p.mouseY>position.y&&p.mouseY<position.y+height))
        function();
        System.out.println(player.mouseActivate);
        player.mouseActivate = false;
//Mousecontrols bliver ikke kørt
    }

    void display(){
        p.fill(255);
        p.rect(position.x,position.y,width,height);
        p.fill(122);
        p.text(text,position.x,position.y+20);



    }



}
