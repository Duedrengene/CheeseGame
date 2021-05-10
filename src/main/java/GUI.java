import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;

public class GUI {

    PApplet p;
    Player player;
    ArrayList<FloatyText> textList;


    GUI(PApplet p, Player player, ArrayList<FloatyText> textList){
this.p = p;
this.player=player;
this.textList = textList;




    }



   void displayShop(){
        if(player.buildMode)
            p.text("BUILD MODE",p.width/2,p.height-200);

            player.showMoney();
                        System.out.println(textList);

            for (int i = 0; textList.size()>i;i++) {
                if(textList.get(i).moneyText()) {
                   textList.remove(i);
                    System.out.println("true");
                }
            }






    }

    void displayDungeon(){
        player.showHealth();
        player.showStamina();

    }


}
