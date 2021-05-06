import processing.core.PApplet;



public class Deathrealm {
    PApplet p;

    Player player;

    int level;
    int DIAMETER = 80;
    int hastighed = 4;


    Deathrealm(PApplet p, Player player) {

        this.p = p;
        this.player = player;


    }
    void deathrealmFunctions() {
        playerFunctions();


    }
    void playerFunctions() {
     player.runAbility();
     player.regainStamina();
     player.useStamina();

    }

}
