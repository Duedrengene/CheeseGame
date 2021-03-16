import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {

    ArrayList<Furniture> furnitureList = new ArrayList<>();
    ImageLoader imgLoad = new ImageLoader(this);


    public static void main(String[] args ) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(1000,1000);
    }
    Shop shop;
    Dungeon dungeon;
    Location location;
    Player player = new Player(this);





    @Override
    public void setup() {
        super.setup();
        furnitureList.add(new Furniture(this,Types.shopCounter,50,50));
        shop =new Shop(furnitureList);
        location = new Location(shop,dungeon);
        imgLoad.loadTheImages();
    }

    @Override
    public void draw() {
        clear();
        background(0);
        player.draw();
        location.functions();


    }


    public void keyPressed(){
        player.controls(key,keyCode,true);

    }

    public void keyReleased() {
        player.controls(key, keyCode, false);

    }
}
