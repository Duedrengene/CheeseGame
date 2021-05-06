import processing.core.PApplet;



public class Deathrealm {
    PApplet p;

    Player player;
    DeathReaper deathReaper;

    int level;
    int DIAMETER = 80;
    int hastighed = 4;


    Deathrealm(PApplet p, Player player,DeathReaper deathReaper) {

        this.p = p;
        this.player = player;
        this.deathReaper = deathReaper;


    }
    void deathrealmFunctions() {
        playerFunctions();


    }
    void playerFunctions() {
     player.runAbility();
     player.regainStamina();
     player.useStamina();
     deathReaper.drawDeathReaper();


    }

}
