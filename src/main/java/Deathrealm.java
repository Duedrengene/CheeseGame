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
        p.text("You died Scumb <:)", 960,85);
        p.fill(133);


    }
    void playerFunctions() {
     player.runAbility();
     player.regainStamina();
     player.useStamina();
     deathReaper.drawDeathReaper();


    }

}
