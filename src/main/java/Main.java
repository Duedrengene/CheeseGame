import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Main extends PApplet {

    ArrayList<GridSpace> grid = new ArrayList<>();
    ArrayList<Furniture> furnitureList = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    ImageLoader imgLoad = new ImageLoader(this);
    ArrayList<Bullet> bullets = new ArrayList<>();
    GUI gUI;

    GridCreater gridCreate = new GridCreater();

    Inventory inventory;
    Shop shop;
    Dungeon dungeon;
    Location location;
    Player player;


    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(1000, 1000);
    }


    Camera camera = new Camera(this);


    public void setup() {

        super.setup();

        imgLoad.loadTheImages();
        inventory = new Inventory(this);
        player = new Player(this,bullets,inventory);
        grid = gridCreate.createGrid(width, height, this, imgLoad, inventory);
        shop = new Shop(furnitureList, grid);
        dungeon = new Dungeon(this,player,enemies);
        gUI = new GUI(this,player);
        location = new Location(shop, dungeon,gUI);
        inventory.furnitureList.add(new WallItem(imgLoad));
        inventory.furnitureList.add(new DoorItem(imgLoad));
    }

    @Override
    public void draw() {

        clear();
        background(0);
        player.draw();
        camera.changeAngle();
        location.functions();

    }




    public void keyPressed(){
        player.controls(key,keyCode,true,location.location);

    }

    public void keyReleased() {
        player.controls(key, keyCode, false,location.location);
    }


   public void mousePressed() {
        player.mouseControls(mouseX,mouseY, true,location.location,grid);

   }
   public void mouseReleased(){
        player.mouseControls(mouseX,mouseY,false,location.location,grid);

   }

}
