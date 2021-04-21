import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Main extends PApplet {

    ArrayList<GridSpace> grid = new ArrayList<>();
    ArrayList<Furniture> furnitureList = new ArrayList<>();
<<<<<<< HEAD
    ArrayList<Enemy> enemies = new ArrayList<>();
    ImageLoader imgLoad = new ImageLoader(this);
    ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<Integer> bulletpool = new ArrayList<>();

   int level;
   int DIAMETER = 80;
   int hastighed = 4;
=======
    GridCreater gridCreate = new GridCreater();
    ImageLoader imgLoad = new ImageLoader(this);

    Inventory inventory;
    Shop shop;
    Dungeon dungeon;
    Location location;
    Player player;
	int level;

>>>>>>> c71393e8418544b0a06014c17f13ab55e3506332

    int fjendeAmount=5;
    public static void main(String[] args ) {
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(1000,1000);
    }
<<<<<<< HEAD
    Shop shop;
    Dungeon dungeon;
    Location location;

    GUI gui;
=======
>>>>>>> c71393e8418544b0a06014c17f13ab55e3506332

    Camera  camera = new Camera(this);

    Player player = new Player(this,bullets);


    @Override
    public void setup() {
<<<<<<< HEAD
        super.setup();
        furnitureList.add(new Furniture(this,Types.shopCounter,50,50));
        shop = new Shop(furnitureList);
        location = new Location(shop,dungeon);
=======

>>>>>>> c71393e8418544b0a06014c17f13ab55e3506332
        imgLoad.loadTheImages();
         inventory = new Inventory(this);
        player =new Player(this,inventory);

        grid = gridCreate.createGrid(width,height,this,imgLoad,inventory);
        shop =new Shop(furnitureList,grid);
        location = new Location(shop,dungeon);
        shop =new Shop(furnitureList,grid);
        location = new Location(shop,dungeon);
        inventory.itemList.add(new WallItem(imgLoad));
        inventory.itemList.add(new DoorItem(imgLoad));
    }

    @Override
    public void draw() {

        clear();
        background(0);
<<<<<<< HEAD
        player.draw();

        camera.changeAngle();

        location.functions();
        if(enemies.size() < 5)
        enemies.add(new Enemy((int) random(0, 1000), (int) random(0, 1000), hastighed, DIAMETER,player.position,this,player));

        for(int i = 0;i<enemies.size();i++){
            enemies.get(i).update();
            enemies.get(i).display();


}

        }



=======
        location.functions();
        player.draw();
>>>>>>> c71393e8418544b0a06014c17f13ab55e3506332



    public void keyPressed(){
        player.controls(key,keyCode,true);

    }

    public void keyReleased() {
        player.controls(key, keyCode, false);
    }
<<<<<<< HEAD
   public void mousePressed() {
        player.mouseControls(mouseX,mouseY, true,location.location);

   }
   public void mouseReleased(){
        player.mouseControls(mouseX,mouseY,false,location.location);

   }

}
=======

    public void mousePressed(){
        for(int i = 0;i < grid.size();i++)
        grid.get(i).pressed(true,mouseX,mouseY,inventory);
        inventory.selector(true,mouseX,mouseY,inventory);

        }
        public void mouseReleased(){/*
            for(int i = 0;i < grid.size();i++)
               // grid.get(i).pressed(false,mouseX,mouseY);

*/
        }}
>>>>>>> c71393e8418544b0a06014c17f13ab55e3506332
