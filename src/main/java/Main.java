import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {

    ArrayList<FurnitureB> furnitureBList = new ArrayList<>();
    ArrayList<GridSpace> grid = new ArrayList<>();
    GridCreater gridCreate = new GridCreater();
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
        grid = gridCreate.createGrid(width,height,this);
        furnitureBList.add(new FurnitureB(this,Types.shopCounter,50,50));
        shop =new Shop(furnitureBList);
        location = new Location(shop,dungeon);

    }

    @Override
    public void draw() {
        clear();
        background(0);



        player.draw();
        location.functions();
        for(int i = 0;grid.size()>i;i++)
            grid.get(i).display();
            println(grid.size());


    }


    public void keyPressed(){
        player.controls(key,keyCode,true);

    }

    public void keyReleased() {
        player.controls(key, keyCode, false);

    }
}
