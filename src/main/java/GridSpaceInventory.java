import processing.core.PApplet;

public class GridSpaceInventory extends GridSpace {



    GridSpaceInventory(float x, float y, float width, float height, PApplet p, ImageLoader imgLoad, Inventory inventory){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.p=p;
        this.imgLoad = imgLoad;
        this.inventory = inventory;

        hasFurniture = false;


    }

    @Override
    void function() {
    pressed    = !pressed;
    checkPress();
    }

    void changeGridType(Items newGridType){

        itemGridType = newGridType;

        switch (itemGridType) {

            case empty:{

                furniture = null;

            }break;

            case doorItem:{
                item= new DoorItem(imgLoad.door);

            }break;

            case cashRegisterItem:{
                item= new CashRegisterItem();

            }break;

            case shopCounterItem:{
                item = new ShopCounterItem();
            }break;

            case wallItem:{}
            item = new WallItem(imgLoad.wall);

        }

    }

    void checkPress(){
        int pressCount = 2;
        int[] gridSpaces = new int[2];
        for(int i = 0; i<inventory.inventoryGrid.size();i++){
            if(inventory.inventoryGrid.get(i).pressed) {
                pressCount--;
                gridSpaces[pressCount] = i;
            }
            if(pressCount ==0){
                inventory.move(gridSpaces[1],gridSpaces[0],inventory.itemList);
                inventory.inventoryGrid.get(gridSpaces[0]).pressed = false;
                inventory.inventoryGrid.get(gridSpaces[1]).pressed = false;

            }

        }

    }



}
