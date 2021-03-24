import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {

    ArrayList<GridSpace> grid = new ArrayList<>();
    ArrayList<Furniture> furnitureList = new ArrayList<>();
    GridCreater gridCreate = new GridCreater();
    ImageLoader imgLoad = new ImageLoader(this);

    Shop shop;
    Dungeon dungeon;
    Location location;
    Player player = new Player(this);

    public static void main(String[] args ) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(1000,1000);
    }



    @Override
    public void setup() {

        grid = gridCreate.createGrid(width,height,this);
        shop =new Shop(furnitureList,grid);
        location = new Location(shop,dungeon);

    }

    @Override
    public void draw() {

        clear();
        background(0);
        location.functions();
        player.draw();



    }


    public void keyPressed(){
        player.controls(key,keyCode,true);

    }

    public void keyReleased() {
        player.controls(key, keyCode, false);
    }

    public void mousePressed(){
        for(int i = 0;i < grid.size();i++)
        grid.get(i).pressed(true,mouseX,mouseY);


        }
        public void mouseReleased(){
            for(int i = 0;i < grid.size();i++)
                grid.get(i).pressed(false,mouseX,mouseY);


        }



}
