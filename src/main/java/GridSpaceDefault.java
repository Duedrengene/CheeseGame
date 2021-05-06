import processing.core.PApplet;

public class GridSpaceDefault extends GridSpace{

GridSpaceDefault(){}

GridSpaceDefault(float x, float y, float width, float height, PApplet p, ImageLoader imgLoad, Inventory inventory){
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.p=p;
    this.imgLoad = imgLoad;
    this.inventory = inventory;

    hasFurniture = true;

}

    void changeGridType(FurnitureTypes newGridType){

        furnitureGridType = newGridType;

        switch (furnitureGridType) {

            case empty:{

                furniture = null;

            }break;

            case door:{
                furniture= new Door(imgLoad.door);

            }break;

            case cashRegister:{
                furniture= new CashRegister();

            }break;

            case shopCounter:{
                furniture = new ShopCounter();
            }break;

            case wall:{}
            furniture = new Wall(imgLoad.wall);

        }

    }

    void pressed(boolean check,float mX,float mY){
        if(check) {
            if(((mX <(x+width)) && ((x< mX)) )&& ((mY < y + height) && (mY > y))){
                function();
             }


        }

    }


    void function(){
        for (int i = 0; i<inventory.buildBarList.size();i++ )
            if(inventory.buildBarList.get(i).selected == true)
                if(furnitureGridType != inventory.furnitureList.get(i).getType())
                    changeGridType(inventory.furnitureList.get(i).getType());
                else
                    changeGridType(FurnitureTypes.empty);

    }









    }






