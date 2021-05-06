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
    Camera camera;
    Deathrealm deathrealm;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(1000, 1000);
    }





    public void setup() {

        super.setup();

        imgLoad.loadTheImages();
        inventory = new Inventory(this);
        player = new Player(this,bullets,inventory);
        grid = gridCreate.createGrid(width, height, this, imgLoad, inventory);
        shop = new Shop(furnitureList, grid);

        camera = new Camera(this,player.position,player);
        dungeon = new Dungeon(this,player,enemies,camera);
        gUI = new GUI(this,player);

        deathrealm = new Deathrealm(this,player);
        location = new Location(shop, dungeon,gUI,deathrealm);

        inventory.furnitureList.add(new WallItem(imgLoad));
        inventory.furnitureList.add(new DoorItem(imgLoad));
    }

    @Override
    public void draw() {

        clear();
        background(0);
        player.draw();
        //camera.changeAngle();
        location.functions();

    }




    public void keyPressed(){
        player.controls(key,keyCode,true,location.location);

    }

    public void keyReleased() {
        player.controls(key, keyCode, false,location.location);
        camera.setPerspective(key,keyCode,keyPressed=false,location.location);
    }


   public void mousePressed() {
        player.mouseControls(mouseX,mouseY, true,location.location,grid);

   }
   public void mouseReleased(){
        player.mouseControls(mouseX,mouseY,false,location.location,grid);

   }

}
