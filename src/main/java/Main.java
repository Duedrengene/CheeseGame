import processing.core.PApplet;

public class Main extends PApplet {


    public static void main(String[] args ) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(1000,1000);
    }

    Location location = new Location();
    Player player = new Player(this);
    Shop shop = new Shop();
    Types types = new Types();
    Furniture fur1 = new Furniture(this,types,types.furnitureTypes[0],5,5);

    @Override
    public void draw() {
        clear();
        background(0);
        player.draw();
        if (location.location.equals(shop)) {
            shop.shopFunction();

        }


    }


    public void keyPressed(){
        player.controls(key,keyCode,true);

    }

    public void keyReleased() {
        player.controls(key, keyCode, false);

    }
}
