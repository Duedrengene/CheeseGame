import processing.core.PApplet;

public class GUI {

    PApplet p;
    Player player;



    GUI(PApplet p,Player player){
this.p = p;
this.player=player;





    }



   void displayShop(){
        if(player.buildMode){
            p.text("BUILD MODE",p.width/2,p.height-200);

            player.showMoney();

        }



    }

    void displayDungeon(){
        player.showHealth();
        player.showStamina();

    }


}
