import processing.core.PApplet;

import java.util.ArrayList;


public class Deathrealm {
    PApplet p;

    Player player;
    DeathReaper deathReaper;
    ArrayList<PasswordPillar> pillars;

    int unit = 40;
    int count;

    int level;
    int DIAMETER = 80;
    int hastighed = 4;
    int pillardiameter = 20;


    Deathrealm(PApplet p, Player player,ArrayList<PasswordPillar> pillars, DeathReaper deathReaper) {
        this.p = p;
        this.player = player;
        this.deathReaper = deathReaper;
        this.pillars=pillars;
        //position.set(1400, this.p.height / 2);
    }
    void deathrealmFunctions() {
        playerFunctions();
        deathReaperFunctions();
        passwordPillarFunctions();
        p.fill(178);
        p.text("What is the Key to your suffering?", 1055,65);


    }
    void playerFunctions() {
     player.runAbility();
     player.regainStamina();
     player.useStamina();


    }
void deathReaperFunctions() {
    deathReaper.drawDeathReaper();
    deathReaper.ReaperPillars();
    player.display();
    // Tilføj Circulation effect?


    }
    void passwordPillarFunctions() {
    if(pillars.size() < 8 )
        pillars.add(new PasswordPillar((int) p.random(0,1000), (int) p.random(0,1000),pillardiameter,player.position,player,p));

    for(int i=0; i< pillars.size(); i++) {
        pillars.get(i).display();
    }
    }
}
