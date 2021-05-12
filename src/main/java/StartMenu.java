import processing.core.PApplet;

import java.util.ArrayList;

public class StartMenu {

    ArrayList<Button> buttons = new ArrayList<>();


    StartMenu(PApplet p, Player player){

        buttons.add(new Butt_Start(p,player));
        buttons.add(new Butt_Info(p,player));
        buttons.add(new Butt_Quit(p,player));

    }



    void functions(){

        for(int i =0;i<buttons.size();i++){
            buttons.get(i).checkPressed();
            buttons.get(i).display();




        }




    }

}
