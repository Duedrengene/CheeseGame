import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Main extends PApplet {

    ArrayList<GridSpaceDefault> grid = new ArrayList<>();
    ArrayList<GridSpaceDefault> inventoryGrid = new ArrayList<>();
    ArrayList<Furniture> furnitureList = new ArrayList<>();

    ArrayList<PasswordPillar> pillars = new ArrayList<>();

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
    Deathrealm deathRealm;
    DeathReaper deathReaper;



    public static void main(String[] args) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(1920, 1080);
    }




    public void setup() {

        super.setup();

        imgLoad.loadTheImages();
        inventory = new Inventory(this);
        player = new Player(this,bullets,inventory,imgLoad);
        grid = gridCreate.createGrid(width, height, this, imgLoad, inventory,10,true,0);
        inventoryGrid = gridCreate.createGrid(500,500,this,imgLoad,inventory,5,false,250);
        shop = new Shop(furnitureList, grid);
        camera = new Camera(this,player.position,player);
        dungeon = new Dungeon(this,player,enemies,camera);
        gUI = new GUI(this,player);
        deathReaper = new DeathReaper(this,width/2,height/2,imgLoad);
        deathRealm = new Deathrealm(this,player, pillars, deathReaper);
        location = new Location(shop, dungeon,gUI, deathRealm);


        inventory.furnitureList.add(new WallItem(imgLoad.wall));
        inventory.furnitureList.add(new DoorItem(imgLoad.door));

    }

    @Override
    public void draw() {

        clear();
        background(0);
        //camera.changeAngle();
        location.functions(this);
        player.draw(inventoryGrid,location);
        //player.draw(location);
    }




    public void keyPressed(){
        player.controls(key,keyCode,true,location.location);

    }

    public void keyReleased() {
        player.controls(key, keyCode, false,location.location);
        camera.setPerspective(key,keyCode,false,location.location);
    }


   public void mousePressed() {
        player.mouseControls(mouseX,mouseY, true,location.location,grid);

   }
   public void mouseReleased(){
        player.mouseControls(mouseX,mouseY,false,location.location,grid);

   }

}
