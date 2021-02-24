import processing.core.PApplet;

public class Main extends PApplet {

player.
    public static void main(String[] args ) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(1000,1000);
    }

    Player player = new Player(this);


    @Override
    public void draw() {
        clear();
        background(0);
        player.draw();
    }


    public void keyPressed(){

        player.controls(key,keyCode,true);
    }

    public void keyReleased() {

        player.controls(key, keyCode, false);
    }
}
