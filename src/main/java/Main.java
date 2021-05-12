import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;

import java.util.ArrayList;

public class Main extends PApplet {

    ArrayList<GridSpaceDefault> grid = new ArrayList<>();
    ArrayList<GridSpaceInventory> inventoryGrid = new ArrayList<>();
    ArrayList<Furniture> furnitureList = new ArrayList<>();
    ArrayList<FloatyText> textList = new ArrayList<>();
    ArrayList<PasswordPillar> pillars = new ArrayList<>();

    ArrayList<Enemy> enemies = new ArrayList<>();
    ImageLoader imgLoad = new ImageLoader(this);
    FontLoader fontLoad = new FontLoader(this);
    ArrayList<Bullet> bullets = new ArrayList<>();
    GUI gUI;

    GridCreater gridCreate = new GridCreater();
    FloatyText fT;

    StartMenu startMenu;
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
        fontLoad.loadFont();
        inventory = new Inventory(this,this);
        player = new Player(this,bullets,inventory,imgLoad,fontLoad);
        grid = gridCreate.createGrid(width, height, this, imgLoad, inventory,20,12,true,0,player);
        inventoryGrid = gridCreate.createGridInventory(500,500,this,imgLoad,inventory,5,5,false,250);
        shop = new Shop(furnitureList, grid);
        camera = new Camera(this,player.position,player);
        dungeon = new Dungeon(this,player,enemies,camera,imgLoad,this);
        gUI = new GUI(this,player,textList);
        deathReaper = new DeathReaper(this,width/2,height/2,imgLoad);
        deathRealm = new Deathrealm(this,player, pillars, deathReaper);
        startMenu = new StartMenu(this,player);
        location = new Location(shop, dungeon,gUI, deathRealm,startMenu);


        inventory.furnitureList.add(new WallItem(imgLoad.wall));
        inventory.furnitureList.add(new DoorItem(imgLoad.door));
        inventory.furnitureList.add(new ShopCounterItem(imgLoad.shopCounter));
        inventory.furnitureList.add(new CashRegisterItem(imgLoad.cashRegister));

    }

    @Override
    public void draw() {

        clear();
        textFont(fontLoad.georgiaFont);
        background(0);
        //camera.changeAngle();
        location.functions(this);
        player.draw(inventoryGrid,grid,location);

    //    System.out.println(inventoryGrid);
    }




    public void keyPressed(){
        player.controls(key,keyCode,true,location.location,camera);

    }

    public void keyReleased() {
        player.controls(key, keyCode, false,location.location,camera);
       // camera.setPerspective(key,keyCode,false,location.location);
    }


   public void mousePressed() {
        if(mouseButton == LEFT)
        player.mouseControls(mouseX,mouseY, true,location.location,grid,inventoryGrid,camera);

   }
   public void mouseReleased(){
       if(mouseButton == LEFT)
           player.mouseControls(mouseX,mouseY,false,location.location,grid,inventoryGrid,camera);

   }

}
